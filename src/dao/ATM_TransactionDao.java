package dao;

import models.ATM_Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import static dao.Shared.con;

public class ATM_TransactionDao {

    public static void insertTransaction(ATM_Transaction trans) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            String qry = "INSERT INTO atm_transaction(transactionID, transactionDate, type, amount, sourceAcc, destinationAcc) " +
                    "VALUES (" + trans.getTransactionId() + ",'"
                    + sdf.format(trans.getTransDate()) + "','"
                    + trans.getType().name() + "',"
                    + trans.getAmount() + ","
                    + trans.getSourceCard().getCardNum() + ","
                    + (trans.getDestinationCard() == null ? null : trans.getDestinationCard().getCardNum()) + ")";
            Statement stmt = con.createStatement();
            stmt.execute(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

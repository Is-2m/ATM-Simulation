package dao;

import models.ATM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class ATMDao {
    static int[] atmIds = new int[]{371074367, 220043411, 369685821, 101290396, 113745628, 595971068, 249861076,
            370422311, 385937465, 415386598, 352698385, 211391656, 402588764, 195456624, 748101089, 431103273,
            357269384, 351332085};

    public static ATM getAtm() {
        int atmId = atmIds[new Random().nextInt(0, 17)];
        ATM atm = new ATM();
        try {

            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM atm WHERE idAtm= " + atmId;
            ResultSet res = stmt.executeQuery(qry);
            if (!isMyResultSetEmpty(res)) {
                while (res.next()) {
                    atm.setIdATM(res.getInt("idAtm"));
                    atm.setManagedBy(BankDao.getBank(res.getInt("bankID")));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atm;
    }
}

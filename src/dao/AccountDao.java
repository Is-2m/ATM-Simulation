package dao;

import models.Account;
import models.Bank;
import models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class AccountDao {

    public static Account getAccount(long accountNum) {
        try {
            Account account = null;
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM account WHERE accountNum= " + accountNum;
            ResultSet res = stmt.executeQuery(qry);
            if (!isMyResultSetEmpty(res)) {
                while (res.next()) {
                    account = new Account(
                            res.getLong("accountNum"),
                            res.getDouble("balance"),
                            CustomerDao.getCustomer(res.getInt("ownerID")),
                            BankDao.getBank(res.getInt("managedBy"))
                    );
                }
            }
            return account;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateAccount(Account acc) {
        try {
            String sql = "UPDATE account SET" +
                    " balance = " + acc.checkBalance() +
                    " WHERE accountNum=" + acc.getAccountNum();

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

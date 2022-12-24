package dao;

import models.ATM;
import models.Bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class BankDao {
    public static Bank getBank(int bankId) {
        try {
            Bank bank = null;
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM bank WHERE idBank= " + bankId;
            ResultSet res = stmt.executeQuery(qry);
            if (!isMyResultSetEmpty(res)) {
                while (res.next()) {
                    bank = new Bank(res.getInt("idBank"), res.getString("bankName"));
                }
            }
            return bank;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

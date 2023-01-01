package dao;

import models.Account;
import models.CardlessWithdrawal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class CardlessWithdrawalDao {

    public static CardlessWithdrawal getCardless(int referenceID) {
        try {
            CardlessWithdrawal cardless = null;
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM cardlesswithdrawl WHERE referenceID= " + referenceID;
            ResultSet res = stmt.executeQuery(qry);
            if (!isMyResultSetEmpty(res)) {
                while (res.next()) {
                    cardless = new CardlessWithdrawal(
                            res.getInt("referenceID"),
                            res.getInt("pinCode"),
                            res.getDouble("amount"),
                            res.getString("sender")
                    );
                }
            }
            return cardless;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCardless(int refId) {
        try {
            String sql = "UPDATE cardlesswithdrawl SET" +
                    " amount = " + 0 +
                    " WHERE referenceID=" + refId;

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

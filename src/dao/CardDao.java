package dao;

import models.Account;
import models.DebitCard;

import java.sql.*;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class CardDao {
    public CardDao() throws SQLException {
    }

    public static DebitCard getCard(long cardNum) {
        String qry = "select * from debitCard where cardNum =" + cardNum;
        Statement stmt = null;
        try {
            DebitCard card = null;
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(qry);
            if(!isMyResultSetEmpty(res)){
                while (res.next()) {
                     card = new DebitCard(
                            res.getLong("cardNum"),
                            res.getDate("expirationDate"),
                            res.getInt("cvc"),
                            res.getInt("pin"),
                             AccountDao.getAccount(res.getLong("accountNum"))
                    );
                }
            }
            return card;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateCard(DebitCard card){
        try {
            String sql = "UPDATE debitCard SET" +
                    " pin = " + card.getPin() +
                    " WHERE cardNum=" + card.getCardNum();

            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

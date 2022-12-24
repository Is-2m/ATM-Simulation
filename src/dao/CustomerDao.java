package dao;

import models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static dao.Shared.con;
import static dao.Shared.isMyResultSetEmpty;

public class CustomerDao {

    public static Customer getCustomer(int clientID) {
        try {
            Customer customer = null;
            Statement stmt = con.createStatement();
            String qry = "SELECT * FROM atm WHERE idAtm= " + clientID;
            ResultSet res = stmt.executeQuery(qry);
            if (!isMyResultSetEmpty(res)) {
                while (res.next()) {
                    customer = new Customer(
                            res.getInt("customerID"),
                            res.getString("name"),
                            res.getString("address"),
                            res.getDate("birthDate"));
                }
            }
            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

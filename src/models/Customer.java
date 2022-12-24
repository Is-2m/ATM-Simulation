package models;

import java.util.ArrayList;
import java.util.Date;

public class Customer {

    private int customerID;
    private String name;
    private String address;
    private Date birthDate;

    public Customer() {
    }

    public Customer(int customerID, String name, String address, Date birthDate) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getCustomerID() {
        return customerID;
    }

}

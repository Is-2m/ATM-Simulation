package dao;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Shared {
    public static String CardInfoScreen="../ui/CardInfoScreen.fxml";
    public static String CardPinScreen="../ui/CardPinScreen.fxml";
    public static String ChooseAmountScreen="../ui/ChooseAmountScreen.fxml";
    public static String LoginScreen="../ui/LoginScreen.fxml";
    public static String OperationChoosingScreen="../ui/OperationChoosingScreen.fxml";
    public static String PrintReceiptScreen="../ui/PrintReceiptScreen.fxml";
    public static String CardExpiredScreen="../ui/CardExpiredScreen.fxml";
//    public static String CardInfoScreen="../ui/CardInfoScreen.fxml";
//    public static String CardInfoScreen="../ui/CardInfoScreen.fxml";
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_atm_simulation", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static ATM currentATM;
    private static DebitCard currentCard;
    private static Bank currentBank;
    private static Account currentAccount;
    private static Customer currentCustomer;
    public static ATM getCurrentATM() {
        return currentATM;
    }

    public static void setCurrentATM(ATM currentATM) {
        Shared.currentATM = currentATM;
    }

    public static DebitCard getCurrentCard() {
        return currentCard;
    }

    public static void setCurrentCard(DebitCard currentCard) {
        Shared.currentCard = currentCard;
    }

    public static Bank getCurrentBank() {
        return currentBank;
    }

    public static void setCurrentBank(Bank currentBank) {
        Shared.currentBank = currentBank;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(Account currentAccount) {
        Shared.currentAccount = currentAccount;
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer currentCustomer) {
        Shared.currentCustomer = currentCustomer;
    }


    public static boolean isMyResultSetEmpty(ResultSet rs) throws SQLException {
        return (!rs.isBeforeFirst() && rs.getRow() == 0);
    }

    public static void customizeCurrentAtm(ImageView imgLogo, Label lbl_bankName) {
        Image logo = new Image(Shared.class.getResourceAsStream("..\\assets\\logos\\"+currentATM.getManagedBy().getBankName()+".png"));
        imgLogo.setImage(logo);
        lbl_bankName.setText(currentATM.getManagedBy().getBankName());
    }
}

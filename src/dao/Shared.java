package dao;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public abstract class Shared {
    public static String CardInfoScreen = "../ui/CardInfoScreen.fxml";
    public static String CardPinScreen = "../ui/CardPinScreen.fxml";
    public static String ChooseAmountScreen = "../ui/ChooseAmountScreen.fxml";
    public static String LoginScreen = "../ui/LoginScreen.fxml";
    public static String OperationChoosingScreen = "../ui/OperationChoosingScreen.fxml";
    public static String PrintReceiptScreen = "../ui/PrintReceiptScreen.fxml";
    public static String CardExpiredScreen = "../ui/CardExpiredScreen.fxml";
    public static String WrongAmountScreen = "../ui/WrongAmountScreen.fxml";
    public static String ShowBalanceScreen = "../ui/ShowBalanceScreen.fxml";
    public static String TransferToScreen = "../ui/TransferToScreen.fxml";
    public static String TakeUrMoneyScreen = "../ui/TakeUrMoneyScreen.fxml";
    public static String ThanksForVisitScreen = "../ui/ThanksForVisitScreen.fxml";
    public static String ChangePinScreen = "../ui/ChangePinScreen.fxml";
    public static String DoneUpdatingScreen = "../ui/DoneUpdatingScreen.fxml";
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
    private static TransactionType currentTransactionType;
    private static DebitCard destinationCard;
    private static ATM_Transaction currentTransaction;

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


    public static boolean isMyResultSetEmpty(ResultSet rs) throws SQLException {
        return (!rs.isBeforeFirst() && rs.getRow() == 0);
    }

    public static void customizeCurrentAtm(ImageView imgLogo, Label lbl_bankName) {
//        try {
        System.out.println("src\\assets\\logos\\" + currentATM.getManagedBy().getBankName().replaceAll(" ", "_") + ".png");
        System.out.println(currentATM.getManagedBy().getBankName());
        Image logo = new Image(Objects.requireNonNull(Shared.class.getResourceAsStream("..\\assets\\logos\\" + currentATM.getManagedBy().getBankName().replaceAll(" ", "_") + ".png")));
        imgLogo.setImage(logo);
        lbl_bankName.setText(currentATM.getManagedBy().getBankName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static TransactionType getCurrentTransactionType() {
        return currentTransactionType;
    }

    public static void setCurrentTransactionType(TransactionType transactionType) {
        Shared.currentTransactionType = transactionType;
    }

    public static DebitCard getDestinationCard() {
        return destinationCard;
    }

    public static void setDestinationCard(DebitCard destinationCard) {
        Shared.destinationCard = destinationCard;
    }

    public static ATM_Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public static void setCurrentTransaction(ATM_Transaction currentTransaction) {
        Shared.currentTransaction = currentTransaction;
    }
}

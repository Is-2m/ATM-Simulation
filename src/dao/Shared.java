package dao;

import controllers.NavigationController;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public abstract class Shared {
    public static String CardInfoScreen = "/ui/CardInfoScreen.fxml";
    public static String CardPinScreen = "/ui/CardPinScreen.fxml";
    public static String ChooseAmountScreen = "/ui/ChooseAmountScreen.fxml";
    public static String LoginScreen = "/ui/LoginScreen.fxml";
    public static String OperationChoosingScreen = "/ui/OperationChoosingScreen.fxml";
    public static String PrintReceiptScreen = "/ui/PrintReceiptScreen.fxml";
    public static String CardExpiredScreen = "/ui/CardExpiredScreen.fxml";
    public static String WrongAmountScreen = "/ui/WrongAmountScreen.fxml";
    public static String ShowBalanceScreen = "/ui/ShowBalanceScreen.fxml";
    public static String TransferToScreen = "/ui/TransferToScreen.fxml";
    public static String TakeUrMoneyScreen = "/ui/TakeUrMoneyScreen.fxml";
    public static String ThanksForVisitScreen = "/ui/ThanksForVisitScreen.fxml";
    public static String ChangePinScreen = "/ui/ChangePinScreen.fxml";
    public static String DoneUpdatingScreen = "/ui/DoneUpdatingScreen.fxml";
    public static String TransferRefScreen = "/ui/TransferRefScreen.fxml";
    public static String TransferPinScreen = "/ui/TransferPinScreen.fxml";
    public static String ReCheckScreen = "/ui/ReCheckScreen.fxml";
    public static String ConfirmAmountScreen = "/ui/ConfirmAmountScreen.fxml";
    public static String LostConnectionScreen = "/ui/LostConnectionScreen.fxml";

    static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_atm_simulation", "root", "");
        } catch (SQLException e) {
            try {
                Stage stage = new Stage();
                Font.loadFont(Shared.class.getResourceAsStream("./assets/fonts/poppins.ttf"), 16);
                Parent root = null;

                root = FXMLLoader.load(Objects.requireNonNull(Shared.class.getResource(Shared.LostConnectionScreen)));

                stage.setTitle("ATM Simulation");
                stage.setScene(new Scene(root));
                stage.setFullScreenExitHint("Please Press 'Esc' To Exit The Simulation And Close The App");
                stage.setFullScreen(true);

                stage.fullScreenProperty().addListener((ChangeListener) (o, oldVal, newVal) -> {
                    if (!(boolean) newVal) {
                        Platform.exit();
                    }
                });

//        stage.setResizable(false);
                stage.show();
                e.printStackTrace();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    private static ATM currentATM;
    private static DebitCard currentCard;
    private static TransactionType currentTransactionType;
    private static DebitCard destinationCard;
    private static ATM_Transaction currentTransaction;
    private static CardlessWithdrawal currentCardless;

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
        Image img = new Image("assets/logos/" + currentATM.getManagedBy().getBankName().replaceAll(" ", "_") + ".png");
        imgLogo.setImage(img);
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


    public static void setDestinationCard(DebitCard destinationCard) {
        Shared.destinationCard = destinationCard;
    }

    public static ATM_Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public static void setCurrentTransaction(ATM_Transaction currentTransaction) {
        Shared.currentTransaction = currentTransaction;
    }

    public static CardlessWithdrawal getCurrentCardless() {
        return currentCardless;
    }

    public static void setCurrentCardless(CardlessWithdrawal currentCardless) {
        Shared.currentCardless = currentCardless;
    }
}

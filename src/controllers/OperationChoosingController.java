package controllers;

import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.TransactionType;

import java.net.URL;
import java.util.ResourceBundle;

public class OperationChoosingController implements Initializable {
    @FXML
    Button btn_changePin;
    @FXML
    Button btn_checkBalance;
    @FXML
    Button btn_transferMoney;
    @FXML
    Button btn_withdrawCash;
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    boolean Mode;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
        visibilityController();
    }

    public void btn_cancel_Clicked(ActionEvent event) {
        NavigationController.navigateTo(Shared.ThanksForVisitScreen, (Node) event.getSource());

    }

    void visibilityController() {
        Mode =
                Shared.getCurrentCard().providesAccessTo().getManagedBy().getIdBank() ==
                        Shared.getCurrentATM().getManagedBy().getIdBank();
        if (!Mode) {
            btn_changePin.setVisible(false);
            btn_checkBalance.setVisible(false);
            btn_transferMoney.setVisible(false);
            btn_withdrawCash.setVisible(true);
        } else {
            btn_changePin.setVisible(true);
            btn_checkBalance.setVisible(true);
            btn_transferMoney.setVisible(true);
            btn_withdrawCash.setVisible(true);
        }
    }

    public void btn_checkBalance_Clicked(ActionEvent event) {
        NavigationController.navigateTo(Shared.ShowBalanceScreen, (Node) event.getSource());
    }

    public void btn_changePin_Clicked(ActionEvent event) {
        NavigationController.navigateTo(Shared.ChangePinScreen, (Node) event.getSource());
    }

    public void btn_withdrawCash_Clicked(ActionEvent event) {
        Shared.setCurrentTransactionType(TransactionType.WITHDRAWAL);
        NavigationController.navigateTo(Shared.ChooseAmountScreen, (Node) event.getSource());
    }

    public void btn_transferMoney_Clicked(ActionEvent event) {
        Shared.setCurrentTransactionType(TransactionType.TRANSFER);
        NavigationController.navigateTo(Shared.TransferToScreen, (Node) event.getSource());

    }
}

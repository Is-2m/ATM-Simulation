package controllers;

import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
        visibilityController();
    }

    public void btn_cancel_Clicked(ActionEvent event) {
        try {
            NavigationController.navigateTo(Shared.LoginScreen, (Node) event.getSource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void visibilityController() {
        boolean mode =
                Shared.getCurrentCard().getProvidesAccessTo().getManagedBy().getIdBank() ==
                        Shared.getCurrentATM().getManagedBy().getIdBank();
        if (!mode) {
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
}

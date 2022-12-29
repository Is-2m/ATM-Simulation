package controllers;

import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowBalanceController implements Initializable {

    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    Label lbl_balance;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
        lbl_balance.setText(String.valueOf(Shared.getCurrentCard().providesAccessTo().checkBalance())+" DH");
    }

    public void btn_Back_Clicked(ActionEvent event) {
        NavigationController.navigateTo(Shared.OperationChoosingScreen, (Node) event.getSource());
    }
}

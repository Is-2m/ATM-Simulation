package controllers;

import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import models.TransactionType;

public class CardExpiredController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }

    public void btn_Back_Clicked(ActionEvent event) {
        if (Shared.getCurrentTransactionType() == TransactionType.WITHDRAWAL) {
            NavigationController.navigateTo(Shared.OperationChoosingScreen, (Node) event.getSource());
        } else {
            NavigationController.navigateTo(Shared.ThanksForVisitScreen, (Node) event.getSource());
        }
    }
}

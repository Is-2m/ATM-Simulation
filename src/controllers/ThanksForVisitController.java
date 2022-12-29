package controllers;

import dao.Shared;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ThanksForVisitController implements Initializable {

    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

        Shared.setCurrentTransactionType(null);
        Shared.setCurrentTransaction(null);
        Shared.setCurrentCard(null);
        Shared.setDestinationCard(null);

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        NavigationController.navigateTo(Shared.LoginScreen, (Node) img_bankLogo);
                    }
                },
                3000
        );
    }
}

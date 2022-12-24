package controllers;

import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;

    public void btnLogWithCard_Clicked(ActionEvent e) {
        System.out.println("btnLogWithCard_Clicked");
    }

    public void btnLogWithoutCard_Clicked(ActionEvent e) {
        System.out.println("btnLogW/Card_Clicked");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

    }
}

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class mainController {
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
}

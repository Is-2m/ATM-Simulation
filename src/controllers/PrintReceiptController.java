package controllers;

import dao.Shared;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class PrintReceiptController implements Initializable {
    @FXML
    Button btn_no;
    @FXML
    Button btn_yes;

    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

    }
}

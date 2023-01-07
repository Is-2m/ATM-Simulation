package controllers;

import dao.CardDao;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import models.DebitCard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardPinController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    TextField txt_PinCode;
    @FXML
    Label lbl_tryAgain;
    int attempts = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

    }

    public void keyReleased(KeyEvent e) {
        if (!e.getCode().isDigitKey()) {
            txt_PinCode.setText(txt_PinCode.getText().replaceAll("[^\\d]", ""));
        }
        if (txt_PinCode.getLength() > 4) {
            txt_PinCode.setText(txt_PinCode.getText().substring(0, 4));
        }
        txt_PinCode.positionCaret(txt_PinCode.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.ThanksForVisitScreen, ((Node) e.getSource()));
    }

    public void btn_next_Clicked(ActionEvent event) {

        try {
            while (attempts < 3) {
                int pin = Integer.parseInt(txt_PinCode.getText());
                if (Shared.getCurrentCard().tryPin(pin)) {
                    NavigationController.navigateTo(Shared.OperationChoosingScreen, (Node) event.getSource());
                } else {
                    lbl_tryAgain.setVisible(true);
                    txt_PinCode.setText("");
                }
                attempts++;
            }
            NavigationController.navigateTo(Shared.CardExpiredScreen, (Node) event.getSource());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

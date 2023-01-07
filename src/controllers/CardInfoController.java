package controllers;

import dao.CardDao;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.DebitCard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CardInfoController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    Label lbl_tryAgain;
    @FXML
    TextField txt_CardNum;
    int attempts = 0;

    public void keyReleased(KeyEvent e) {
        if (!e.getCode().isDigitKey()) {
            txt_CardNum.setText(txt_CardNum.getText().replaceAll("[^\\d]", ""));
        }
        if (txt_CardNum.getLength() > 16) {
            txt_CardNum.setText(txt_CardNum.getText().substring(0, 15));
        }
        txt_CardNum.positionCaret(txt_CardNum.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.ThanksForVisitScreen, ((Node) e.getSource()));
    }

    public void btn_next_Clicked(ActionEvent event) {
        try {
            while (attempts < 3) {
                DebitCard card = CardDao.getCard(Long.valueOf(txt_CardNum.getText()));
                if (card != null) {
                    Shared.setCurrentCard(card);
                    NavigationController.navigateTo(Shared.CardPinScreen, ((Node) event.getSource()));
                } else {
                    lbl_tryAgain.setVisible(true);
                    txt_CardNum.setText("");
                }
                attempts++;
            }
            NavigationController.navigateTo(Shared.CardExpiredScreen, (Node) event.getSource());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

    }
}

package controllers;

import dao.CardDao;
import dao.CardlessWithdrawalDao;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import models.CardlessWithdrawal;
import models.DebitCard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransferRefController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    Label lbl_tryAgain;
    @FXML
    TextField txt_RefID;
    int attempts = 0;

    public void keyReleased(KeyEvent e) {
        if (!e.getCode().isDigitKey()) {
            txt_RefID.setText(txt_RefID.getText().replaceAll("[^\\d]", ""));
        }
        if (txt_RefID.getLength() > 10) {
            txt_RefID.setText(txt_RefID.getText().substring(0, 10));
        }
        txt_RefID.positionCaret(txt_RefID.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.ThanksForVisitScreen, ((Node) e.getSource()));
    }

    public void btn_next_Clicked(ActionEvent event) {
        try {
            while (attempts < 3) {
                CardlessWithdrawal cardless = CardlessWithdrawalDao.getCardless(Integer.valueOf(txt_RefID.getText()));
                if (cardless != null) {
                    Shared.setCurrentCardless(cardless);
                    NavigationController.navigateTo(Shared.TransferPinScreen, ((Node) event.getSource()));
                } else {
                    lbl_tryAgain.setVisible(true);
                    txt_RefID.setText("");
                }
                attempts++;
            }
            NavigationController.navigateTo(Shared.ReCheckScreen, (Node) event.getSource());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);

    }
}

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChangePinController implements Initializable {

    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    TextField txt_newPinConf;
    @FXML
    TextField txt_newPin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }

    public void keyReleased(KeyEvent e) {
        TextField txt = (TextField) ((Node) e.getSource());
        if (!e.getCode().isDigitKey()) {
            txt.setText(txt.getText().replaceAll("[^\\d]", ""));
        }
        if (txt.getLength() > 4) {
            txt.setText(txt.getText().substring(0, 3));
        }
        txt.positionCaret(txt.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.OperationChoosingScreen, ((Node) e.getSource()));
    }

    public void btn_next_Clicked(ActionEvent event) {
        Boolean isSame = Integer.parseInt(txt_newPinConf.getText()) == Integer.parseInt(txt_newPin.getText());
        if (!isSame) {
            txt_newPinConf.getStyleClass().add("redBorder");
            txt_newPin.getStyleClass().add("redBorder");
        } else {
            Shared.getCurrentCard().setPin(Integer.parseInt(txt_newPin.getText()));
            CardDao.updateCard(Shared.getCurrentCard());
            NavigationController.navigateTo(Shared.DoneUpdatingScreen, (Node) event.getSource());
        }
    }

}

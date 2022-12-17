package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.regex.Pattern;

public class CardInfoController {
    @FXML
    Button btn_Next;
    @FXML
    Button btn_cancel;
    @FXML
    TextField txt_CardNum;

    public void keyReleased(KeyEvent e) {
        if (!e.getCode().isDigitKey()) {
            txt_CardNum.setText(txt_CardNum.getText().replaceAll("[^\\d]", ""));
        }
        if (txt_CardNum.getLength() >= 16) {
            txt_CardNum.setText(txt_CardNum.getText().substring(0, 15));
        }
        txt_CardNum.positionCaret(txt_CardNum.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo("../ui/LoginScreen.fxml",((Node) e.getSource()));
    }
    public void btn_next_Clicked(ActionEvent event){

    }
}

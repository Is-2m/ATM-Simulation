package controllers;

import dao.ATM_TransactionDao;
import dao.AccountDao;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import models.ATM_Transaction;
import models.Account;
import models.TransactionType;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ChooseAmountController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    TextField txtAmount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }

    public void keyReleased(KeyEvent e) {
        if (!e.getCode().isDigitKey()) {
            txtAmount.setText(txtAmount.getText().replaceAll("[^\\d]", ""));
        }
        if (txtAmount.getLength() > 4) {
            txtAmount.setText(txtAmount.getText().substring(0, 4));
        }
        txtAmount.positionCaret(txtAmount.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent event) {
        NavigationController.navigateTo(Shared.OperationChoosingScreen, (Node) event.getSource());
    }

    public void btn_next_Clicked(ActionEvent event) {
        double amount = Double.parseDouble(txtAmount.getText());
        if (amount % 100 == 0) {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            String datetime = ft.format(dNow);
            ATM_Transaction transaction = new ATM_Transaction(datetime, dNow, Shared.getTransactionType(), amount, Shared.getCurrentCard().getProvidesAccessTo());
            if (transaction.update()) {
                ATM_TransactionDao.insertTransaction(transaction);
                AccountDao.updateAccount(transaction.getSourceAcc());
            }
        } else {
            NavigationController.navigateTo(Shared.WrongAmountScreen, (Node) event.getSource());
        }
    }

}

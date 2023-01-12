package controllers;

import dao.ATM_TransactionDao;
import dao.AccountDao;
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
import models.ATM_Transaction;
import models.DebitCard;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TransferToController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    TextField txtAmount;
    @FXML
    TextField txt_CardNum;
    @FXML
    Label lbl_tryAgain;
    int attempts = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }

    public void cardInfoTyping(KeyEvent event) {
        if (!event.getCode().isDigitKey()) {
            txt_CardNum.setText(txt_CardNum.getText().replaceAll("[^\\d]", ""));
        }
        if (txt_CardNum.getLength() > 16) {
            txt_CardNum.setText(txt_CardNum.getText().substring(0, 16));
        }
        txt_CardNum.positionCaret(txt_CardNum.getLength());
    }

    public void amountTyping(KeyEvent event) {
        if (!event.getCode().isDigitKey()) {
            txtAmount.setText(txtAmount.getText().replaceAll("[^\\d]", ""));
        }
        if (txtAmount.getLength() > 4) {
            txtAmount.setText(txtAmount.getText().substring(0, 4));
        }
        txtAmount.positionCaret(txtAmount.getLength());
    }

    public void btn_cancel_Clicked(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.OperationChoosingScreen, ((Node) e.getSource()));
    }

    public void btn_next_Clicked(ActionEvent event) {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            while (attempts < 3) {
                DebitCard card = CardDao.getCard(Long.valueOf(txt_CardNum.getText()));
                if (card != null) {
                    Shared.setDestinationCard(card);
                    txt_CardNum.getStyleClass().remove("redBorder");
                    if (amount % 100 == 0) {
                        Date dNow = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
                        String datetime = ft.format(dNow);
                        ATM_Transaction transaction = new ATM_Transaction(datetime, dNow, Shared.getCurrentTransactionType(), amount, Shared.getCurrentCard(), card);
                        if (transaction.update()) {
                            ATM_TransactionDao.insertTransaction(transaction);
                            AccountDao.updateAccount(transaction.getSourceCard().providesAccessTo());
                            AccountDao.updateAccount(transaction.getDestinationCard().providesAccessTo());
                            Shared.setCurrentTransaction(transaction);
                            NavigationController.navigateTo(Shared.PrintReceiptScreen, (Node) event.getSource());
                            break;
                        }
                    } else {
                        lbl_tryAgain.setVisible(true);
                        txtAmount.setText("");
                        txtAmount.getStyleClass().add("redBorder");
                    }
                } else {
                    lbl_tryAgain.setVisible(true);
                    txt_CardNum.setText("");
                    txt_CardNum.getStyleClass().add("redBorder");

                }
                attempts++;
            }
                NavigationController.navigateTo(Shared.CardExpiredScreen, (Node) event.getSource());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

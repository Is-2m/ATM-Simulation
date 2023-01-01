package controllers;

import dao.ATM_TransactionDao;
import dao.CardlessWithdrawalDao;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.ATM_Transaction;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ConfirmAmountController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    @FXML
    Label lbl_Amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
        lbl_Amount.setText(String.valueOf(Shared.getCurrentCardless().getAmount())+" DH");
    }

    public void btn_Back_Clicked(ActionEvent event) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);

        ATM_Transaction transaction = new ATM_Transaction(datetime,
                dNow,
                Shared.getCurrentTransactionType(),
                Shared.getCurrentCardless().getAmount(),
                null,
                null,
                Shared.getCurrentCardless().getReferenceID());
        Shared.setCurrentTransaction(transaction);
        CardlessWithdrawalDao.updateCardless(transaction.getReferenceID());
        ATM_TransactionDao.insertTransaction(transaction);
        NavigationController.navigateTo(Shared.PrintReceiptScreen, (Node) event.getSource());
    }
}

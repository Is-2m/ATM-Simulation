package controllers;

import com.itextpdf.html2pdf.HtmlConverter;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import models.TransactionType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
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

    public void btn_no_Clicked(ActionEvent event) {

        if (Shared.getCurrentTransactionType() == TransactionType.WITHDRAWAL || Shared.getCurrentTransactionType() == TransactionType.CARDLESS) {
            NavigationController.navigateTo(Shared.TakeUrMoneyScreen, (Node) event.getSource());
        } else if (Shared.getCurrentTransactionType() == TransactionType.TRANSFER) {
            NavigationController.navigateTo(Shared.ThanksForVisitScreen, (Node) event.getSource());
        }
    }

    public void btn_yes_Clicked(ActionEvent event) {
        String destCard =
                Shared.getCurrentTransaction().getDestinationCard() == null ? "" :
                        "#### #### #### " + String.valueOf(Shared.getCurrentTransaction().getDestinationCard().getCardNum()).substring(12, 16);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (Shared.getCurrentTransactionType() == TransactionType.CARDLESS) {
            printReceipt(
                    "assets/logos/" + Shared.getCurrentATM().getManagedBy().getBankName().replaceAll(" ", "_") + ".png",
                    Shared.getCurrentATM().getManagedBy().getBankName(),
                    sdf.format(Shared.getCurrentTransaction().getTransDate()),
                    String.valueOf(Shared.getCurrentATM().getIdATM()),
                    "",
                    Shared.getCurrentTransaction().getTransactionId(),
                    Shared.getCurrentTransaction().getType().toString(),
                    String.valueOf(Shared.getCurrentTransaction().getAmount()),
                    "",
                    "",
                    String.valueOf(Shared.getCurrentCardless().getReferenceID()),
                    Shared.getCurrentCardless().getSender());
        } else {
            printReceipt(
                    "assets/logos/" + Shared.getCurrentATM().getManagedBy().getBankName().replaceAll(" ", "_") + ".png",
                    Shared.getCurrentATM().getManagedBy().getBankName(),
                    sdf.format(Shared.getCurrentTransaction().getTransDate()),
                    String.valueOf(Shared.getCurrentATM().getIdATM()),
                    "#### #### #### " + String.valueOf(Shared.getCurrentCard().getCardNum()).substring(12, 16),
                    Shared.getCurrentTransaction().getTransactionId(),
                    Shared.getCurrentTransaction().getType().toString(),
                    String.valueOf(Shared.getCurrentTransaction().getAmount()),
                    destCard,
                    String.valueOf(Shared.getCurrentTransaction().getSourceCard().providesAccessTo().checkBalance()), "", ""
            );
        }
        if (Shared.getCurrentTransactionType() == TransactionType.WITHDRAWAL || Shared.getCurrentTransactionType() == TransactionType.CARDLESS) {
            NavigationController.navigateTo(Shared.TakeUrMoneyScreen, (Node) event.getSource());
        } else if (Shared.getCurrentTransactionType() == TransactionType.TRANSFER) {
            NavigationController.navigateTo(Shared.ThanksForVisitScreen, (Node) event.getSource());
        }
    }

    private void printReceipt(
            String imgLogo,
            String bankName,
            String txtDate,
            String txt_atmID,
            String txtCardNum,
            String txtTransID,
            String txtTransType,
            String txtAmount,
            String txtTransferredTo,
            String txtBalance,
            String txtRefID,
            String txtSender
    ) {
        try {
//            new File("/printing/receipt.html");
            File f = new File("receipt.html");
//            copyInputStreamToFile(this.getClass().getResourceAsStream("/printing/receipt.html"), f);
            File of = new File("receipt_" + txtTransID + ".pdf");
//            Document doc = Jsoup.parse(f);
            Document doc = Jsoup.parse(getReceiptString(this.getClass().getResourceAsStream("/printing/receipt.html")));
            System.out.println(img_bankLogo.getImage().getUrl());
            doc.getElementById("imgLogo").attr("src", imgLogo);
            doc.getElementById("bankName").text(bankName);
            doc.getElementById("txtDate").text("Date: " + txtDate);
            doc.getElementById("txt_atmID").text("ATM ID: " + txt_atmID);
            doc.getElementById("txtCardNum").text(txtCardNum);
            doc.getElementById("txtTransID").text(txtTransID);
            doc.getElementById("txtTransType").text(txtTransType);
            doc.getElementById("txtAmount").text(txtAmount + " DH");
            doc.getElementById("txtTransferredTo").text(txtTransferredTo);
            doc.getElementById("txtBalance").text(txtBalance + " DH");
            doc.getElementById("txtRefID").text(txtRefID);
            doc.getElementById("txtSender").text(txtSender);
            if (Shared.getCurrentTransactionType() == TransactionType.TRANSFER) {
                doc.getElementById("row_Sender").addClass("hidden");
                doc.getElementById("row_RefID").addClass("hidden");
                if (Shared.getCurrentATM().getManagedBy().getIdBank() !=
                        Shared.getCurrentCard().providesAccessTo().getManagedBy().getIdBank()) {
                    doc.getElementById("row_Balance").addClass("hidden");

                }
            } else if (Shared.getCurrentTransaction().getType() == TransactionType.WITHDRAWAL) {
                doc.getElementById("row_TransferredTo").addClass("hidden");
                doc.getElementById("row_Sender").addClass("hidden");
                doc.getElementById("row_RefID").addClass("hidden");
                if (Shared.getCurrentATM().getManagedBy().getIdBank() !=
                        Shared.getCurrentCard().providesAccessTo().getManagedBy().getIdBank()) {
                    doc.getElementById("row_Balance").addClass("hidden");

                }
            } else if (Shared.getCurrentTransaction().getType() == TransactionType.CARDLESS) {
                doc.getElementById("row_TransferredTo").addClass("hidden");
                doc.getElementById("row_CardNum").addClass("hidden");
                doc.getElementById("row_Balance").addClass("hidden");
                doc.getElementById("row_Balance").addClass("hidden");
            }
            FileOutputStream outputStream = new FileOutputStream(of);
            HtmlConverter.convertToPdf(doc.html(), outputStream);
            outputStream.close();
            Desktop.getDesktop().open(of);
            f.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getReceiptString(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

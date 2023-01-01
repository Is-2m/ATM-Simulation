package controllers;


import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;

    public void logWithCard(ActionEvent e)  {
        NavigationController.navigateTo(Shared.CardInfoScreen, ((Node) e.getSource()));
    }

    public void logCardless(ActionEvent e) {
        NavigationController.navigateTo(Shared.TransferRefScreen,(Node) e.getSource());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }
}

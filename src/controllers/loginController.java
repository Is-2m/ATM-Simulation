package controllers;


import com.sun.tools.javac.Main;
import dao.Shared;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {
    @FXML
    ImageView img_bankLogo;
    @FXML
    Label lbl_bankName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void logWithCard(ActionEvent e) throws IOException {
        NavigationController.navigateTo(Shared.CardInfoScreen, ((Node) e.getSource()));
    }

    public void logCardless(ActionEvent e) {
        System.out.println("sss2");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Shared.customizeCurrentAtm(img_bankLogo, lbl_bankName);
    }
}

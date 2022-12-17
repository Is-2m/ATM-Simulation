package controllers;


import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class loginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void logWithCard(ActionEvent e) throws IOException {
        NavigationController.navigateTo("../ui/CardInfoScreen.fxml",((Node) e.getSource()));
    }

    public void logCardless(ActionEvent e) {
        System.out.println("sss2");
    }
}

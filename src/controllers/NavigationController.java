package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationController {

    private static Stage stage;
    private static Scene scene;
    private static Parent root;

    public static void navigateTo(String pathFXML, Node node) throws IOException {
        root = FXMLLoader.load(NavigationController.class.getResource(pathFXML));
        stage = (Stage) node.getScene().getWindow();
        stage.getScene().setRoot(root);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}

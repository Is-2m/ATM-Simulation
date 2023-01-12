package controllers;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class LostConnectionController {

    public void btn_Restart_Clicked(ActionEvent event){
        try {
            Platform.exit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

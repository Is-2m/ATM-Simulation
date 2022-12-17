import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("./assets/fonts/poppins.ttf"), 16);
        Parent root = FXMLLoader.load(getClass().getResource("ui/LoginScreen.fxml"));
        Scene s = new Scene(root);
        stage.setTitle("ATM Simulation");
        stage.setScene(s);
//        stage.setMaximized(true);
        stage.setFullScreen(true);
        stage.fullScreenProperty().addListener((ChangeListener) (o, oldVal, newVal) -> {
            if(!(boolean) newVal){
                Platform.exit();
            }
        });
//        stage.setResizable(false);
        stage.show();

    }
}

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/Main.fxml"));
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

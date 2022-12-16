import javafx.application.Application;
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
        stage.setTitle("hellooooo");
        stage.setScene(s);
        stage.setMaximized(true);
//        stage.setFullScreen(true);
//        stage.setResizable(false);
        stage.show();

    }
}

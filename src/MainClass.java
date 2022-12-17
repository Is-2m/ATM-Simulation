import controllers.NavigationController;
import dao.ATMDao;
import dao.Shared;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainClass extends Application {
    private static NavigationController navigator = new NavigationController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Font.loadFont(getClass().getResourceAsStream("./assets/fonts/poppins.ttf"), 16);
            Parent root = FXMLLoader.load(getClass().getResource("ui/LoginScreen.fxml"));
            Scene s = new Scene(root);
            stage.setTitle("ATM Simulation");
            stage.setScene(s);
            stage.setFullScreen(true);
//            stage.fullScreenProperty().addListener((ChangeListener) (o, oldVal, newVal) -> {
//                if (!(boolean) newVal) {
//                    Platform.exit();
//                }
//            });
//        stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialise() {
        Shared.setCurrentATM(ATMDao.getAtm());
    }
}

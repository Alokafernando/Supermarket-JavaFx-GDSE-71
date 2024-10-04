package lk.ijse.gdse.fxproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/SignUpPage.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Super Market System");
        stage.show();
    }
}

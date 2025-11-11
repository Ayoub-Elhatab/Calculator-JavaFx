package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class CalculatorWidget extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image icon = new Image( Objects.requireNonNull(getClass().getResource("/icons/calculator.png")).toExternalForm());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/calculator.fxml")));
        stage.setScene(new Scene(root));
        stage.setTitle("Calculator");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

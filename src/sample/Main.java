package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("UserAdminPage.fxml"));

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setTitle("Buffalo Burger");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/image/Logo.png")));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

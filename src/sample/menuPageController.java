package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class menuPageController implements Initializable {
    @FXML private AnchorPane menuPagePane;

    //home button
    @FXML private Button homeButton;
    public void HomeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //burger page
    @FXML private Button burgerButton;
    public void BurgerPageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("BurgerPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //juice page
    @FXML private Button juiceButton;
    public void juicePageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("JuicePage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //coffee page
    @FXML private Button coffeeButton;
    public void coffeePageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CoffeePage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //cart page
    public void CartFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("CartPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UserAdminSettingsController {
    //home button
    @FXML private Button home;
    public void AdminHomeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UserAdminPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Burger button
    @FXML private Button burger;
    public void BurgerFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SetBurgerPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Drinks button
    @FXML private Button drink;
    public void DrinksFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SetJuicePage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Coffee button
    @FXML private Button coffee;
    public void CoffeeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("SetCoffeePage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

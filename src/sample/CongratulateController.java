package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CongratulateController implements Initializable {
    @FXML private AnchorPane page;

    //home button
    @FXML private Button homeButton;
    public void HomeFun(ActionEvent event) throws IOException {
        //set all the burger quantity = 0
        BurgerPageController burgerPageController = new BurgerPageController();
        burgerPageController.setBurger();
        //set all the juice quantity = 0
        JuicePageController juicePageController = new JuicePageController();
        juicePageController.setJuice();
        //set all the coffee quantity = 0
        CoffeePageController coffeePageController = new CoffeePageController();
        coffeePageController.setCoffee();


        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SetCoffeePageController implements Initializable {
    @FXML private TextField textField;
    @FXML private Label name;
    @FXML private ImageView imageView;
    @FXML private Label price;
    @FXML private Label available;
    @FXML private Button search;
    @FXML private Button back;

    //getCode Function
    public void getCode(ActionEvent event) throws FileNotFoundException {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        if(textField.getText().toString().equals("#Coffee1")){
            name.setText("Cafe Latte");
            //set image
            InputStream stream = new FileInputStream(PATH+"cafemocha.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT coffee1, coffee1P FROM setcoffee";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("coffee1").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("coffee1P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }

        else if(textField.getText().toString().equals("#Coffee2")){
            name.setText("Cappuccino");
            //set image
            InputStream stream = new FileInputStream(PATH+"Cappuccino.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT coffee2, coffee2P FROM setcoffee";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("coffee2").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("coffee2P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Coffee3")){
            name.setText("White Chocolate Mocha");
            //set image
            InputStream stream = new FileInputStream(PATH+"whitemocha.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT coffee3, coffee3P FROM setcoffee";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("coffee3").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("coffee3P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Coffee4")){
            name.setText("Expresso");
            //set image
            InputStream stream = new FileInputStream(PATH+"expresso.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT coffee4, coffee4P FROM setcoffee";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("coffee4").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("coffee4P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Coffee5")){
            name.setText("Americano");
            //set image
            InputStream stream = new FileInputStream(PATH+"americano.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT coffee5, coffee5P FROM setcoffee";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("coffee5").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("coffee5P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else{
            name.setText("Error Code");
            //set image
            InputStream stream = new FileInputStream(PATH+"error.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            available.setText("Example: #Coffee1");
            price.setText("Please insert Correct Code");
        }
    }

    //settings page
    public void settingsPageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UserAdminSettings.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //---------------coffee-------------------------------
    @FXML private TextField coffee1;
    @FXML private TextField coffee1p;
    @FXML private TextField coffee2;
    @FXML private TextField coffee2p;
    @FXML private TextField coffee3;
    @FXML private TextField coffee3p;
    @FXML private TextField coffee4;
    @FXML private TextField coffee4p;
    @FXML private TextField coffee5;
    @FXML private TextField coffee5p;

    //path for image file
    String PATH = "F:\\1. JavaFX Desktop Application Resources\\KUETprojectBuffalloBurger\\src\\image\\";

    @FXML private Button update;
    public void UpdatePage(ActionEvent event) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        //burger1
        if (coffee1.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee1 = '" + coffee1.getText() + "' WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (coffee1p.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee1P = " + Integer.parseInt(coffee1p.getText()) + " WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger2
        if (coffee2.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee2 = '" + coffee2.getText() + "' WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (coffee2p.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee2P = " + Integer.parseInt(coffee2p.getText()) + " WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger3
        if (coffee3.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee3 = '" + coffee3.getText() + "' WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (coffee3p.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee3P = " + Integer.parseInt(coffee3p.getText()) + " WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger4
        if (coffee4.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee4 = '" + coffee4.getText() + "' WHERE (idsetcoffee= 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (coffee4p.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee4P = " + Integer.parseInt(coffee4p.getText()) + " WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger5
        if (coffee5.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee5 = '" + coffee5.getText() + "' WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (coffee5p.getText().isBlank() == false) {
            String update = "UPDATE setcoffee SET coffee5P = " + Integer.parseInt(coffee5p.getText()) + " WHERE (idsetcoffee = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        UpdateButton();
    }

    public void UpdateButton(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Status...");
        alert.setHeaderText("Updated Successfully");
        alert.setContentText("Buffalo Burger  @Admin");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText("");
        price.setText("");
        available.setText("");


    }
}

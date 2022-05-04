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

public class SetJuicePageController implements Initializable {
    @FXML
    private TextField textField;
    @FXML private Label name;
    @FXML private ImageView imageView;
    @FXML private Label price;
    @FXML private Label available;
    @FXML private Button search;
   @FXML private Button back;

    //path for image file
    String PATH = "F:\\1. JavaFX Desktop Application Resources\\KUETprojectBuffalloBurger\\src\\image\\";

    //getCode Function
    public void getCode(ActionEvent event) throws FileNotFoundException {

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        if(textField.getText().toString().equals("#Drink1")){
            name.setText("Coca-Cola");
            //set image
            InputStream stream = new FileInputStream(PATH+"cocacola.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice1, juice1P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice1").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice1P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink2")){
            name.setText("Mirinda");
            //set image
            InputStream stream = new FileInputStream(PATH+"mirinda.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice2, juice2P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice2").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice2P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink3")){
            name.setText("Sprite");
            //set image
            InputStream stream = new FileInputStream(PATH+"7up.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice3, juice3P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice3").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice3P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink4")){
            name.setText("Orange Juice");
            //set image
            InputStream stream = new FileInputStream(PATH+"orange.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice4, juice4P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice4").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice4P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink5")){
            name.setText("Mango Juice");
            //set image
            InputStream stream = new FileInputStream(PATH+"mango.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice5, juice5P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice5").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice5P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink6")){
            name.setText("Lemon Mint");
            //set image
            InputStream stream = new FileInputStream(PATH+"lemonMint.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice6, juice6P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice6").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice6P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink7")){
            name.setText("Watermelon Juice");
            //set image
            InputStream stream = new FileInputStream(PATH+"watermelon.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice7, juice7P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice7").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice7P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink8")){
            name.setText("Oreo Chocolate Milkshake");
            //set image
            InputStream stream = new FileInputStream(PATH+"oreomilkshake.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice8, juice8P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice8").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice8P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink9")){
            name.setText("Kitkat Coffee Milkshake");
            //set image
            InputStream stream = new FileInputStream(PATH+"kitkatmilkshake.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice9, juice9P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice9").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice9P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Drink10")){
            name.setText("Velvet Strawberry MilkShake");
            //set image
            InputStream stream = new FileInputStream(PATH+"StrawberryMilkshake.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT juice10, juice10P FROM setjuice";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("juice10").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("juice10P") + " BDT");
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
            available.setText("Example: #Drink1");
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
    @FXML private TextField juicec1;
    @FXML private TextField juicec1p;
    @FXML private TextField juicec2;
    @FXML private TextField juicec2p;
    @FXML private TextField juicec3;
    @FXML private TextField juicec3p;
    @FXML private TextField juicec4;
    @FXML private TextField juicec4p;
    @FXML private TextField juicec5;
    @FXML private TextField juicec5p;

    @FXML private TextField juicec6;
    @FXML private TextField juicec6p;
    @FXML private TextField juicec7;
    @FXML private TextField juicec7p;
    @FXML private TextField juicec8;
    @FXML private TextField juicec8p;
    @FXML private TextField juicec9;
    @FXML private TextField juicec9p;
    @FXML private TextField juicec10;
    @FXML private TextField juicec10p;
    @FXML private Button update;
    public void UpdatePage(ActionEvent event) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();


        if (juicec1.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice1 = '" + juicec1.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec1p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice1P = " + Integer.parseInt(juicec1p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec2.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice2 = '" + juicec2.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec2p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice2P = " + Integer.parseInt(juicec2p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec3.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice3 = '" + juicec3.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec3p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice3P = " + Integer.parseInt(juicec3p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec4.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice4 = '" + juicec4.getText() + "' WHERE (idsetjuice= 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec4p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice4P = " + Integer.parseInt(juicec4p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec5.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice5 = '" + juicec5.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec5p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice5P = " + Integer.parseInt(juicec5p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec6.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice6 = '" + juicec6.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec6p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice6P = " + Integer.parseInt(juicec6p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec7.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice7 = '" + juicec7.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec7p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice7P = " + Integer.parseInt(juicec7p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec8.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice8 = '" + juicec8.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec8p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice8P = " + Integer.parseInt(juicec8p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec9.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice9 = '" + juicec9.getText() + "' WHERE (idsetjuice= 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec9p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice9P = " + Integer.parseInt(juicec9p.getText()) + " WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        if (juicec10.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice10 = '" + juicec10.getText() + "' WHERE (idsetjuice = 1)";
            try {
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if (juicec10p.getText().isBlank() == false) {
            String update = "UPDATE setjuice SET juice10P = " + Integer.parseInt(juicec10p.getText()) + " WHERE (idsetjuice = 1)";
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

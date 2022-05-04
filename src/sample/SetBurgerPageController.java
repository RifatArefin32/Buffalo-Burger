package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


public class SetBurgerPageController implements Initializable {
    @FXML private TextField textField;
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

        if(textField.getText().toString().equals("#Burger1")){
            name.setText("Special Naga Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"1.naga.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger1, burger1P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger1").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger1P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger2")){
            name.setText("BBQ Bacon Cheese Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"2.bbq.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger2, burger2P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger2").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger2P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger3")){
            name.setText("Double Patty Steak Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"3.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger3, burger3P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger3").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger3P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger4")){
            name.setText("Fried Meat Patty Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"4.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger4, burger4P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger4").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger4P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger5")){
            name.setText("Texas Hamburger");
            //set image
            InputStream stream = new FileInputStream(PATH+"6.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger5, burger5P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger5").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger5P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger6")){
            name.setText("Buffalo Special Sizzling Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"5.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger6, burger6P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger6").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger6P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger7")){
            name.setText("Mexican Burger");
            //set image
            InputStream stream = new FileInputStream(PATH+"7.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger7, burger7P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    if(queryResult.getString("burger7").equals("yes"))
                        available.setText("Available Now");
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger7P") + " BDT");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }
        else if(textField.getText().toString().equals("#Burger8")){
            name.setText("Buffalo Burger Family Combo");
            //set image
            InputStream stream = new FileInputStream(PATH+"8.burger.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
            //Data retrive from database
            String retrive = "SELECT burger8, burger8P FROM setburger";
            try{
                Statement statement = connectionNow.createStatement();
                ResultSet queryResult = statement.executeQuery(retrive);
                while (queryResult.next())
                {
                    System.out.println("Mahim");
                    if(queryResult.getString("burger8").equals("yes")) {
                        available.setText("Available Now");
                    }
                    else
                        available.setText("Not Available");
                    price.setText("Price: " + queryResult.getString("burger8P") + " BDT");
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
            available.setText("Example: #Burger1");
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

    //---------------Burger-------------------------------
    @FXML private TextField burger1;
    @FXML private TextField burger1p;
    @FXML private TextField burger2;
    @FXML private TextField burger2p;
    @FXML private TextField burger3;
    @FXML private TextField burger3p;
    @FXML private TextField burger4;
    @FXML private TextField burger4p;
    @FXML private TextField burger5;
    @FXML private TextField burger5p;
    @FXML private TextField burger6;
    @FXML private TextField burger6p;
    @FXML private TextField burger7;
    @FXML private TextField burger7p;
    @FXML private TextField burger8;
    @FXML private TextField burger8p;

    @FXML private Button update;
    public void UpdatePage(ActionEvent event){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        //burger1
        if(burger1.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger1 = '" + burger1.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger1p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger1P = " + Integer.parseInt(burger1p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger2
        if(burger2.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger2 = '" + burger2.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger2p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger2P = " + Integer.parseInt(burger2p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger3
        if(burger3.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger3 = '" + burger3.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger3p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger3P = " + Integer.parseInt(burger3p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger4
        if(burger4.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger4 = '" + burger4.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger4p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger4P = " + Integer.parseInt(burger4p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger5
        if(burger5.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger5 = '" + burger5.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger5p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger5P = " + Integer.parseInt(burger5p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger6
        if(burger6.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger6 = '" + burger6.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger6p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger6P = " + Integer.parseInt(burger6p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger7
        if(burger7.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger7 = '" + burger7.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger7p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger7P = " + Integer.parseInt(burger7p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        //burger8
        if(burger8.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger8 = '" + burger8.getText() + "' WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
        if(burger8p.getText().isBlank() == false)
        {
            String update = "UPDATE setburger SET burger8P = " + Integer.parseInt(burger8p.getText()) + " WHERE (idSetBurger = 1)";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(update);
            }catch (Exception e){
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

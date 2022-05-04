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
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class CoffeePageController implements Initializable {
    @FXML private AnchorPane coffeePage;

    //coffee page
    @FXML private Button coffee1;
    @FXML private Button coffee2;
    @FXML private Button coffee3;
    @FXML private Button coffee4;
    @FXML private Button coffee5;

    static Integer quantity1 = 0;
    static Integer quantity2 = 0;
    static Integer quantity3 = 0;
    static Integer quantity4 = 0;
    static Integer quantity5 = 0;



    String userID="";
    String billID="";

    static String price1="";
    static String price2="";
    static String price3="";
    static String price4="";
    static String price5="";
    public void setPrice(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT coffee1P, coffee2P, coffee3P, coffee4P, coffee5P  FROM setcoffee";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                price1 = queryResult.getString("coffee1P");
                price2 = queryResult.getString("coffee2P");
                price3 = queryResult.getString("coffee3P");
                price4 = queryResult.getString("coffee4P");
                price5 = queryResult.getString("coffee5P");

            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }

    //setQuantity
    public void setCoffee(){
        quantity1=0;
        quantity2=0;
        quantity3=0;
        quantity4=0;
        quantity5=0;
    }
    String rice1="";
    String rice2="";
    String rice3="";
    String rice4="";
    String rice5="";

    public void setCondition(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT coffee1, coffee2, coffee3, coffee4, coffee5 FROM setcoffee";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                rice1 = queryResult.getString("coffee1");
                rice2 = queryResult.getString("coffee2");
                rice3 = queryResult.getString("coffee3");
                rice4 = queryResult.getString("coffee4");
                rice5 = queryResult.getString("coffee5");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }


    //home button
    @FXML private Button homeButton;
    public void HomeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void Coffee1(ActionEvent event)
    {
        if(rice1.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity1.toString());
            dialog.setTitle("Cafe Latte");
            dialog.setHeaderText("Price :" + price1 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity1 = Integer.parseInt(cnt);
                    if(quantity1 > 50)
                    {
                        ErrorAlert();
                        quantity1 = 0;
                        return;
                    }
                }catch (NumberFormatException e){
                    ErrorAlert1();
                }
            }
        }
        else
            Alert();
    }
    public void Coffee2(ActionEvent event)
    {
        if(rice2.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity2.toString());
            dialog.setTitle("Cappuccino");
            dialog.setHeaderText("Price :" + price2 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity2 = Integer.parseInt(cnt);
                    if(quantity2 > 50)
                    {
                        ErrorAlert();
                        quantity2 = 0;
                        return;
                    }
                }catch (NumberFormatException e){
                    ErrorAlert1();
                }
            }
        }
        else
            Alert();

    }
    public void Coffee3(ActionEvent event)
    {
        if(rice3.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity3.toString());
            dialog.setTitle("White Chocolate Mocha");
            dialog.setHeaderText("Price :" + price3 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity3 = Integer.parseInt(cnt);
                    if(quantity3 > 50)
                    {
                        ErrorAlert();
                        quantity3 = 0;
                        return;
                    }
                }catch (NumberFormatException e){
                    ErrorAlert1();
                }
            }
        }
        else
            Alert();

    }
    public void Coffee4(ActionEvent event)
    {
        if(rice4.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity4.toString());
            dialog.setTitle("Expresso");
            dialog.setHeaderText("Price :" + price4 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity4 = Integer.parseInt(cnt);
                    if(quantity4 > 50)
                    {
                        ErrorAlert();
                        quantity4 = 0;
                        return;
                    }
                }catch (NumberFormatException e){
                    ErrorAlert1();
                }
            }
        }
        else
            Alert();

    }
    public void Coffee5(ActionEvent event)
    {
        if(rice5.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity5.toString());
            dialog.setTitle("Americano");
            dialog.setHeaderText("Price :" + price5 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity5 = Integer.parseInt(cnt);
                    if(quantity5 > 50)
                    {
                        ErrorAlert();
                        quantity5 = 0;
                        return;
                    }
                }catch (NumberFormatException e){
                    ErrorAlert1();
                }
            }
        }
        else
            Alert();
    }

    //userName Function
    public void getUserName()
    {
        homeController home = new homeController();
        userID = home.str;

    }
    //billID Function
    public void getBillID()
    {
        homeController home = new homeController();
        billID = home.billerID;
    }


    //error alert
    public void ErrorAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sorry !!");
        alert.setHeaderText("We can't take more than 50 orders for this item at a time");
        alert.setContentText("Please contact to us: \n 01881444519 \n 01174273108");
        alert.showAndWait();
    }
    public void ErrorAlert1(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !!");
        alert.setHeaderText("Invalid Input");
        alert.setContentText("Enter exact quantity in INTEGER form. e.g. 10 ");
        alert.showAndWait();
    }
    public void Alert(){
        Alert a2 = new Alert(Alert.AlertType.ERROR);
        a2.setTitle("Oppppss !!!!");
        a2.setHeaderText("NOT AVAILABLE");
        a2.setContentText("This product is not available now");
        a2.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCondition();
        setPrice();
        getUserName();
        getBillID();
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class BurgerPageController implements Initializable {
    @FXML private AnchorPane page;

    String userID="";
    String billID="";

    static Integer quantity1=0;
    static Integer quantity2=0;
    static Integer quantity3=0;
    static Integer quantity4=0;
    static Integer quantity5=0;
    static Integer quantity6=0;
    static Integer quantity7=0;
    static Integer quantity8=0;


    //set Quantity
    public void setBurger(){
        quantity1=0;
        quantity2=0;
        quantity3=0;
        quantity4=0;
        quantity5=0;
        quantity6=0;
        quantity7=0;
        quantity8=0;
    }

    static String price1="";
    static String price2="";
    static String price3="";
    static String price4="";
    static String price5="";
    static String price6="";
    static String price7="";
    static String price8="";
    public void setPrice(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT burger1P, burger2P, burger3P, burger4P, burger5P, burger6P, burger7P, burger8P FROM setburger";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                price1 = queryResult.getString("burger1P");
                price2 = queryResult.getString("burger2P");
                price3 = queryResult.getString("burger3P");
                price4 = queryResult.getString("burger4P");
                price5 = queryResult.getString("burger5P");
                price6 = queryResult.getString("burger6P");
                price7 = queryResult.getString("burger7P");
                price8 = queryResult.getString("burger8P");

            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }

    String rice1="";
    String rice2="";
    String rice3="";
    String rice4="";
    String rice5="";
    String rice6="";
    String rice7="";
    String rice8="";
    public void setCondition(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT burger1, burger2, burger3, burger4, burger5, burger6, burger7, burger8 FROM setburger";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                rice1 = queryResult.getString("burger1");
                rice2 = queryResult.getString("burger2");
                rice3 = queryResult.getString("burger3");
                rice4 = queryResult.getString("burger4");
                rice5 = queryResult.getString("burger5");
                rice6 = queryResult.getString("burger6");
                rice7 = queryResult.getString("burger7");
                rice8 = queryResult.getString("burger8");


            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }



    //home page
    @FXML private Button homeButton;
    public void HomeFun(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //burgers
    public void Burger1(ActionEvent event)
    {
        if(rice1.equals("yes")) {
            TextInputDialog dialog = new TextInputDialog(quantity1.toString());
            dialog.setTitle("Special Naga Spicy Burger");
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
    public void Burger2(ActionEvent event)
    {
        if(rice2.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity2.toString());
            dialog.setTitle("BBQ Bacon Cheese Burger");
            dialog.setHeaderText("Price :" + price2 + "BDT");
            dialog.setContentText("Quantity :");
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
    public void Burger3(ActionEvent event)
    {
        if(rice3.equals("yes"))
        {
            TextInputDialog dialog = new TextInputDialog(quantity3.toString());
            dialog.setTitle("Double Patty Steak Burger");
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
    public void Burger4(ActionEvent event)
    {
        if(rice4.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity4.toString());
            dialog.setTitle("Fried Meat Patty Burger");
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
    public void Burger5(ActionEvent event)
    {
        if(rice5.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity5.toString());
            dialog.setTitle("Texas Hamburger");
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
    public void Burger6(ActionEvent event)
    {
        if(rice6.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity6.toString());
            dialog.setTitle("Buffalo Special Sizzling Burger");
            dialog.setHeaderText("Price :" + price6 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity6 = Integer.parseInt(cnt);
                    if(quantity6 > 50)
                    {
                        ErrorAlert();
                        quantity6 = 0;
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
    public void Burger7(ActionEvent event)
    {
        if(rice7.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity7.toString());
            dialog.setTitle("Mexican Burger");
            dialog.setHeaderText("Price :" + price7 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity7 = Integer.parseInt(cnt);
                    if(quantity7 > 50)
                    {
                        ErrorAlert();
                        quantity7 = 0;
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
    public void Burger8(ActionEvent event)
    {
        if(rice8.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity8.toString());
            dialog.setTitle("Buffalo Burger Family Combo");
            dialog.setHeaderText("Price :" + price8 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity8 = Integer.parseInt(cnt);
                    if(quantity8 > 50)
                    {
                        ErrorAlert();
                        quantity8 = 0;
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
        getBillID();
        getUserName();
    }
}

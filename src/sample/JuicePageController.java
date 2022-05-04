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

public class JuicePageController implements Initializable {
    @FXML private AnchorPane juicePage;

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
    static Integer quantity9=0;
    static Integer quantity10=0;

    //setQuantity
    public void setJuice(){
        quantity1=0;
        quantity2=0;
        quantity3=0;
        quantity4=0;
        quantity5=0;
        quantity6=0;
        quantity7=0;
        quantity8=0;
        quantity9=0;
        quantity10=0;
    }

    static String price1="";
    static String price2="";
    static String price3="";
    static String price4="";
    static String price5="";
    static String price6="";
    static String price7="";
    static String price8="";
    static String price9="";
    static String price10="";
    public void setPrice(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT juice1P, juice2P, juice3P, juice4P, juice5P, juice6P, juice7P, juice8P, juice9P, juice10P  FROM setjuice";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                price1 = queryResult.getString("juice1P");
                price2 = queryResult.getString("juice2P");
                price3 = queryResult.getString("juice3P");
                price4 = queryResult.getString("juice4P");
                price5 = queryResult.getString("juice5P");
                price6 = queryResult.getString("juice6P");
                price7 = queryResult.getString("juice7P");
                price8 = queryResult.getString("juice8P");
                price9 = queryResult.getString("juice9P");
                price10 = queryResult.getString("juice10P");
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
    String rice9="";
    String rice10="";
    public void setCondition(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT juice1, juice2, juice3, juice4, juice5, juice6, juice7, juice8, juice9, juice10 FROM setjuice";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                rice1 = queryResult.getString("juice1");
                rice2 = queryResult.getString("juice2");
                rice3 = queryResult.getString("juice3");
                rice4 = queryResult.getString("juice4");
                rice5 = queryResult.getString("juice5");
                rice6 = queryResult.getString("juice6");
                rice7 = queryResult.getString("juice7");
                rice8 = queryResult.getString("juice8");
                rice9 = queryResult.getString("juice9");
                rice10 = queryResult.getString("juice10");
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



    //coke
    public void jc1(ActionEvent event)
    {

        if(rice1.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity1.toString());
            dialog.setTitle("Coca-Cola");
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
    //mirinda
    public void jc2(ActionEvent event)
    {
        if(rice2.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity2.toString());
            dialog.setTitle("Mirinda");
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
    //sprite
    public void jc3(ActionEvent event)
    {
        if(rice3.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity3.toString());
            dialog.setTitle("Sprite");
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
    //orange
    public void jc4(ActionEvent event)
    {
        if(rice4.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity4.toString());
            dialog.setTitle("Orange Juice");
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
    //mango
    public void jc5(ActionEvent event)
    {
        if(rice5.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity5.toString());
            dialog.setTitle("Mango Juice");
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
    //lemon mint
    public void jc6(ActionEvent event)
    {
        if(rice6.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity6.toString());
            dialog.setTitle("Lemon Mint");
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
    //watermelon
    public void jc7(ActionEvent event)
    {
        if(rice7.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity7.toString());
            dialog.setTitle("Watermelon Juice");
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
    //oreo
    public void jc8(ActionEvent event)
    {
        if(rice8.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity8.toString());
            dialog.setTitle("Oreo Chocolate Milkshake");
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
    //kitkat
    public void jc9(ActionEvent event)
    {
        if(rice9.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity9.toString());
            dialog.setTitle("Kitkat Coffee Milkshake");
            dialog.setHeaderText("Price :" + price9 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity9 = Integer.parseInt(cnt);
                    if(quantity9 > 50)
                    {
                        ErrorAlert();
                        quantity9 = 0;
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
    //strawberry
    public void jc10(ActionEvent event)
    {
        if(rice10.equals("yes")){
            TextInputDialog dialog = new TextInputDialog(quantity10.toString());
            dialog.setTitle("Velvet Strawberry MilkShake");
            dialog.setHeaderText("Price :" + price10 + "BDT");
            dialog.setContentText("Quantity: ");
            Optional<String> result2 = dialog.showAndWait();
            String cnt = "0";
            if(result2.isPresent()){
                cnt += result2.get();
                try{
                    quantity10 = Integer.parseInt(cnt);
                    if(quantity10 > 50)
                    {
                        ErrorAlert();
                        quantity10 = 0;
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

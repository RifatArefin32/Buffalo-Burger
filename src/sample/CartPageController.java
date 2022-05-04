package sample;

import com.mysql.cj.xdevapi.AddStatement;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartPageController implements Initializable {
    @FXML private AnchorPane cartPage;


    private Boolean paymentFlag = false;
//-------------------------------------data retrive------------------------------
    //Burger Data
    Integer quantity1=0;
    Integer quantity2=0;
    Integer quantity3=0;
    Integer quantity4=0;
    Integer quantity5=0;
    Integer quantity6=0;
    Integer quantity7=0;
    Integer quantity8=0;
    //unitPrice for burgers
    Integer quantity1p;
    Integer quantity2p;
    Integer quantity3p;
    Integer quantity4p;
    Integer quantity5p;
    Integer quantity6p;
    Integer quantity7p;
    Integer quantity8p;
    public void setBurgerPrice()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT burger1P, burger2P, burger3P, burger4P, burger5P, burger6P, burger7P, burger8P FROM setburger";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                quantity1p = queryResult.getInt("burger1P");
                quantity2p = queryResult.getInt("burger2P");
                quantity3p = queryResult.getInt("burger3P");
                quantity4p = queryResult.getInt("burger4P");
                quantity5p = queryResult.getInt("burger5P");
                quantity6p = queryResult.getInt("burger6P");
                quantity7p = queryResult.getInt("burger7P");
                quantity8p = queryResult.getInt("burger8P");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getBurgerData()
    {
        BurgerPageController burgerPageController = new BurgerPageController();
        quantity1 = burgerPageController.quantity1;
        quantity2 = burgerPageController.quantity2;
        quantity3 = burgerPageController.quantity3;
        quantity4 = burgerPageController.quantity4;
        quantity5 = burgerPageController.quantity5;
        quantity6 = burgerPageController.quantity6;
        quantity7 = burgerPageController.quantity7;
        quantity8 = burgerPageController.quantity8;
    }
    public void BurgerEntryFun()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        //inserting the values in the database
        String insertField = "INSERT INTO burger(burger1, burger2, burger3, burger4, burger5, burger6, burger7, burger8, userID, bill) VALUES ('";
        String insertValues = quantity1 + "','" + quantity2 + "','" + quantity3 + "','" + quantity4 + "','" + quantity5 + "','"
                + quantity6 + "','" + quantity7 + "','" + quantity8 + "','" + userID + "','" + billID + "')";
        String insertToRegister = insertField + insertValues;
        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(insertToRegister);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    //Juice Data
    Integer jquantity1 = 0;
    Integer jquantity2 = 0;
    Integer jquantity3 = 0;
    Integer jquantity4 = 0;
    Integer jquantity5 = 0;
    Integer jquantity6 = 0;
    Integer jquantity7 = 0;
    Integer jquantity8 = 0;
    Integer jquantity9 = 0;
    Integer jquantity10 = 0;
    //unit price
    Integer jquantity1p;
    Integer jquantity2p;
    Integer jquantity3p;
    Integer jquantity4p;
    Integer jquantity5p;
    Integer jquantity6p;
    Integer jquantity7p;
    Integer jquantity8p;
    Integer jquantity9p;
    Integer jquantity10p;
    public void setJuicePrice()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT juice1P, juice2P, juice3P, juice4P, juice5P, juice6P, juice7P, juice8P, juice9P, juice10P  FROM setjuice";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                jquantity1p = queryResult.getInt("juice1P");
                jquantity2p = queryResult.getInt("juice2P");
                jquantity3p = queryResult.getInt("juice3P");
                jquantity4p = queryResult.getInt("juice4P");
                jquantity5p = queryResult.getInt("juice5P");
                jquantity6p = queryResult.getInt("juice6P");
                jquantity7p = queryResult.getInt("juice7P");
                jquantity8p = queryResult.getInt("juice8P");
                jquantity9p = queryResult.getInt("juice9P");
                jquantity10p = queryResult.getInt("juice10P");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getJuiceData()
    {
        JuicePageController juicePageController = new JuicePageController();
        jquantity1 = juicePageController.quantity1;
        jquantity2 = juicePageController.quantity2;
        jquantity3 = juicePageController.quantity3;
        jquantity4 = juicePageController.quantity4;
        jquantity5 = juicePageController.quantity5;
        jquantity6 = juicePageController.quantity6;
        jquantity7 = juicePageController.quantity7;
        jquantity8 = juicePageController.quantity8;
        jquantity9 = juicePageController.quantity9;
        jquantity10 = juicePageController.quantity10;
    }
    public void JuiceEntryFun()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        //inserting the values in the database
        String insertField = "INSERT INTO juice(juice1, juice2, juice3, juice4, juice5, juice6, juice7, juice8, juice9, juice10, userID, bill) VALUES ('";
        String insertValues = jquantity1 + "','" + jquantity2 + "','" + jquantity3 + "','" + jquantity4 + "','" + jquantity5 + "','"
                + jquantity6 + "','" + jquantity7 + "','" + jquantity8 + "','" + jquantity9 + "','" + jquantity10 + "','" + userID + "','" + billID + "')";
        String insertToRegister = insertField + insertValues;

        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(insertToRegister);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    //coffee data
    Integer cquantity1 = 0;
    Integer cquantity2 = 0;
    Integer cquantity3 = 0;
    Integer cquantity4 = 0;
    Integer cquantity5 = 0;
    //unit price
    Integer cquantity1p;
    Integer cquantity2p;
    Integer cquantity3p;
    Integer cquantity4p;
    Integer cquantity5p;
    public void setCoffeePrice()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String retrive = "SELECT coffee1P, coffee2P, coffee3P, coffee4P, coffee5P  FROM setcoffee";
        try{
            Statement statement = connectionNow.createStatement();
            ResultSet queryResult = statement.executeQuery(retrive);
            while (queryResult.next())
            {
                cquantity1p = queryResult.getInt("coffee1P");
                cquantity2p = queryResult.getInt("coffee2P");
                cquantity3p= queryResult.getInt("coffee3P");
                cquantity4p = queryResult.getInt("coffee4P");
                cquantity5p = queryResult.getInt("coffee5P");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getCoffeeData()
    {
        CoffeePageController coffeePageController = new CoffeePageController();
        cquantity1 = coffeePageController.quantity1;
        cquantity2 = coffeePageController.quantity2;
        cquantity3 = coffeePageController.quantity3;
        cquantity4 = coffeePageController.quantity4;
        cquantity5 = coffeePageController.quantity5;
    }
    public void CoffeeEntryFun()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        //inserting the values in the database
        String insertField = "INSERT INTO coffee(coffee1, coffee2, coffee3, coffee4, coffee5, userID, bill) VALUES ('";
        String insertValues = cquantity1 + "','" + cquantity2 + "','" + cquantity3 + "','" + cquantity4 + "','" + cquantity5 + "','" + userID + "','" + billID + "')";
        String insertToRegister = insertField + insertValues;

        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(insertToRegister);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

//-----------------------------------------end of data retrive----------------------------------

//-----------------------------------table view --------------------------------------------------
    @FXML private TableView<Customer> tableView;
    @FXML private TableColumn<Customer, SimpleStringProperty> nameOfItems;
    @FXML private TableColumn<Customer, Integer> quantity;
    @FXML private TableColumn<Customer, Integer> unitPrice;
    @FXML private TableColumn<Customer, Integer> netPrice;
    Boolean flag = true;
    public ObservableList<Customer> getOrder(){
        ObservableList<Customer> customers = tableView.getItems();
        String name;
        Integer num;
        Integer unitP;
        Integer netP;
        Integer totalCost = 0;

        //Burgers
        if(quantity1 != 0)
        {
            name = "Special Naga Spicy Burger";
            num = quantity1;
            unitP = quantity1p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
            flag = false;
        }
        if(quantity2 != 0)
        {
            name = "BBQ Bacon Cheese Burger";
            num = quantity2;
            unitP = quantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
            flag = false;
        }
        if(quantity3 != 0)
        {
            name = "Double Patty Steak Burger";
            num = quantity3;
            unitP = quantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(quantity4 != 0)
        {
            name = "Fried Meat Patty Burger";
            num = quantity4;
            unitP = quantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(quantity5 != 0)
        {
            name = "Texas Hamburger";
            num = quantity5;
            unitP = quantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(quantity6 != 0)
        {
            name = "Buffalo Burger Family Combo";
            num = quantity6;
            unitP = quantity6p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(quantity7 != 0)
        {
            name = "Mexican Burger";
            num = quantity7;
            unitP = quantity7p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(quantity8 != 0)
        {
            name = "Buffalo Special Sizzling Burger";
            num = quantity8;
            unitP = quantity8p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }

        //Juice
        if(jquantity1 != 0)
        {
            name = "Coca-Cola";
            num = jquantity1;
            unitP = jquantity1p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity2 != 0)
        {
            name = "Mirinda";
            num = jquantity2;
            unitP = jquantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity3 != 0)
        {
            name = "Sprite";
            num = jquantity3;
            unitP = jquantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity4 != 0)
        {
            name = "Orange Juice";
            num = jquantity4;
            unitP = jquantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity5 != 0)
        {
            name = "Mango Juice";
            num = jquantity5;
            unitP = jquantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity6 != 0)
        {
            name = "Lemon Mint";
            num = jquantity6;
            unitP = jquantity6p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity7 != 0)
        {
            name = "Watermelon Juice";
            num = jquantity7;
            unitP = jquantity7p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity8 != 0)
        {
            name = "Oreo Chocolate Milkshake";
            num = jquantity8;
            unitP = jquantity8p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity9 != 0)
        {
            name = "Kitkat Coffee Milkshake";
            num = jquantity9;
            unitP = jquantity9p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(jquantity10 != 0)
        {
            name = "Velvet Strawberry MilkShake";
            num = jquantity10;
            unitP = jquantity10p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }

        //coffee
        if(cquantity1 != 0)
        {
            name = "Cafe Latte";
            num = cquantity1;
            unitP = cquantity1p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(cquantity2 != 0)
        {
            name = "Cappuccino";
            num = cquantity2;
            unitP = cquantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(cquantity3 != 0)
        {
            name = "White Chocolate Mocha";
            num = cquantity3;
            unitP = cquantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(cquantity4 != 0)
        {
            name = "Expresso";
            num = cquantity4;
            unitP = cquantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(cquantity5 != 0)
        {
            name = "Americano";
            num = cquantity5;
            unitP = cquantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP)); flag = false;
        }
        if(flag)
            HomePageButton.setDisable(true);

        netCost.setText("Total: "+ totalCost.toString() + "  BDT");
        return customers;
    }


    //--------------------------------------Information portion-------------------------
    //Information box
    @FXML private Label Name;
    @FXML private Label PhoneNo;
    @FXML private Label Area;
    @FXML private Label Address;
    @FXML private Label BillID;

    String userID;
    String billID;
    String date;
    String area;
    String phoneNum;
    @FXML private Label netCost;

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
    //Date and Time Function
    public void getDate()
    {
        homeController home = new homeController();
        date = home.DateNTime;
    }
    //customer info
    public void CustomerInfo()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String selectInfo = "SELECT Firstname, Lastname, PhoneNumber, Area, Address FROM user_accounts WHERE userID = " + "'" +  userID + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(selectInfo);
            while (queryResult.next())
            {
                Name.setText(queryResult.getString("FirstName") + " " + queryResult.getString("Lastname"));
                PhoneNo.setText(queryResult.getString("PhoneNumber"));
                phoneNum = PhoneNo.getText();
                Area.setText(queryResult.getString("Area"));
                area = queryResult.getString("Area");
                Address.setText(queryResult.getString("Address"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        BillID.setText(billID);
    }

    //payment methods
    @FXML private Button cod;
    @FXML private Button bkash;
    @FXML private Button rocket;
    @FXML private Button master;
    @FXML private Button visa;
    @FXML private Button nagad;

    Integer Bkash = 0;
    Integer Rocket = 0;
    Integer Nagad = 0;
    Integer COD= 0;
    Integer Visa = 0;
    Integer Master = 0;
    String trnsID = "N/A";



    public void DisablePayment(){
        bkash.setDisable(true);
        rocket.setDisable(true);
        nagad.setDisable(true);
        cod.setDisable(true);
        visa.setDisable(true);
        master.setDisable(true);
    }
    public void InsertPayment(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String payment = "INSERT INTO payment (bkash, rocket, nagad, cod, visa, mastercard, bill, transactionID) VALUES (" +
                Bkash + ", " +
                Rocket + ", " +
                Nagad + ", " +
                COD + ", " +
                Visa + ", " +
                Master + ", '" + billID + "', '"  + trnsID + "')";
        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(payment);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }



    public void BkashFun(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Bkash");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType1){
            TextInputDialog dialog = new TextInputDialog("Enter your transaction ID");
            dialog.setTitle("Bkash");
            dialog.setHeaderText("Payment: 01881445919");
            dialog.setContentText("WARNING: Your transaction ID should be checked before confirming your order.");
            Optional<String> result2 = dialog.showAndWait();
            if(result2.isPresent()){
                trnsID = result2.get();
                Bkash = 1;
                InsertPayment();
                DisablePayment();
                paymentFlag = true;
            }
        }
    }
    public void NagadFun(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Nagad");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType1){

            TextInputDialog dialog = new TextInputDialog("Enter your transaction ID");
            dialog.setTitle("Nagad");
            dialog.setHeaderText("Payment: 01881445919");
            dialog.setContentText("Warning: Your transaction ID should be checked before confirming your order.");
            Optional<String> result2 = dialog.showAndWait();
            if(result2.isPresent()){
                trnsID = result2.get();
                Nagad = 1;
                InsertPayment();
                DisablePayment();
                paymentFlag = true;
            }
        }

    }
    public void RocketFun(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Rocket");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType1){

            TextInputDialog dialog = new TextInputDialog("Enter your transaction ID");
            dialog.setTitle("Rocket");
            dialog.setHeaderText("Payment: 01881445919");
            dialog.setContentText("Warning: Your transaction ID should be checked before confirming your order.");
            Optional<String> result2 = dialog.showAndWait();
            if(result2.isPresent()){
                trnsID = result2.get();
                Rocket = 1;
                InsertPayment();
                DisablePayment();
                paymentFlag = true;
            }
        }

    }
    public void CODFun(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Cash On Delivery");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType1) {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Buffalo Burger");
            alert1.setHeaderText("Cash On Delivery");
            alert1.setContentText("Keep your payment ready.");
            ButtonType buttonType3 = ButtonType.OK;
            alert1.getButtonTypes().setAll(buttonType3);
            alert1.showAndWait();
            COD = 1;
            InsertPayment();
            DisablePayment();
            paymentFlag = true;
        }
    }
    public void MasterFun(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Master Card");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType1) {

            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Buffalo Burger");
            alert1.setHeaderText("Master Card");
            alert1.setContentText("You can pay your payment through POS during delivery");
            ButtonType buttonType3 = ButtonType.OK;
            alert1.getButtonTypes().setAll(buttonType3);
            alert1.showAndWait();
            Master = 1;
            InsertPayment();
            DisablePayment();
            paymentFlag = true;
        }
    }
    public void VisaFun(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("You are going to payment through Visa Card");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType1) {
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Buffalo Burger");
            alert1.setHeaderText("Visa Card");
            alert1.setContentText("You can pay your payment through POS during delivery");
            ButtonType buttonType3 = ButtonType.OK;
            alert1.getButtonTypes().setAll(buttonType3);
            alert1.showAndWait();
            Visa = 1;
            InsertPayment();
            DisablePayment();
            paymentFlag = true;
        }
        else
            return;
    }

//--------------------------------------confirmation section---------------------------------------
    //Confirmation function

    public void notificationEntryFun()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();

        //inserting the values in the database
        String insertField = "Insert into notification (OrderTime, BillID, Area, UserID) values ('";
        String insertValues = date + "','" + billID + "','" + area + "','" + userID + "')";
        String insertToRegister = insertField + insertValues;
        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(insertToRegister);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML private Button HomePageButton;
    public void HomeFun(ActionEvent event) throws IOException
    {
        if(paymentFlag)
        {
            //database insert
            BurgerEntryFun();
            JuiceEntryFun();
            CoffeeEntryFun();
            notificationEntryFun();

            Parent parent1 = FXMLLoader.load(getClass().getResource("Congratulate.fxml"));
            Scene scene1 = new Scene(parent1);
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage1.setScene(scene1);
            stage1.show();

            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Hey " + Name.getText() + "  !!!");
            a2.setHeaderText("Please check your mobile phone.\n" +
                    "An order confirmation SMS will send to  " + phoneNum + ".\n");
            a2.setContentText("WARNING :   This SMS is too much important to ensure your order confirmation.");
            StringWriter sw = new StringWriter();
            sw.append("Hello " + Name.getText() + " , \n");
            sw.append("Thanks for ordering here. \n\n");
            sw.append("Your bill id:   '"+ billID + "' \n\n");
            sw.append("Your payment method and transaction id (if applicable) should be checked\n");
            sw.append("before confirming your order.\n");
            sw.append("We will send a order confirmation SMS to  " + phoneNum + " immediately\n");
            sw.append("**  If you need any help, please to contact with us  **");
            TextArea textArea = new TextArea(sw.toString());
            a2.getDialogPane().setExpandableContent(textArea);
            a2.showAndWait();
        }
        else
        {
            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Warning");
            a2.setHeaderText("Payment Not Selected");
            a2.setContentText("You have to select your payment method before " +  " 'Confirm ORDER' ");
            a2.showAndWait();
        }
    }
    @FXML private Button CancelButton;
    public void CancelFun(ActionEvent event) throws IOException
    {
        //set all the burger quantity = 0
        BurgerPageController burgerPageController = new BurgerPageController();
        burgerPageController.setBurger();
        //set all the juice quantity = 0
        JuicePageController juicePageController = new JuicePageController();
        juicePageController.setJuice();
        //set all the coffee quantity = 0
        CoffeePageController coffeePageController = new CoffeePageController();
        coffeePageController.setCoffee();



        Parent parent = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML private Button MenuButton;
    public void MenuFun(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //get customer info
        Name.setText("");
        PhoneNo.setText("");
        Area.setText("");
        Address.setText("");
        BillID.setText("");
        netCost.setText("");
//--------------------------------------------------------------------------------------
        getUserName();
        getBillID();
        getDate();
//------------------------------------------------------------------------------------------
        CustomerInfo();
//-------------------------------------------------------------------------------------
        setBurgerPrice();
        setJuicePrice();
        setCoffeePrice();
//-------------------------------------------------------------------------------------------
        //get food items
        getBurgerData();
        getCoffeeData();
        getJuiceData();

        //table view
        nameOfItems.setCellValueFactory(new PropertyValueFactory<Customer, SimpleStringProperty>("nameOfItems"));
        quantity.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("quantity"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("unitPrice"));
        netPrice.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("netPrice"));
        tableView.setItems(getOrder());






    }
}

package sample;

import javafx.beans.property.SimpleStringProperty;
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
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;



public class UserAdminOrderPageController implements Initializable {
    //-------------------------------------data retrive------------------------------
    //Burger Data
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

    //path for image file
    String PATH = "F:\\1. JavaFX Desktop Application Resources\\KUETprojectBuffalloBurger\\src\\image\\";

    public void getBurgerData()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT * FROM burger where bill = '" + billID + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                quantity1 = queryResult.getInt("burger1");
                quantity2 = queryResult.getInt("burger2");
                quantity3 = queryResult.getInt("burger3");
                quantity4 = queryResult.getInt("burger4");
                quantity5 = queryResult.getInt("burger5");
                quantity6 = queryResult.getInt("burger6");
                quantity7 = queryResult.getInt("burger7");
                quantity8 = queryResult.getInt("burger8");
                //tableView.setItems(getOrder());
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getBurgerPrice()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT burger1P, burger2P, burger3P, burger4P, burger5P, burger6P, burger7P, burger8P FROM setburger";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
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
    public void getJuiceData()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT * FROM juice where bill = '" + billID + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                jquantity1 = queryResult.getInt("juice1");
                jquantity2 = queryResult.getInt("juice2");
                jquantity3 = queryResult.getInt("juice3");
                jquantity4 = queryResult.getInt("juice4");
                jquantity5 = queryResult.getInt("juice5");
                jquantity6 = queryResult.getInt("juice6");
                jquantity7 = queryResult.getInt("juice7");
                jquantity8 = queryResult.getInt("juice8");
                jquantity9 = queryResult.getInt("juice9");
                jquantity10 = queryResult.getInt("juice10");
                //tableView.setItems(getOrder());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getJuicePrice()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT juice1P, juice2P, juice3P, juice4P, juice5P, juice6P, juice7P, juice8P, juice9P, juice10P FROM setjuice";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
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
                //tableView.setItems(getOrder());
            }
        }catch (Exception e)
        {
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
    public void getCoffeeData()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT * FROM coffee where bill = '" + billID + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                cquantity1 = queryResult.getInt("coffee1");
                cquantity2 = queryResult.getInt("coffee2");
                cquantity3 = queryResult.getInt("coffee3");
                cquantity4 = queryResult.getInt("coffee4");
                cquantity5 = queryResult.getInt("coffee5");
                //tableView.setItems(getOrder());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void getCoffeePrice()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT coffee1P, coffee2P, coffee3P, coffee4P, coffee5P FROM setcoffee";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                cquantity1p = queryResult.getInt("coffee1P");
                cquantity2p = queryResult.getInt("coffee2P");
                cquantity3p = queryResult.getInt("coffee3P");
                cquantity4p = queryResult.getInt("coffee4P");
                cquantity5p = queryResult.getInt("coffee5P");
                //tableView.setItems(getOrder());
            }
        }catch (Exception e)
        {
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
        }
        if(quantity2 != 0)
        {
            name = "BBQ Bacon Cheese Burger";
            num = quantity2;
            unitP = quantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity3 != 0)
        {
            name = "Double Patty Steak Burger with BBQ sauce";
            num = quantity3;
            unitP = quantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity4 != 0)
        {
            name = "Fried Meat Patty Burger";
            num = quantity4;
            unitP = quantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity5 != 0)
        {
            name = "Texas Hamburger";
            num = quantity5;
            unitP = quantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity6 != 0)
        {
            name = "Buffalo Burger Family Combo";
            num = quantity6;
            unitP = quantity6p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity7 != 0)
        {
            name = "Mexican Burger";
            num = quantity7;
            unitP = quantity7p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(quantity8 != 0)
        {
            name = "Buffalo Special Sizzling Burger";
            num = quantity8;
            unitP = quantity8p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }

        //Juice
        if(jquantity1 != 0)
        {
            name = "Coca-Cola";
            num = jquantity1;
            unitP = jquantity1p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity2 != 0)
        {
            name = "Mirinda";
            num = jquantity2;
            unitP = jquantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity3 != 0)
        {
            name = "Sprite";
            num = jquantity3;
            unitP = jquantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity4 != 0)
        {
            name = "Orange Juice";
            num = jquantity4;
            unitP = jquantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity5 != 0)
        {
            name = "Mango Juice";
            num = jquantity5;
            unitP = jquantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity6 != 0)
        {
            name = "Lemon Mint";
            num = jquantity6;
            unitP = jquantity6p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity7 != 0)
        {
            name = "Watermelon Juice";
            num = jquantity7;
            unitP = jquantity7p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity8 != 0)
        {
            name = "Oreo Chocolate Milkshake";
            num = jquantity8;
            unitP = jquantity8p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity9 != 0)
        {
            name = "Kitkat Coffee Milkshake";
            num = jquantity9;
            unitP = jquantity9p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(jquantity10 != 0)
        {
            name = "Velvet Strawberry MilkShake";
            num = jquantity10;
            unitP = jquantity10p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }

        //coffee
        if(cquantity1 != 0)
        {
            name = "Cafe Latte";
            num = cquantity1;
            unitP = cquantity1p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(cquantity2 != 0)
        {
            name = "Cappuccino";
            num = cquantity2;
            unitP = cquantity2p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(cquantity3 != 0)
        {
            name = "White Chocolate Mocha";
            num = cquantity3;
            unitP = cquantity3p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(cquantity4 != 0)
        {
            name = "Expresso";
            num = cquantity4;
            unitP = cquantity4p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
        if(cquantity5 != 0)
        {
            name = "Americano";
            num = cquantity5;
            unitP = cquantity5p;
            netP = num*unitP;
            totalCost += netP;
            customers.add(new Customer(name, num, unitP, netP));
        }
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

    static String userID;
    static String billID;
    static String date;
    static String area;
    @FXML private Label netCost;


    public void initData1(String dat, String bill, String are, String id){
        date = dat;
        billID = bill;
        area = are;
        userID = id;
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

    Integer bkash;
    Integer nagad;
    Integer rocket;
    Integer cod;
    Integer visa;
    Integer masterd;
    String transID;
    @FXML private Label name;
    @FXML private Label id;
    @FXML private ImageView imageView;


    public void getPayementBox() throws FileNotFoundException {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        //retrive data from database
        String verifyLogin = "SELECT bkash, rocket, nagad, cod, visa, mastercard, transactionID FROM payment where bill = '" + billID + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                bkash = queryResult.getInt("bkash");
                rocket = queryResult.getInt("rocket");
                nagad = queryResult.getInt("nagad");
                cod = queryResult.getInt("cod");
                visa = queryResult.getInt("visa");
                masterd = queryResult.getInt("mastercard");
                transID = queryResult.getString("transactionID");
                id.setText(transID);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

        if(bkash == 1){
            name.setText("BKash");
            InputStream stream = new FileInputStream(PATH+"bkash.png");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
        else if(rocket == 1){
            name.setText("Rocket");
            InputStream stream = new FileInputStream(PATH+"rocket.png");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
        else if(nagad == 1){
            name.setText("Nagad");
            InputStream stream = new FileInputStream(PATH+"nagad.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
        else if(cod == 1){
            name.setText("Cash On Delivery");
            InputStream stream = new FileInputStream(PATH+"cod.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
        else if(masterd == 1){
            name.setText("Masterd Card");
            InputStream stream = new FileInputStream(PATH+"masstercard.png");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
        else if(visa == 1){
            name.setText("Visa Card");
            InputStream stream = new FileInputStream(PATH+"visa.jpg");
            Image image = new Image(stream);
            imageView.setImage(image);
        }
    }
//--------------------------------------confirmation section---------------------------------------
    //Ready to deliver function
    @FXML private Button Ready;
    public void ReadyFun(ActionEvent event) throws IOException
    {
        //warning
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Buffalo Burger");
        alert.setHeaderText("Are you sure ? ");
        alert.setContentText("This order data will be deleted. ");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType1)
        {
            // DeleteNotificationFun();
            tableView.getItems().clear();
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectionNow = connection.getConnection();
            //deleting all the elements from burger
            String DeleteBurger = "DELETE FROM burger WHERE bill= '" + billID + "'";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(DeleteBurger);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
            //deleting all the elements from coffee
            String DeleteCoffee = "DELETE FROM coffee WHERE bill= '" + billID + "'";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(DeleteCoffee);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
            //deleting all the elements from juice
            String DeleteJuice = "DELETE FROM juice WHERE bill= '" + billID + "'";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(DeleteJuice);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
            //deleting all the elements from notification
            String DeleteNotification = "DELETE FROM notification WHERE BillID= '" + billID + "'";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(DeleteNotification);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
            //deleting all the elements from payment
            String DeletePayment = "DELETE FROM payment WHERE bill= '" + billID + "'";
            try{
                Statement statement = connectionNow.createStatement();
                statement.executeUpdate(DeletePayment);
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }



        }


    }
    @FXML private Button BackButton;
    public void BackFun(ActionEvent event) throws IOException
    {
        Parent parent = FXMLLoader.load(getClass().getResource("UserAdminFindUser.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        userID = null;
        billID = null;
        date = null;
        area = null;

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
        CustomerInfo();

        //get food items
        getBurgerData();
        getBurgerPrice();
        getCoffeeData();
        getCoffeePrice();
        getJuiceData();
        getJuicePrice();

        try {
            getPayementBox();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //table view
        nameOfItems.setCellValueFactory(new PropertyValueFactory<Customer, SimpleStringProperty>("nameOfItems"));
        quantity.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("quantity"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("unitPrice"));
        netPrice.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("netPrice"));
        tableView.setItems(getOrder());
    }
}

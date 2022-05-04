package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.net.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

   static Boolean flag = false;
    //home button
    @FXML private Button homeButton;
    public void HomeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //Register button function
    @FXML private Button registerButton;
    @FXML private Button done;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField phoneNumber;
    @FXML private ComboBox area;
    @FXML private TextField address;
    @FXML private TextField userID;
    @FXML private PasswordField password;
    @FXML private PasswordField confirmPassword;

    public void DoneFun(ActionEvent event) throws IOException {
        if(firstName.getText().isBlank() == true || lastName.getText().isBlank() == true || phoneNumber.getText().isBlank() == true
                || address.getText().isBlank() == true || userID.getText().isBlank() == true
                || password.getText().isBlank() == true || confirmPassword.getText().isBlank() == true )
        {
            ErrorAlert();
            return;
        }
        if(area.getValue().toString().equals("Choose your current location inside Dhaka"))
        {
            ErrorAlert();
            return;
        }
        if(phoneNumber.getText().length() != 11)
        {
            NumberError();return;
        }
        if(password.getText().equals(confirmPassword.getText()))
        {
            ConfirmationFun(event);
        }
        else
           ErrorAlertFun2();
    }

    public void RegisterNowFun(ActionEvent event){
        if(flag == true){
            RegisterFun();
        }
        else
            DoneButtonFirst();
    }
    public void RegisterFun()
    {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionNow = connection.getConnection();
        String FirstName = firstName.getText();
        String LastName = lastName.getText();
        String PhoneNumber = phoneNumber.getText();
        String Area = area.getValue().toString();
        String Address = address.getText();
        String UserID = userID.getText();
        String Password = password.getText();

        //inserting the values in the database
        String insertField = "INSERT INTO user_accounts (Firstname, Lastname, PhoneNumber, Area, Address, userID, Password) VALUES ('";
        String insertValues = FirstName + "','" + LastName + "','" + PhoneNumber + "','" + Area + "','" + Address + "','" + UserID + "','" + Password + "')";
        String insertToRegister = insertField + insertValues;

        try{
            Statement statement = connectionNow.createStatement();
            statement.executeUpdate(insertToRegister);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        registerButton.setDisable(true);
    }

    //validate UserID
    public void validateUserID()
    {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM user_accounts WHERE UserID = '" + userID.getText() + "'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                if(queryResult.getInt(1)==1)
                    ErrorAlertFun();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void ErrorAlertFun(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning !!!! ");
        alert.setHeaderText("UserID exists");
        alert.setContentText("The userID you used here is currently exists. Please try another unique one");
        alert.showAndWait();
    }


    //error passward alert
    public void ErrorAlertFun2(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !!! ");
        alert.setHeaderText("Password doesn't matched.");
        alert.setContentText("Enter similar password.");
        alert.showAndWait();
    }
    public void ErrorAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error !!! ");
        alert.setHeaderText("Information missing");
        alert.setContentText("Please fill up the form properly");
        alert.showAndWait();
    }
    public void NumberError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !!! ");
        alert.setHeaderText("Invalid number");
        alert.setContentText("Please enter your number with 11 digits");
        alert.showAndWait();
    }
    public void ConfirmationFun(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm");
        alert.setHeaderText("Congratulations...!!");
        alert.setContentText("You are ready to register now");
        ButtonType buttonType1 = ButtonType.OK;
        ButtonType buttonType2 = ButtonType.CANCEL;
        alert.getButtonTypes().setAll(buttonType1, buttonType2);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonType2)
        {
            flag = false;
            firstName.setText("");
            lastName.setText("");
            phoneNumber.setText("");
            area.setValue("Choose your current location inside Dhaka");
            address.setText("");
            userID.setText("");
            password.setText("");
            confirmPassword.setText("");
            return;
        }
        else
            flag = true;
    }
    public void DoneButtonFirst(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("You have to confirm your information first");
        alert.setContentText("Press 'Confirm' for confirmation");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //area combobox
        area.setValue("Choose your current location inside Dhaka");
        //Choose your current location (inside Dhaka only)
        area.getItems().addAll("Mirpur", "Uttara", "Banani", "Gulshan", "Dhanmondi");
    }
}

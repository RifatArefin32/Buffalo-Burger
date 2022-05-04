package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;


public class homeController implements Initializable {

    static String str;
    static String billerID;
    static String DateNTime;

    @FXML private AnchorPane homePane;
    //cancel button function
    @FXML private Button cancelButton;
    //private ResultSet ResultSetqueryResult;
    public void CancelFunction(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //login section
    @FXML private TextField userName;
    @FXML private PasswordField password;
    @FXML private Button enter;
    public void LoginFun(ActionEvent event) {
        if(userName.getText().isBlank() == true || password.getText().isBlank() == true){
            WarningAlertFun();
        }else {

            if(userName.getText().toString().equals("admin") && password.getText().equals("1234"))
            {
                try {
                    AdminPageFun(event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
                validateLogin(event);
        }
    }
    public void validateLogin(ActionEvent event) {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM user_accounts WHERE UserID = '" +userName.getText()+ "' AND Password = '" +password.getText() +"'";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                if(queryResult.getInt(1)==1)
                {

                    str = userName.getText();
                    BillerIDCreator();
                    userPageFun(event);
                }
                else
                    ErrorAlertFun();
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void userPageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //admin page
    public void AdminPageFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UserAdminPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //Signup section
    @FXML private Button signUp;
    public void SignUpPage(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    //alert functions
    public void WarningAlertFun(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Buffalo Burger");
        a.setContentText("Enter username and password.");
        a.setHeaderText("Be Careful !!!!!!!!");
        a.showAndWait();
    }
    public void ErrorAlertFun(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Buffalo Burger");
        a.setContentText("Invalid login. Please try again");
        a.setHeaderText("Error Password or UserName");
        a.showAndWait();
    }
    //date and time
    @FXML private Label time;
    @FXML private Label date;
    public void initialize() {
        Timeline clock = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            time.setText(LocalDateTime.now().format(formatter));
            date.setText(LocalDateTime.now().format(formatter1));

        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    //Biller ID creator
    public void BillerIDCreator() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmssddMMyyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        billerID = str+formatter.format(now);
        DateNTime = formatter1.format(now);
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        initialize();
    }
}

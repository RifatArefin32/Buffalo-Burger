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
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserAdminFindUserController implements Initializable {
    //home button
    @FXML private Button home;
    public void AdminHomeFun(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UserAdminPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
//--------------------------------------------------------------------------------
    //data retrive from notification database
    String adminBillID;
    String adminDateTime;
    String adminArea;
    String adminUserID;

    public void DataRetrive(){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();
        String verifyLogin = "select * from notification";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next())
            {
                adminDateTime = queryResult.getString("OrderTime");
                adminBillID = queryResult.getString("BillID");
                adminArea = queryResult.getString("Area");
                adminUserID = queryResult.getNString("UserID");
                admintableView.setItems(getTable());
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    //----------------------------------------table view-----------------------------------------
    @FXML private TableView<Notification> admintableView;
    @FXML private TableColumn<Notification, SimpleStringProperty> OrderTime;
    @FXML private TableColumn<Notification, SimpleStringProperty> BillID;
    @FXML private TableColumn<Notification, SimpleStringProperty> Area;
    @FXML private TableColumn<Notification, SimpleStringProperty> UserID;


    public ObservableList<Notification> getTable(){
        ObservableList<Notification> notifications = admintableView.getItems();
        notifications.add(new Notification(adminDateTime, adminBillID, adminArea, adminUserID));
        return notifications;
    }



    //details of notification
    @FXML private Button Select;
    public void DetailsFun(ActionEvent event) throws IOException {
        Notification notification = admintableView.getSelectionModel().getSelectedItem();
        UserAdminOrderPageController orderPageController = new UserAdminOrderPageController();
        orderPageController.initData1(
                notification.getOrderTime(),
                notification.getBillID(),
                notification.getArea(),
                notification.getUserID() );
        //---------------------------------------------------------------------------
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UserAdminOrderPage.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        //access the controller and call a method
        //UserAdminOrderPageController controller = loader.getController();
        //controller.initData(admintableView.getSelectionModel().getSelectedItem());
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    //--------------------------------------Main Function----------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataRetrive();
        //table view
        OrderTime.setCellValueFactory(new PropertyValueFactory<Notification, SimpleStringProperty>("OrderTime"));
        BillID.setCellValueFactory(new PropertyValueFactory<Notification, SimpleStringProperty>("BillID"));
        Area.setCellValueFactory(new PropertyValueFactory<Notification, SimpleStringProperty>("Area"));
        UserID.setCellValueFactory(new PropertyValueFactory<Notification, SimpleStringProperty>("UserID"));
        //delete
        admintableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}

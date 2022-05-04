package sample;


import javafx.beans.property.SimpleStringProperty;

public class Notification {
    private SimpleStringProperty OrderTime;
    private SimpleStringProperty BillID;
    private SimpleStringProperty Area;
    private SimpleStringProperty UserID;

    public Notification(String orderTime, String billID, String area, String userID) {
        OrderTime = new SimpleStringProperty(orderTime);
        BillID = new SimpleStringProperty(billID);
        Area = new SimpleStringProperty(area);
        UserID = new SimpleStringProperty(userID);
    }

    public String getOrderTime() {
        return OrderTime.get();
    }

    public SimpleStringProperty orderTimeProperty() {
        return OrderTime;
    }

    public void setOrderTime(String orderTime) {
        this.OrderTime.set(orderTime);
    }

    public String getBillID() {
        return BillID.get();
    }

    public SimpleStringProperty billIDProperty() {
        return BillID;
    }

    public void setBillID(String billID) {
        this.BillID.set(billID);
    }

    public String getArea() {
        return Area.get();
    }

    public SimpleStringProperty areaProperty() {
        return Area;
    }

    public void setArea(String area) {
        this.Area.set(area);
    }

    public String getUserID() {
        return UserID.get();
    }

    public SimpleStringProperty userIDProperty() {
        return UserID;
    }

    public void setUserID(String userID) {
        this.UserID.set(userID);
    }
}

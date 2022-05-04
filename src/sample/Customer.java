package sample;


import javafx.beans.property.SimpleStringProperty;

public class Customer {

    private SimpleStringProperty nameOfItems;
    private Integer quantity;
    private Integer unitPrice;
    private Integer netPrice;

    public Customer(String nameOfItems, Integer quantity, Integer unitPrice, Integer netPrice) {
        this.nameOfItems = new SimpleStringProperty(nameOfItems);
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.netPrice = netPrice;
    }

    public String getNameOfItems() {
        return nameOfItems.get();
    }

    public SimpleStringProperty nameOfItemsProperty() {
        return nameOfItems;
    }

    public void setNameOfItems(String nameOfItems) {
        this.nameOfItems.set(nameOfItems);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Integer netPrice) {
        this.netPrice = netPrice;
    }
}
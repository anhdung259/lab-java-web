/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.dtos;

import java.io.Serializable;

/**
 *
 * @author Haima
 */
public class OrderDto implements Serializable{
    int itemID,foodID,quantity,transactionID;
    String foodName,orderDate,userName;

    public OrderDto(int foodID, int quantity, int transactionID, String foodName, String orderDate, String userName) {
        this.foodID = foodID;
        this.quantity = quantity;
        this.transactionID = transactionID;
        this.foodName = foodName;
        this.orderDate = orderDate;
        this.userName = userName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public OrderDto(int itemID, int foodID, int quantity, int transactionID, String foodName, String orderDate) {
        this.itemID = itemID;
        this.foodID = foodID;
        this.quantity = quantity;
        this.transactionID = transactionID;
        this.foodName = foodName;
        this.orderDate = orderDate;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}

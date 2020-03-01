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
public class FoodDto implements Serializable {

    private String foodName, image, description,dateCreate, status;
    private float price;
    private int quantity,categoryID,foodID;

    public FoodDto(String foodName, String image, String description, String dateCreate, String status, float price, int quantity, int categoryID, int foodID) {
        this.foodName = foodName;
        this.image = image;
        this.description = description;
        this.dateCreate = dateCreate;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.foodID = foodID;
    }

    public FoodDto(String foodName, String image, String description, String dateCreate, String status, float price, int quantity, int categoryID) {
        this.foodName = foodName;
        this.image = image;
        this.description = description;
        this.dateCreate = dateCreate;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
    }


    public FoodDto(String foodName, String image, float price, int quantity, int foodID) {
        this.foodName = foodName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.foodID = foodID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

  

    public FoodDto(String foodName, String image, String description, String dateCreate, float price, int quantity, int categoryID) {
        this.foodName = foodName;
        this.image = image;
        this.description = description;
        this.dateCreate = dateCreate;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
    }
   

 

   

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

   

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

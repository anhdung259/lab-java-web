/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.model;

import dung.dtos.FoodDto;
import dung.dtos.OrderDto;
import dung.dtos.TransactionDto;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Haima
 */
public class ShoppingDao implements Serializable {

    Connection conn;
    ResultSet rs;
    PreparedStatement preStm;

    public void closeConnection() throws Exception {
        if (conn != null) {
            conn.close();
        } else if (rs != null) {
            rs.close();
        } else if (preStm != null) {
            preStm.close();
        }
    }

    public boolean BuyCart(TransactionDto dto) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Insert into TransactionShop(Username,AmmountOfMoney,Payment,TransactionDate) values (?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setFloat(2, dto.getAmountOfMoney());
            preStm.setString(3, "cash payment upon delivery");
            preStm.setString(4, dto.getTransactionDate());
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public int checkQuantity(int foodID) throws Exception {
        int quantityCheck = 0;
        try {
            conn = DBConnection.getConnection();
            String sql = "Select Quantity from Food where FoodID=?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, foodID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                quantityCheck = rs.getInt("Quantity");
            }

        } finally {
            closeConnection();
        }
        return quantityCheck;
    }

    public List<TransactionDto> loadTrans() throws Exception {
        List<TransactionDto> list = null;
        int transID;
        String username, transactionDate;
        float amountOfMoney;
        try {
            conn = DBConnection.getConnection();
            String sql = "Select TransactionID,Username,TransactionDate,AmmountOfMoney from TransactionShop";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                transactionDate = rs.getString("TransactionDate");
                amountOfMoney = rs.getFloat("AmmountofMoney");
                transID = rs.getInt("TransactionID");
                list.add(new TransactionDto(transID, username, sql, transactionDate, amountOfMoney));
            }

        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean AddtoOrder(OrderDto dto) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Insert into OrderShop(FoodID,FoodName,Quantity,Username,TransactionID,OrderDate) values (?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getFoodID());
            preStm.setString(2, dto.getFoodName());
            preStm.setInt(3, dto.getQuantity());
            preStm.setString(4, dto.getUserName());
            preStm.setInt(5, dto.getTransactionID());
            preStm.setString(6, dto.getOrderDate());
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public List<OrderDto> loadHistory(String Username) throws Exception {
        List<OrderDto> list = null;
        int itemID, foodID, quantity, transactionID;
        String foodName, orderDate;
        try {
            conn = DBConnection.getConnection();
            String sql = "Select ItemID,FoodID,FoodName,Quantity,TransactionID,OrderDate from OrderShop where Username=? ORDER BY OrderDate DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, Username);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
              itemID = rs.getInt("ItemID");
              foodID=rs.getInt("FoodID");
              foodName=rs.getString("FoodName");
              quantity=rs.getInt("Quantity");
              transactionID=rs.getInt("TransactionID");
              orderDate=rs.getString("OrderDate");
              list.add(new OrderDto(itemID, foodID, quantity, transactionID, foodName, orderDate));
            }

        } finally {
            closeConnection();
        }
        return list;
    }
  public List<OrderDto> SearchHistorybyName(String foodname) throws Exception {
        List<OrderDto> list = null;
        int itemID, foodID, quantity, transactionID;
        String foodName, orderDate;
        try {
            conn = DBConnection.getConnection();
            String sql = "Select ItemID,FoodID,FoodName,Quantity,TransactionID,OrderDate from OrderShop where Foodname like ? ORDER BY OrderDate DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1,"%"+ foodname+"%");
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
              itemID = rs.getInt("ItemID");
              foodID=rs.getInt("FoodID");
              foodName=rs.getString("FoodName");
              quantity=rs.getInt("Quantity");
              transactionID=rs.getInt("TransactionID");
              orderDate=rs.getString("OrderDate");
              list.add(new OrderDto(itemID, foodID, quantity, transactionID, foodName, orderDate));
            }

        } finally {
            closeConnection();
        }
        return list;
    }
   public List<OrderDto> SearchHistorybyDate(String foodname,String txtDate) throws Exception {
        List<OrderDto> list = null;
        int itemID, foodID, quantity, transactionID;
        String foodName, orderDate;
        try {
            conn = DBConnection.getConnection();
            String sql = "Select ItemID,FoodID,FoodName,Quantity,TransactionID,OrderDate from OrderShop where Foodname like ? and "
                    + "CONVERT(DATETIME, FLOOR(CONVERT(FLOAT, OrderDate)))=? ORDER BY OrderDate DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1,"%"+ foodname+"%");
            preStm.setString(2, txtDate);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
              itemID = rs.getInt("ItemID");
              foodID=rs.getInt("FoodID");
              foodName=rs.getString("FoodName");
              quantity=rs.getInt("Quantity");
              transactionID=rs.getInt("TransactionID");
              orderDate=rs.getString("OrderDate");
              list.add(new OrderDto(itemID, foodID, quantity, transactionID, foodName, orderDate));
            }

        } finally {
            closeConnection();
        }
        return list;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.model;

import dung.dtos.FoodDto;
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
public class FoodDao implements Serializable {

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

    public List<FoodDto> loadFood(int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where Status= 'Active' and Quantity>0"
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, start);
            preStm.setInt(2, noRecord);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<FoodDto> loadFoodAdmin(int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, start);
            preStm.setInt(2, noRecord);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int countFoodAdmin() throws Exception {

        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count' from Food";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public boolean createFood(FoodDto dto) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Insert into Food(FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status) values(?,?,?,?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getFoodName());
            preStm.setNString(2, dto.getImage());
            preStm.setNString(3, dto.getDescription());
            preStm.setInt(4, dto.getCategoryID());
            preStm.setFloat(5, dto.getPrice());
            preStm.setInt(6, dto.getQuantity());
            preStm.setString(7, dto.getDateCreate());
            preStm.setString(8, "Active");
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public int countFoodActive() throws Exception {

        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count' from Food where Status= 'Active'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public List<FoodDto> SearchFood(String foodname, float priceF, float priceT, int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where Status= 'Active' and Quantity>0 and FoodName like ? and (Price>=? and Price<=?)"
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + foodname + "%");
            preStm.setFloat(2, priceF);
            preStm.setFloat(3, priceT);
            preStm.setInt(4, start);
            preStm.setInt(5, noRecord);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int countSearch(String keySearch, float priceF, float pricrT) throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count'"
                    + "from Food where Status= 'Active' and Quantity>0 and FoodName like ? and (Price>=? and Price<=?)";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + keySearch + "%");
            preStm.setFloat(2, priceF);
            preStm.setFloat(3, pricrT);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public List<FoodDto> SearchNormal(String foodname, int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where Status= 'Active' and Quantity>0 and FoodName like ? "
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + foodname + "%");
            preStm.setInt(2, start);
            preStm.setInt(3, noRecord);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int countSearchNormal(String keySearch) throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count'"
                    + "from Food where Status= 'Active' and Quantity>0 and FoodName like ? ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + keySearch + "%");
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public List<FoodDto> SearchFoodMaxOption(String foodname, float priceF, float priceT, int CateID, int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where Status= 'Active' and Quantity>0 and FoodName like ? and (Price>=? and Price<=?) and CategoryID=? "
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + foodname + "%");
            preStm.setFloat(2, priceF);
            preStm.setFloat(3, priceT);
            preStm.setInt(4, CateID);
            preStm.setInt(5, start);
            preStm.setInt(6, noRecord);

            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int countSearchMaxOption(String keySearch, float priceF, float priceT, int CateID) throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count'"
                    + "from Food where Status= 'Active' and Quantity>0 and FoodName like ? and (Price>=? and Price<=?) and CategoryID=? ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + keySearch + "%");
            preStm.setFloat(2, priceF);
            preStm.setFloat(3, priceT);
            preStm.setInt(4, CateID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public List<FoodDto> SearchFoodbyCate(String foodname, int cateID, int start, int noRecord) throws Exception {
        List<FoodDto> list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where Status= 'Active' and Quantity>0 and FoodName like ? and CategoryID=? "
                    + "ORDER BY DateCreate DESC offset ? rows fetch next ? rows only ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + foodname + "%");
            preStm.setInt(2, cateID);
            preStm.setInt(3, start);
            preStm.setInt(4, noRecord);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list.add(new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int countSearchCate(String keySearch, int CateID) throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(FoodID) as 'Count'"
                    + "from Food where Status= 'Active' and Quantity>0 and FoodName like ? and CategoryID=? ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, "%" + keySearch + "%");
            preStm.setInt(2, CateID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                count = rs.getInt("Count");
            }
        } finally {
            closeConnection();
        }
        return count;
    }

    public boolean UpdateFood(String id, FoodDto dto) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Update Food set FoodName=?,Image=?,Description=?,CategoryID=?,Price=?,Quantity=?,DateCreate=?,Status=?  where FoodID=?";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getFoodName());
            preStm.setNString(2, dto.getImage());
            preStm.setNString(3, dto.getDescription());
            preStm.setInt(4, dto.getCategoryID());
            preStm.setFloat(5, dto.getPrice());
            preStm.setInt(6, dto.getQuantity());
            preStm.setString(7, dto.getDateCreate());
            preStm.setString(8, dto.getStatus());
            preStm.setString(9, id);

            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean DeleteFood(String id, String dateDelete) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Update Food set Status='Inactive',DateCreate=? where FoodID=?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dateDelete);
            preStm.setString(2, id);
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean UpdateQuantity(int id, int updateQuantity) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Update Food set Quantity=? where FoodID=?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            preStm.setInt(2, updateQuantity);
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public FoodDto loadDetail(String id) throws Exception {
        FoodDto list = null;
        String foodName, image, description, dataCreate, status;
        int categoryID, quantity, foodID;
        float price;
        try {
            String sql = "Select FoodID,FoodName,Image,Description,CategoryID,Price,Quantity,DateCreate,Status from Food "
                    + " where FoodID=?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                foodName = rs.getString("FoodName");
                image = rs.getString("Image");
                description = rs.getString("Description");
                categoryID = rs.getInt("CategoryID");
                dataCreate = rs.getString("DateCreate");
                status = rs.getString("Status");
                quantity = rs.getInt("Quantity");
                price = rs.getFloat("Price");
                foodID = rs.getInt("FoodID");
                list = new FoodDto(foodName, image, description, dataCreate, status, price, quantity, categoryID, foodID);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}

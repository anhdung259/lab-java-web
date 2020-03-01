/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.model;

import dung.dtos.CategoryDto;
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
public class CategoryDao implements Serializable {

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

    public List<CategoryDto> loadCategory() throws Exception {
        List<CategoryDto> list = null;
        int categoryID;
        String categoryName;
        try {
            String sql = "Select CategoryID,CategoryName from Category ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                categoryID = rs.getInt("CategoryID");
                categoryName = rs.getString("CategoryName");
                list.add(new CategoryDto(categoryID, categoryName));
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public int findCateID(String categoryName) throws Exception {
        int categoryID = 0;
        try {
            String sql = "Select CategoryID from Category where CategoryName=? ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, categoryName);
            rs = preStm.executeQuery();
            if (rs.next()) {
                categoryID = rs.getInt("CategoryID");
            }
        } finally {
            closeConnection();
        }
        return categoryID;
    }

    public String findCateName(int categoryID) throws Exception {
        String cateName = null;
        try {
            String sql = "Select CategoryName from Category where CategoryID=? ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, categoryID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                cateName = rs.getString("CategoryName");
            }
        } finally {
            closeConnection();
        }
        return cateName;
    }

    public boolean InsertCategory(String categoryName) throws Exception {
        try {
            String sql = "Insert into Category(CategoryName) values(?) ";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, categoryName);
            if (preStm.executeUpdate() > 0) {
                return true;
            }
        } finally {
            closeConnection();
        }
        return false;
    }
}

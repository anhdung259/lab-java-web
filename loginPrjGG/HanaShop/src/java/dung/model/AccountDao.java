/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Haima
 */
public class AccountDao implements Serializable {

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

    public String Login(String username, String password) throws Exception {
        String role = "failed";
        try {
            conn = DBConnection.getConnection();
            String sql = "Select Role from Account where Username= ? and Password= ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean DeleteUser(String username) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Delete from Account where Email=? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

    public String LoadName(String email) throws Exception {
        String name = "failed";
        try {

            conn = DBConnection.getConnection();
            String sql = "Select Fullname from Account where Username= ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, email);
            rs = preStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("Fullname");
            }
        } finally {
            closeConnection();
        }
        return name;
    }

    public boolean insertAccount(String username, String password, String fullname) throws Exception {
        try {
            conn = DBConnection.getConnection();
            String sql = "Insert into Account(Username,Password,Fullname,Role) values (?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            preStm.setString(3, fullname);
            preStm.setString(4, "user");
            if (preStm.executeUpdate() > 0) {
                return true;
            }

        } finally {
            closeConnection();
        }
        return false;
    }

}

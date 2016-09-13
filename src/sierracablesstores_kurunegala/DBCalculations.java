/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sierracablesstores_kurunegala;

/**
 *
 * @author Dulaj Ayeshan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBCalculations {
    
    String url = "jdbc:mysql://localhost:3306/kurunegala_stores";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;

    ResultSet rs = null;
    
    
    boolean addItem(Item em) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO item VALUES(?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
    
            pst.setInt(1, em.getItemId());
            pst.setString(2, em.getName());
            pst.setString(3, em.getType());
            pst.setString(4, em.getColor());
            pst.setInt(5, em.getLength());
            pst.setString(6, em.getDate());
          
            pst.executeUpdate();

            return true;
            
            } catch (Exception e) {
            System.out.println("exception " + e);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (Exception m) {

            }
        }
        }
    
    
    ArrayList<Item> getItem() {
        try {

            ArrayList<Item> list = new ArrayList<Item>();

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT* from item";
            pst = (PreparedStatement) con.prepareStatement(query);

            rs = pst.executeQuery();

            while (rs.next()) {
                Item s = new Item();
                s.setItemId(rs.getInt(1));
                s.setName(rs.getString(2));
              
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            System.out.println("exception " + e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (Exception m) {

            }

        }
    }

    
    
}

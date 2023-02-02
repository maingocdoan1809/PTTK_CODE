/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Location;
import huce.Model.Spot;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAI NGOC DOAN
 */
public class SpotDAO implements DataAccess<Spot> {
    
    @Override
    public Spot get(String id) {
        Connection database = Database.getConnection();
        int max = 0;
        int real = 0;
        try {
            var stm = database.createStatement();
            var result = stm.executeQuery("Select `soluongthucte`, `soluongtoida` from `vitri` where `mavitri` = '%s'".formatted(id));
            result.next();
            max = result.getInt("soluongtoida");            
            real = result.getInt("soluongthucte");
            
            return new Spot(id, max, real);
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<Spot> getAllInLocation(String locationId) {
        Connection database = Database.getConnection();
        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select * from `vitri` where `maphankhu` = '%s'".
                            formatted(locationId));
            ArrayList<Spot> spots = new ArrayList<>();
            while (result.next()) {
                spots.add(new Spot(
                        result.getString("mavitri"),
                        result.getInt("soluongtoida"),
                        result.getInt("soluongthucte")));
            }
            return spots;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public void updateQuantity(Spot spot, int extraNum) {
        updateQuantity(spot.getId(), extraNum);
    }
    public void updateQuantity(String spotId, int extraNum) {
        Connection connection = Database.getConnection();
        try {
            var stm = connection.createStatement();
            stm.execute( "update `vitri` set `soluongthucte` = `soluongthucte` + " 
                    + extraNum + " where `mavitri` = %s".formatted(spotId) );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public HashMap<String, Spot> getAll() {
//        
//        try {
//            Connection c = Database.getConnection();
//            
//            var stm = c.createStatement();
//            var result = stm.executeQuery("""
//                                          Select * from 
//                                          """);
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        return null;
//        
//    }
    
}

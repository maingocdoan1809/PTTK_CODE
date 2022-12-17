/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Location;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAI NGOC DOAN
 */
public class LocationDAO implements DataAccess<Location> {

    @Override
    public Location get(String id) {
        Connection database = Database.getConnection();
        String name = null;

        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select `tenphankhu` from `phankhu` where `maphankhu` = '%s'".formatted(id)
            );

            if (result.next()) {
                name = result.getString("tenphankhu");
                return new Location(id, name);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<String, Location> getAll() {
        
        Connection database = Database.getConnection();

        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select `maphankhu` from `phankhu`"
            );
            SpotDAO spDao = new SpotDAO();
            HashMap<String, Location> locations = new HashMap<>();
            while(result.next()) {
                String locationID = result.getString("maphankhu");
                Location location = get(locationID);
                location.setSpots( spDao.getAllInLocation(locationID) );
                locations.put(locationID, location);
            }
            return locations;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

}

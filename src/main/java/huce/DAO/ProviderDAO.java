/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Provider;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAI NGOC DOAN
 */
public class ProviderDAO implements DataAccess<Provider>{

    @Override
    public Provider get(String id) {
        Connection database = Database.getConnection();
        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select * from `nhacungcap` where `mancc` = '%s'".formatted(id));
            if (result.next()) {
                return new Provider(
                     result.getString("MaNCC"),
                     result.getString("TenNCC"),
                     result.getString("Diachi"),
                     result.getString("Sodienthoai")
                );
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HashMap<String, Provider> getAll() {
                Connection database = Database.getConnection();
        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select `mancc` from `nhacungcap`");
            HashMap<String, Provider> providers = new HashMap<>();
            while(result.next()) {
                String idp = result.getString("mancc");
                providers.put(idp, get(idp));
            }
            return providers;
        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

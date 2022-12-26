/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Store;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author MAI NGOC DOAN
 */
public class StoreDAO implements DataAccess<Store> {

    @Override
    public Store get(String id) {
        Connection database = Database.getConnection();
        try {
            var stm = database.createStatement();
            var result = stm.executeQuery("Select * from `CuaHang` `id`= '%s'".formatted(id));
            result.next();
            return new Store(id,
                    result.getString("tench"),
                    result.getString("diachi"),
                    result.getString("sodienthoai"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HashMap<String, Store> getAll() {
        
        Connection database = Database.getConnection();
        try {
            HashMap<String, Store> stores = new HashMap<>();
            var stm = database.createStatement();
            var result = stm.executeQuery("Select * from `CuaHang`");
            while (result.next()) {
                String id = result.getString("MaCH");
                stores.put(id, new Store(id,
                        result.getString("tench"),
                        result.getString("diachi"),
                        result.getString("sodienthoai")));
            }
            return stores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

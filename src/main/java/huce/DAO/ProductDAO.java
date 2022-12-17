/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Location;
import huce.Model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAI NGOC DOAN
 */
public class ProductDAO implements DataAccess<Product> {

    @Override
    public Product get(String id) {
        Product p = null;

        Connection database = Database.getConnection();

        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select * from `sanpham` where `masp` = '%s'".formatted(id)
            );

            if (result.next()) {
                p = new Product(
                        id,
                        result.getString("TenSp"),
                        result.getString("Donvi")
                );
                p.setManufacturer(
                        result.getString("Xuatxu"),
                        result.getString("Nhasx")
                );
                p.setDate(
                        result.getString("NSX"),
                        result.getString("HSD")
                );
                p.setPrice(
                        result.getFloat("Gianhap"),
                        result.getFloat("Giaban")
                );
                SpotDAO spotDAO = new SpotDAO();
                p.setSpot(spotDAO.get( result.getString("mavitri") ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    @Override
    public boolean insert(Product data) {
        
        return true;
    }

    @Override
    public boolean update(String id, Product newData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HashMap<String, Product> getAll() {

        Connection database = Database.getConnection();

        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select `maSp` from `sanpham`"
            );
            HashMap<String, Product> products = new HashMap<>();
            while(result.next()) {
                String pId = result.getString("maSp");
                products.put( pId , get(pId));
            }
            return products;

        } catch (SQLException ex) {
            Logger.getLogger(LocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}

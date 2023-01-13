/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
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
    synchronized public Product get(String id) {
        return getBy("MaSp", id);
    }
    
    @Override
    synchronized public HashMap<String, Product> getAll() {
        return getAllBy(null,null);
    }
    synchronized private HashMap<String, Product> getAllBy(String columnName, String value) {
                Connection database = Database.getConnection();

        try {
            String query = "Select `maSp` from `sanpham`";
            if ( columnName != null && value != null ) {
                query += " where `%s` = '%s' ".formatted(columnName, value);
            }
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    query
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
    synchronized private Product getBy(String columnName, String value) {
        Product p = null;

        Connection database = Database.getConnection();

        try {
            var stm = database.createStatement();
            var result = stm.executeQuery(
                    "Select * from `sanpham` where `%s` = '%s'".formatted(columnName, value)
            );

            if (result.next()) {
                p = new Product(
                        result.getString("MaSP"),
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
    synchronized public Product getByName(String name) {
        return getBy("TenSp", name);
    }
    synchronized public void importProduct(Product product, int num) {
         Connection connection = Database.getConnection();
        try {
            var stm = connection.createStatement();
            stm.execute(" Update `vitri` set `soluongthucte` = `soluongthucte` + %d where  `mavitri` = '%s' ".formatted(num, product.getSpot().getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    synchronized public void exportProduct(Product product, int num) {
        importProduct(product, -num);
    }
    synchronized public void importProduct(String id, int num) {
        Connection connection = Database.getConnection();
        try {
            var stm = connection.createStatement();
            Product p = get(id);
            String spot = p.getSpot().getId();
            stm.execute(" Update `vitri` set `soluongthucte` = `soluongthucte` + %d where  `mavitri` = '%s' ".formatted(num, spot));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    synchronized public void exportProduct(String id, int num) {
        importProduct(id, -num);
    }
}

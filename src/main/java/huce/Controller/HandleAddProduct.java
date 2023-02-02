/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import huce.Model.Product;

/**
 *
 * @author A
 */
public class HandleAddProduct {
    
    public boolean add(Product product) {
        if ( product == null ) {
            return false;
        }
        ProductDAO fDAO = new ProductDAO();
        fDAO.insert(product);
        return true;
    }
}

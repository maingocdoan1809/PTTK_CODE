/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import huce.Model.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadAllProducts {
    public void loadTo(JTable table, Product ...productsArr) {
        var tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        ProductDAO pdao = new ProductDAO();
        Collection<Product> products = null;
        if ( productsArr.length ==0 ) {
            products = pdao.getAll().values();
        } else {
            products = new ArrayList<>();
            Collections.addAll(products, productsArr);
        }
        for ( var product : products ) {
            tableModel.addRow(product.toStringArr(stt));
            stt++;
        }
    }
}

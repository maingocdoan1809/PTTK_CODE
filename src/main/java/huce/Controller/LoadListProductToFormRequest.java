/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import huce.Model.Form;
import huce.Model.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormRequest implements LoadListProductToForm {

    @Override
    public void loadTo(Form form, JTable toTable, Product ...productsArr) {
        // id always null
        ProductDAO productDAO = new ProductDAO();
        Collection<Product> products = null;
        if ( productsArr.length ==0 ) {
            products = productDAO.getAll().values();
        } else {
            products = new ArrayList<>();
            Collections.addAll(products, productsArr);
        }
        var tableModel = (DefaultTableModel) toTable.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        for ( var product : products ) {
            tableModel.addRow(new String[] {
                stt + "",
                product.getId(),
                product.getName(),
                product.getSpot().getRealQuantity() + "",
                product.getUnit(),
            });
            stt ++;
        }
        
    }

}

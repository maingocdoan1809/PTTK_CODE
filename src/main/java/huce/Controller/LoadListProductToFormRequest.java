/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormRequest implements LoadListProductToForm {

    @Override
    public void loadTo(String id, JTable toTable) {
        // id always null
        ProductDAO productDAO = new ProductDAO();
        var products = productDAO.getAll();
        var tableModel = (DefaultTableModel) toTable.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        for ( var product : products.values() ) {
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadAllProducts {
    public void loadTo(JTable table) {
        var tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        ProductDAO pdao = new ProductDAO();
        var products = pdao.getAll();
        for ( var product : products.values() ) {
            tableModel.addRow(product.toStringArr(stt));
            stt++;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAI NGOC DOAN
 */
public class HandleSearchingForm implements HandleSearching {

    @Override
    public void search(JTable table, String whatToSearch) {
        // id always null
        ProductDAO pdao = new ProductDAO();
        var tableModel = (DefaultTableModel) table.getModel();
        try {
            // search by ID:
            var productByID = pdao.get(whatToSearch);
            // search by Name:
            var productByName = pdao.getByName(whatToSearch);
            if (productByID == null && productByName == null) {
                throw new Exception("Không tìm thấy kết quả");
            }
            tableModel.setRowCount(0);
            if (productByID != null) {
                new LoadListProductToFormRequest().loadTo(null, table, productByID);
            }
            if (productByName != null) {
                new LoadListProductToFormRequest().loadTo(null, table, productByName);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void clear(JTable table) {
        new LoadListProductToFormRequest().loadTo(null, table);
    }

}

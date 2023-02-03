/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import huce.Model.Product;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HandleSearchingProducts implements HandleSearching{

    @Override
    public void search( JTable table, String whatToSearch) {
        ProductDAO pdao = new ProductDAO();
        var tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            // search by ID:
            var productByID = pdao.get(whatToSearch);
            // search by Name:
            var productByName = pdao.getAllByName(whatToSearch);
            if ( productByID == null && productByName.isEmpty()) {
                throw new Exception("Không tìm thấy kết quả");
            }
            
            if ( productByID != null ) {
                new LoadAllProducts().loadTo(table, productByID);
            }
            if ( productByName != null ) {
                Product[] products = new Product[productByName.size()];
                productByName.toArray(products);
                new LoadAllProducts().loadTo(table,products );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void clear(JTable table) {
        new LoadAllProducts().loadTo(table);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.ProductDAO;
import huce.View.ExpiredProducts;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HandelExpiredProduct {

    public void handel() {

        ExpiredProducts exp = new ExpiredProducts();
        getDataToTable(exp.getTableModel());
        exp.addDeleteBtnListener((e) -> {
            // your code here
            int option = JOptionPane.showConfirmDialog(null, "Xóa hàng ra khỏi kho?");
            if (option == JOptionPane.YES_OPTION) {
                ProductDAO pdao = new ProductDAO();
                for (int i = 0; i < exp.getTableModel().getRowCount(); i++) {
                    pdao.delete((String) exp.getTableModel().getValueAt(i, 1));
                }
            }

            exp.getTableModel().setRowCount(0);
        });

        exp.setVisible(true);

    }

    private void getDataToTable(DefaultTableModel table) {
        ProductDAO pdao = new ProductDAO();
        int stt = 1;
        var products = pdao.getExpiredProduct();
        for (var product : products) {
            table.addRow(new Object[]{
                stt++ + "",
                product.getId(),
                product.getName(),
                product.getSpot().getId(),
                product.getrMgf(),
                product.getExp(),
                product.getSpot().getRealQuantity()
            });

        }

    }
}

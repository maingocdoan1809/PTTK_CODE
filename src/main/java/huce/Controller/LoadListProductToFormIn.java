/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestInDAO;
import huce.Model.Product;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormIn implements LoadListProductToForm {

   
    @Override
    public void loadTo(String id, JTable toTable, Product ...products) {
        var tableModel = (DefaultTableModel) toTable.getModel();
        tableModel.setRowCount(0);
        FormRequestInDAO dAO = new FormRequestInDAO();
        var remainProducts = dAO.getRemainProduct(id);
        int stt = 1;
        for ( String idP : remainProducts.keySet() ) {
            var infor = remainProducts.get(idP);
            tableModel.addRow(new String[]{
                stt + "", idP, infor.get("tensp"), infor.get("soluongtheoyeucau"), "conlai" ,infor.get("donvi")
            });
            stt++;
        }
        
    }

}

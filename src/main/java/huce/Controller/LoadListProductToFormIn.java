/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.Form;
import huce.Model.Product;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormIn implements LoadListProductToForm {

   
    @Override
    public void loadTo(Form formIn, JTable toTable, Product ...products) {
        var tableModel = (DefaultTableModel) toTable.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        for ( var idP : formIn.getProductIds() ) {
            tableModel.addRow(idP.toArray());
            stt++;
        }
        
    }


}

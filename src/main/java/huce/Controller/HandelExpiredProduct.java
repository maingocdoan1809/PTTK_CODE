/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.View.ExpiredProducts;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HandelExpiredProduct {
    public void handel() {
        
        ExpiredProducts exp = new ExpiredProducts();
        getDataToTable(exp.getTableModel());
        exp.addDeleteBtnListener( (e) -> {
            // your code here
            System.out.println("Delete");
            
            exp.getTableModel().setRowCount(0);
        } );
        
        exp.setVisible(true);
        
    }
    private void getDataToTable(DefaultTableModel table) {
        
        System.out.println("get data");
        
    }
} 

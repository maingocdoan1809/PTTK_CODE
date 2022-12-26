/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import com.github.lgooddatepicker.ysandbox.TestStart;
import huce.DAO.AccountDAO;
import huce.DAO.FormRequestInDAO;
import huce.Model.Database;
import huce.Model.Product;
import huce.View.FormRequestIn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
                stt + "", idP, infor.get("tensp"), infor.get("soluongtheoyeucau"), infor.get("donvi")
            });
            stt++;
        }
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import com.github.lgooddatepicker.ysandbox.TestStart;
import huce.DAO.AccountDAO;
import huce.Model.Database;
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
    public void loadTo(String id, JTable toTable) {
        System.out.println(id);
    }

}

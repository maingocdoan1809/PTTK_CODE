/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 * @see #ListRequestsInPanel
 */
public class LoadListRequestIn implements LoadListRequest{

    @Override
    public void loadTo(JTable table) {
        System.out.println("Load to RequestIn table");
    }

}

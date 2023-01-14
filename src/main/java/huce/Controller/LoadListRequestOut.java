/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestDAO;
import huce.DAO.StoreDAO;
import huce.Model.FormRequest;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListRequestOut implements LoadListRequest{

    @Override
    public void loadTo(JTable table) {
        FormRequestDAO dAO = new FormRequestDAO();
        var allForms = dAO.getAll();
        var tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        for ( var form : allForms.values() ) {
            var formRequest = (FormRequest) form;
            StoreDAO storeDAO = new StoreDAO();
            var store = storeDAO.get(formRequest.getCreateStore());
            tableModel.addRow( new String[]{
                stt + "",
                formRequest.getId(),
                store.getId(),
                store.getName(),
                store.getAddress(),
                formRequest.getState()
            } );
            stt++;
        }
    }
    
}

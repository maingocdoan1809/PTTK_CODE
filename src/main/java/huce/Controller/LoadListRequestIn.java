/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestInDAO;
import huce.DAO.ProviderDAO;
import huce.Model.FormRequest;
import huce.Model.FormRequestIn;
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
        FormRequestInDAO dAO = new FormRequestInDAO();
        var allForms = dAO.getAll();
        var tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        int stt = 1;
        ProviderDAO pdao = new ProviderDAO();
        for ( var form : allForms.values() ) {
            var formRequest = (FormRequestIn) form;
            tableModel.addRow( new String[]{
                stt + "",
                formRequest.getId(),
                formRequest.getProvider(),
                pdao.get(formRequest.getProvider()).getName(),
                formRequest.getCreateDate(),
                formRequest.getState()
            } );
            stt++;
        }
        
    }

}

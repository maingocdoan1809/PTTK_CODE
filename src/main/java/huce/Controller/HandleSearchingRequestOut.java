/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestDAO;
import huce.DAO.ProviderDAO;
import huce.DAO.StoreDAO;
import huce.Model.FormRequest;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HandleSearchingRequestOut implements HandleSearching {

    @Override
    public void search(JTable table, String whatToSearch) {
        try {
            FormRequestDAO pInDAO = new FormRequestDAO();
            if (whatToSearch.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập id của phiếu!");
                return;
            }
            var formRequest = (FormRequest) pInDAO.get(whatToSearch);

            if (formRequest != null) {
                var tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);
                int stt = 1;
                ProviderDAO pdao = new ProviderDAO();
                StoreDAO storeDAO = new StoreDAO();
                var store = storeDAO.get(formRequest.getCreateStore());
                tableModel.addRow(new String[]{
                    stt + "",
                    formRequest.getId(),
                    store.getId(),
                    store.getName(),
                    store.getAddress(),
                    formRequest.getState()
                });
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu có id: " + whatToSearch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear(JTable table) {
        try {
            new LoadListRequestOut().loadTo(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

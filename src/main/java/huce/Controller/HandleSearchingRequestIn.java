/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestInDAO;
import huce.DAO.ProviderDAO;
import huce.Model.FormRequestIn;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HandleSearchingRequestIn implements HandleSearching {

    @Override
    public void search(JTable table, String whatToSearch) {
        try {
            FormRequestInDAO pInDAO = new FormRequestInDAO();
            if (whatToSearch.equals("")) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập id của phiếu!");
                return;
            }
            var request = (FormRequestIn) pInDAO.get(whatToSearch);

            if (request != null) {
                var tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);
                int stt = 1;
                ProviderDAO pdao = new ProviderDAO();
                tableModel.addRow(new String[]{
                    stt + "",
                    request.getId(),
                    request.getProvider(),
                    pdao.get(request.getProvider()).getName(),
                    request.getCreateDate(),
                    request.getState()
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
            new LoadListRequestIn().loadTo(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

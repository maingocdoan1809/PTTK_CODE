/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormOut;
import huce.Controller.LoadListProductToFormOut;
import huce.Model.ApplyPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormOut extends Form implements Subject{

    private JTextField jTextStore;
    private JTextField jTextStoreID;

    public FormOut(JPanel gobackPanel, String id) {
        this.setTitle("Phiếu xuất hàng");
        jTextStoreID = this.addJTextField(jPanelTop, "Mã cửa hàng", 5);
        jTextStore = this.addJTextField(jPanelTop, "Địa chỉ nhận hàng", 15);
        jTextStore.setEnabled(false);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Theo yêu cầu", "Thực xuất", "Đơn vị ", "Đơn giá"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });

        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setListProductTable(new SimpleListProductsTable(this, new String[]{
            "STT", "ID", "Tên sản phẩm", "Số lượng yêu cầu còn lại", "Đơn vị"
        }));
        this.jTableContainer.setViewportView(tableDetail);
        new LoadListProductToFormOut().loadTo(id, jListProductJTable);
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormOut();
            if (handleCreateForm.create()) {
                ApplyPanel.apply(gobackPanel, new ListRequestsPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });

    }

    @Override
    public void update(Observer observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

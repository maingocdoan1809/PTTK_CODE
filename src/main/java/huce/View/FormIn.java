/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormIn;
import huce.Controller.LoadListProductToFormIn;
import huce.Model.ApplyPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormIn extends Form implements Subject{

    private JTextField jTextProvider;
    private JTextField jTextProviderId;

    public FormIn(JPanel gobackPanel, String id) {
        super();
        setTitle("Phiếu nhập hàng");

        jTextProviderId = super.addJTextField(jPanelTop, "Mã bên giao.", 5);
        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);

        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Theo chứng từ", "Thực nhập", "Đơn vị ", "Đơn giá"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });

        this.jLabelRight.setText("Các sản phẩm được yêu cầu");
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormIn();
            if (handleCreateForm.create()) {
                ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this, new String[]{
            "STT", "ID", "Tên sản phẩm", "Số lượng yêu cầu còn lại", "Đơn vị"
        }));
        (new LoadListProductToFormIn()).loadTo(id, jListProductJTable);
    }

    @Override
    public void update(Observer observer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

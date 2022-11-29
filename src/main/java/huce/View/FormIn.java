/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import huce.Model.ApplyPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.sql.Connection;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormIn extends Form {

    private JTextField jTextProvider;
    private JTextField jTextProviderId;
    private JTextField jTextProductLotID;

    public FormIn(JPanel gobackPanel) {
        super();
        setTitle("Phiếu nhập hàng");
        jTextProviderId = super.addJTextField(jPanelTop, "Mã bên giao hàng.", 5);
        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);
        jTextProductLotID = super.addJTextField(jPanelTop, "Mã lô.", 15);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn vị ", "Theo chứng từ", "Thực nhập", "Đơn giá", "Thành tiền"
                }
        ));
        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        super.jTableContainer.setViewportView(tableDetail);
        setListProductTable(new SimpleListProductsTable(this));
        ///
        this.jButtonCreate.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Ok!");
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
    }

}

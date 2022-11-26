/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormOut extends Form {

    private JTable tableDetail;
    private JTextField jTextStore;
    private JTextField jTextStoreID;

    public FormOut() {
        this.setTitle("Phiếu xuất hàng");
        jTextStoreID = this.addJTextField(jPanelTop, "Mã cửa hàng", 5);
        jTextStore = this.addJTextField(jPanelTop, "Địa chỉ nhận hàng", 15);
        jTextStore.setEnabled(false);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Slg yêu cầu", "Slg thực xuất", "Đơn giá", "Thành tiền"
                }
        ) {
           boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        this.jTableContainer.setViewportView(tableDetail);
    }

    @Override
    public void handleEvent(Connection database) {
        this.jButtonCreate.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Ok!");
        });
        this.jButtonDel.addActionListener((e) -> {
            this.resetForm();
            this.jTextStore.setText("");
            this.jTextStoreID.setText("");
        });
        this.jButtonPrint.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Printing...!");
        });
    }
}

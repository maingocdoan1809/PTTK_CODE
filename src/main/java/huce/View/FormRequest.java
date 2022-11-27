/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormRequest extends Form {

    private JTable tableDetail;
    private JTextField jTextStore;
    private JTextField jTextReason;

    public FormRequest() {
        this.setTitle("Phiếu yêu cầu nhập hàng");
        jTextStore = this.addJTextField(this.jPanelTop, "ID Cửa hàng", 5);
        jTextReason = this.addJTextField(jPanelBottom, "Lý do", 20);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Tên sản phẩm", "Mã sản phẩm", "Số lượng" , "Đơn giá", "Thành tiền"
                }
        ) {

        });

        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        super.jTableContainer.setViewportView(tableDetail);
    }

    @Override
    public void handleEvent(Connection database) {
        this.jButtonCreate.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Sent!");
        });
        this.jButtonDel.addActionListener((e) -> {
            this.resetForm();
            this.jTextStore.setText("");
            this.jTextReason.setText("");
        });
        this.jButtonPrint.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Printing...!");
        });
    }
}

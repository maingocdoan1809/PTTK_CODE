/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JLabel type = new JLabel("Xuất Hàng");
        type.setFont(new Font("Segoe UI", Font.PLAIN, 30) {
        });
        type.setForeground(Color.red);
        this.jPanelType.add(type);
        jTextStoreID = this.addJTextField(jPanelTop, "Mã cửa hàng", 5);
        jTextStore = this.addJTextField(jPanelTop, "Địa chỉ nhận hàng", 15);
        jTextStore.setEnabled(false);
        tableDetail = this.createTable(new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Mã lô", "Đơn vị", "Slg tồn", "Slg yêu cầu", "Đơn giá", "Thành tiền", "HSD", "Ngày giao"
            });
        this.jTableContainer.setViewportView(tableDetail);
    }
    
}

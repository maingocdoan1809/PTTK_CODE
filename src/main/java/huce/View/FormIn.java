/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.sql.Connection;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 
 * @author Admin
 */
public class FormIn extends Form {
    private JTextField jTextProvider;
    private JTable tableDetail;
    public FormIn() {
        super();
        setTitle("Phiếu nhập hàng");
        jTextProvider = super.addJTextField(jPanelTop, "Mã bên giao hàng.", 5);

        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);
        
        tableDetail = Form.createTable( new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Mã lô", "Đơn vị ", "Theo chứng từ", "Thực nhập", "Đơn giá", "Thành tiền"
            });
        super.jTableContainer.setViewportView(tableDetail);
    }

    @Override
    public void handleEvent(Connection database) {
       this.jButtonCreate.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Ok!");
        });
        this.jButtonDel.addActionListener((e) -> {
            this.resetForm();
            this.jTextProvider.setText("");
        });
        this.jButtonPrint.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Printing...!");
        });
    }
 

}

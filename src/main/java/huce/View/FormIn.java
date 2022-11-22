/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JLabel type = new JLabel("Nhập hàng");
        type.setFont(new Font("Segoe UI", Font.PLAIN, 30) {
        });
        type.setForeground(Color.red);
        jTextProvider = super.addJTextField(jPanelTop, "Đơn vị giao hàng.", 15);
        tableDetail = this.createTable( new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Mã lô", "Đơn vị ", "Theo chứng từ", "Thực nhập", "Đơn giá", "Thành tiền"
            });
        super.jTableContainer.setViewportView(tableDetail);
        super.jPanelType.add(type);
    }
 

}

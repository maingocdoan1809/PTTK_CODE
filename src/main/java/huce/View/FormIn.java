/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import Controller.LoadListProductToFormIn;
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
public class FormIn extends FormRequestIn {
    public FormIn(JPanel gobackPanel, String id) {
        super(gobackPanel);
        setTitle("Phiếu nhập hàng");
//        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn vị ", "Theo chứng từ", "Thực nhập", "Đơn giá", "Thành tiền"
                }
        ));
        this.jLabelRight.setText("Các sản phẩm được yêu cầu");
        (new LoadListProductToFormIn()).loadTo(id, jListProductJTable);
    }

}

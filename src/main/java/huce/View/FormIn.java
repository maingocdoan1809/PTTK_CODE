/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormIn;
import huce.Controller.HandleCreateFormRequest;
import huce.Controller.HandleCreateFormRequestIn;
import huce.Controller.LoadListProductToFormIn;
import huce.Controller.LoadListProductToFormRequest;
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
public class FormIn extends Form{
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
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Đơn vị ", "Theo chứng từ", "Thực nhập", "Đơn giá", "Thành tiền"
                }
        ));
        
        this.jLabelRight.setText("Các sản phẩm được yêu cầu");
        (new LoadListProductToFormIn()).loadTo(id, jListProductJTable);
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormIn();
            if ( handleCreateForm.create() ) {
                ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this));
        
        
        
        
        
       
        
    }

}

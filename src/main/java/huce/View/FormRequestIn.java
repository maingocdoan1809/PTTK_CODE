/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormRequestIn;
import huce.Controller.LoadListProductToFormRequest;
import huce.Model.ApplyPanel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormRequestIn extends Form{
    private JTextField jTextProvider;
    private JTextField jTextProviderId;
    public FormRequestIn(JPanel gobackPanel) {
        setTitle("Phiếu yêu cầu nhập hàng");
        jTextProviderId = super.addJTextField(jPanelTop, "Mã bên giao.", 5);
        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormRequestIn();
            if ( handleCreateForm.create() ) {
                ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }
            
        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        this.tableDetail = new JTable();
        this.tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT",  "Mã sản phẩm", "Tên sản phẩm","Số lượng" 
                }
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this));
        new LoadListProductToFormRequest().loadTo(null, this.jListProductJTable);
        Form.addUnselectProductEvent(tableDetail, jListProductJTable, 3);   
    }
   
    
}

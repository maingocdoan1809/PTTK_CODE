/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import huce.Model.ApplyPanel;
import java.sql.Connection;
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
            ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        this.tableDetail = new JTable();
        this.tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Tên sản phẩm", "Mã sản phẩm", "Số lượng" , "Đơn giá", "Thành tiền"
                }
        ) {

        });
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this));
    }
   
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import huce.Controller.LoadListProductToFormRequest;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class FormRequest extends Form {

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
                    "STT","Mã sản phẩm", "Tên sản phẩm", "Số lượng"
                }
        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }
            
        });
        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setListProductTable(new SimpleListProductsTable(this));
        super.jTableContainer.setViewportView(tableDetail);
        new LoadListProductToFormRequest().loadTo(null, this.jListProductJTable);
        Form.addUnselectProductEvent(tableDetail, jListProductJTable, 3);
    }

}

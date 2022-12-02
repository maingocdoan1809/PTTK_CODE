/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import Controller.LoadListProductToFormRequest;
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
                    "STT", "Tên sản phẩm", "Mã sản phẩm", "Số lượng"
                }
        ) {

        });
        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setListProductTable(new SimpleListProductsTable(this));
        super.jTableContainer.setViewportView(tableDetail);
        new LoadListProductToFormRequest().loadTo(null, this.jListProductJTable);
    }

}

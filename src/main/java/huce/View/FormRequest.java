/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormRequest;
import huce.Controller.HandleSearchingForm;
import huce.Controller.LoadListProductToFormRequest;
import huce.DAO.StoreDAO;
import huce.Model.ApplyPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormRequest extends Form {

    private JComboBox<String> jTextStore;
    private JTextField jTextReason;

    public FormRequest() {
        this.setTitle("Phiếu yêu cầu nhập hàng");
//        jTextStore = this.addJTextField(this.jPanelTop, "ID Cửa hàng", 5);
        jTextStore = new JComboBox<>();
        jPanelTop.add(new JLabel("Mã cửa hàng"));
        jTextStore.setPreferredSize(new Dimension(80, 25));
        jPanelTop.add(jTextStore);

        StoreDAO storeDAO = new StoreDAO();
        var allStores = storeDAO.getAll();

        this.jTextStore.addActionListener((evt) -> {
            this.jTextWhere.setText(allStores.get((String) this.jTextStore.getSelectedItem()).getName());
        });

        for (var storeID : allStores.keySet()) {
            jTextStore.addItem(storeID);
        }

        jTextReason = this.addJTextField(jPanelBottom, "Lý do", 20);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng yêu cầu"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });
        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setListProductTable(new SimpleListProductsTable(this));
        super.jTableContainer.setViewportView(tableDetail);
        new LoadListProductToFormRequest().loadTo(null, this.jListProductJTable);

        this.jLookUpPanel.add(new LookUpPanel(new HandleSearchingForm(), this.jListProductJTable),
                BorderLayout.SOUTH);

        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormRequest();
            if (handleCreateForm.create(this.createFormModel())) {
                JOptionPane.showMessageDialog(null, "Thành công!");
                ApplyPanel.apply( Main.mainPanel , new FormRequest());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        
        
        
        
    }

    @Override
    public void update(Observer observer) {
        InpProductData inputData = (InpProductData) observer;
        var tableDetailModel = (DefaultTableModel) this.tableDetail.getModel();
        try {
            tableDetailModel.addRow(new String[]{
                (tableDetailModel.getRowCount() + 1) + "",
                inputData.getProductId(),
                inputData.getProductName(),
                inputData.getRequestInput() + ""
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    huce.Model.Form createFormModel() {
        int rowCount = this.getTableDetail().getRowCount();
        if (rowCount == 0 || this.jTextIDForm.getText() == null) {
            return null;
        }

        huce.Model.FormRequest formRequest = new huce.Model.FormRequest();

        formRequest.setId(this.jTextIDForm.getText());
        formRequest.setCreateDate(this.jDateCreated.getDateStringOrEmptyString());
        formRequest.setCreateLocation(this.jTextWhere.getText());
        formRequest.setProductIds(this.getDetailsArray());
        formRequest.setCreateStore((String) this.jTextStore.getSelectedItem());
        formRequest.setCreateStaff(this.jTextAccount.getText());
        formRequest.setReason(this.jTextReason.getText());
        return formRequest;
    }

    @Override
    ArrayList<ArrayList<String>> getDetailsArray() {
        var tableDetailModel = (DefaultTableModel) this.tableDetail.getModel();
        int rowCount = this.getTableDetail().getRowCount();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            ArrayList<String> row = new ArrayList<>();
            row.add((String) tableDetailModel.getValueAt(i, 1));
            row.add((String) tableDetailModel.getValueAt(i, 2));
            row.add((String) tableDetailModel.getValueAt(i, 3));
            data.add(row);
        }
        return data;
    }

}

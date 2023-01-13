/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormRequestIn;
import huce.Controller.HandleSearchingForm;
import huce.Controller.LoadListProductToFormRequest;
import huce.DAO.ProviderDAO;
import huce.Model.ApplyPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormRequestIn extends Form implements Subject {

    private JTextField jTextProvider;
    private JComboBox<String> jTextProviderId;

    public FormRequestIn(JPanel gobackPanel) {
        setTitle("Phiếu yêu cầu nhập hàng");
//        jTextProviderId = super.addJTextField(jPanelTop, "Mã bên giao.", 5);
        // combox:
        jTextProviderId = new JComboBox<>();
        jPanelTop.add(new JLabel("Mã bên giao"));
        jTextProviderId.setPreferredSize(new Dimension(80, 25));
        jPanelTop.add(jTextProviderId);
        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormRequestIn();
            if (handleCreateForm.create(this.createFormModel())) {
                ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });

        // get all provider: 
        ProviderDAO providerDAO = new ProviderDAO();
        var allProviders = providerDAO.getAll();
        this.jTextProviderId.addActionListener((e) -> {

            this.jTextProvider.setText((String) allProviders.get(jTextProviderId.getSelectedItem()).getName());

        });
        for (var provider : allProviders.keySet()) {
            this.jTextProviderId.addItem(provider);
        }

        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        this.tableDetail = new JTable();
        this.tableDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this, new String[]{
             "STT", "ID", "Tên sản phẩm", "Đơn vị", "Số lượng tối đa", "Số lượng tồn trong kho"
        }));
        new LoadListProductToFormRequest().loadTo(null, this.jListProductJTable);
        this.jLookUpPanel.add(new LookUpPanel(new HandleSearchingForm(), this.jListProductJTable),
                BorderLayout.SOUTH);
        this.jTextWhere.setText("Tại kho");

    }

    @Override
    public void update(Observer observer) {
        
        InpProductData inputData = (InpProductData) observer;
        var tableDetailModel = (DefaultTableModel) this.tableDetail.getModel();
        try {
            tableDetailModel.addRow( new String[] {
            (tableDetailModel.getRowCount() + 1) + "",
            inputData.getProductId(),
            inputData.getProductName(),
            inputData.getRequestInput() + ""
        } );
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
        
        huce.Model.FormRequestIn formRequestIn = new huce.Model.FormRequestIn();
        
        formRequestIn.setId(this.jTextIDForm.getText());
        formRequestIn.setCreateDate(this.jDateCreated.getDateStringOrEmptyString());
        formRequestIn.setCreateLocation(this.jTextWhere.getText());
        formRequestIn.setCreateStaff(this.jTextAccount.getText());
        formRequestIn.setProductIds(this.getDetailsArray());
        formRequestIn.setProvider( (String) this.jTextProviderId.getSelectedItem());
        
        return formRequestIn;
        
    }

    @Override
    ArrayList<ArrayList<String>> getDetailsArray() {
        
        var tableDetailModel = (DefaultTableModel) this.tableDetail.getModel();
        int rowCount = this.getTableDetail().getRowCount();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for ( int i = 0; i < rowCount; i++ ) {
            ArrayList<String> row = new ArrayList<>();
            row.add( (String) tableDetailModel.getValueAt(i, 1) );               
            row.add( (String) tableDetailModel.getValueAt(i, 2) );            
            row.add( (String) tableDetailModel.getValueAt(i, 3) );
            data.add(row);
        }
        return data;
    }

}

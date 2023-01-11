/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormIn;
import huce.Controller.LoadListProductToFormIn;
import huce.DAO.ProductDAO;
import huce.DAO.ProviderDAO;
import huce.Model.ApplyPanel;
import huce.Model.FormRequestIn;
import huce.Model.Provider;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FormIn extends Form implements Subject {

    private JTextField jTextProvider;
    private JTextField jTextProviderId;
    private FormRequestIn requestIn;

    public FormIn(JPanel gobackPanel, FormRequestIn requestIn) {
        super();
        setTitle("Phiếu nhập hàng");
        this.requestIn = requestIn;
        jTextProviderId = super.addJTextField(jPanelTop, "Mã bên giao.", 5);

        jTextProvider = super.addJTextField(jPanelTop, "Tên bên giao.", 15);
        jTextProvider.setEnabled(false);

        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Theo chứng từ", "Thực nhập", "Đơn vị ", "Đơn giá"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });

        this.jLabelRight.setText("Các sản phẩm được yêu cầu");
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormIn();
            if (handleCreateForm.create(createFormModel())) {

                ApplyPanel.apply(gobackPanel, new ListRequestsInPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        super.jTableContainer.setViewportView(this.tableDetail);
        setListProductTable(new SimpleListProductsTable(this, new String[]{
            "STT", "ID", "Tên sản phẩm", "Số lượng yêu cầu", "Số lượng yêu cầu còn lại", "Đơn vị"
        }));
        (new LoadListProductToFormIn()).loadTo(requestIn, jListProductJTable);

        ProviderDAO pvDAO = new ProviderDAO();
        Provider provider = pvDAO.get(requestIn.getProvider());
        this.jTextProviderId.setText(provider.getId());
        this.jTextProvider.setText(provider.getName());
        this.jTextWhere.setText("Tai kho");
    }

    public String getIDRequest() {
        return this.requestIn.getId();
    }

    @Override
    public void update(Observer observer) {
        InpProductData inputData = (InpProductData) observer;
        var tableDetailModel = (DefaultTableModel) this.tableDetail.getModel();
        var listProductModel = (DefaultTableModel) this.jListProductJTable.getModel();
        try {
            int remainInput = Integer.parseInt((String) listProductModel.
                    getValueAt(this.jListProductJTable.getSelectedRow(), 4));
            
            int realInput = inputData.getRealInput();
            if (realInput > remainInput || remainInput == 0) {
                throw new Exception();
            }
            var productTableModel = this.jListProductJTable.getModel();
            int currRowCount = tableDetailModel.getRowCount() + 1;
            ProductDAO pdao = new ProductDAO();
            tableDetailModel.addRow(new String[]{
                currRowCount + "", inputData.jTextID.getText(), inputData.jTextName.getText(),
                inputData.jTextRequestNum.getText(),
                inputData.jTextRealInput.getText(), pdao.get(inputData.jTextID.getText()).getUnit() ,inputData.jTextLotNumber.getText()
            });

            listProductModel.setValueAt((remainInput - realInput) + "", this.jListProductJTable.getSelectedRow(), 4);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input không hợp lệ, yêu cầu nhập lại.");
        }

    }

    @Override
    huce.Model.Form createFormModel() {

        int rowCount = this.getTableDetail().getRowCount();
        if (rowCount == 0 || this.jTextIDForm.getText().equals("")) {
            return null;
        }
        huce.Model.FormIn formIn = new huce.Model.FormIn();

        formIn.setId(this.jTextIDForm.getText());
        formIn.setIdFormRequestIn(this.requestIn.getId());
        formIn.setCreateDate(this.jDateCreated.getDateStringOrEmptyString());
        formIn.setCreateLocation(this.jTextWhere.getText());
        formIn.setCreateStaff(this.jTextAccount.getText());
        formIn.setValue(0);
        formIn.setProductIds(this.getDetailsArray());
        
        return formIn;
    }

    @Override
    ArrayList<ArrayList<String>> getDetailsArray() {

        var tableDetailModel = this.tableDetail.getModel();
        int row = tableDetailModel.getRowCount();
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            ArrayList<String> rowData = new ArrayList<>();
            rowData.add((String) tableDetailModel.getValueAt(i, 1)); // id product;            rowData.add( (String) tableDetailModel.getValueAt(i, 1) ); // id product;
            rowData.add((String) tableDetailModel.getValueAt(i, 4)); // id product;
            rowData.add("0"); // id product;
            data.add(rowData);
        }
        return data;
    }

}

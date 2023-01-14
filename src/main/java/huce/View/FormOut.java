/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import ObserverPattern.Observer;
import ObserverPattern.Subject;
import huce.Controller.HandleCreateForm;
import huce.Controller.HandleCreateFormOut;
import huce.Controller.LoadListProductToFormOut;
import huce.DAO.ProductDAO;
import huce.DAO.StoreDAO;
import huce.Model.ApplyPanel;
import huce.Model.FormRequest;
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
public class FormOut extends Form implements Subject{

    private JTextField jTextStore;
    private JTextField jTextStoreID;
    private FormRequest formRequest;
    public FormOut(JPanel gobackPanel, FormRequest formRequest) {
        this.formRequest = formRequest;
        this.setTitle("Phiếu xuất hàng");
        jTextStoreID = this.addJTextField(jPanelTop, "Mã cửa hàng", 5);
        jTextStore = this.addJTextField(jPanelTop, "Địa chỉ nhận hàng", 15);
        jTextStore.setEnabled(false);
        tableDetail = new JTable();
        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã sản phẩm", "Tên sản phẩm", "Theo yêu cầu", "Thực xuất", "Đơn vị ", "Đơn giá"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });

        tableDetail.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setListProductTable(new SimpleListProductsTable(this, new String[]{
            "STT", "ID", "Tên sản phẩm", "Số lượng yêu cầu", "Số lượng yêu cầu còn lại", "Đơn vị"
        }));
        this.jTableContainer.setViewportView(tableDetail);
        new LoadListProductToFormOut().loadTo(formRequest, jListProductJTable);
        this.jButtonCreate.addActionListener((e) -> {
            HandleCreateForm handleCreateForm = new HandleCreateFormOut();
            if (handleCreateForm.create(createFormModel())) {
                ApplyPanel.apply(gobackPanel, new ListRequestsPanel(gobackPanel));
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input, try again");
            }

        });
        this.jButtonDel.addActionListener((e) -> {
            ApplyPanel.apply(gobackPanel, WarehousePanel.helloPanel);
        });
        
        StoreDAO storeDAO = new StoreDAO();
        
        var store = storeDAO.get(formRequest.getCreateStore());
        this.jTextStoreID.setText(store.getId());
        this.jTextWhere.setText("Tại kho");
        this.jTextStore.setText(store.getAddress());

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
        huce.Model.FormOut formOut = new huce.Model.FormOut();

        formOut.setId(this.jTextIDForm.getText());
        formOut.setIdRequest(this.formRequest.getId());
        formOut.setCreateDate(this.jDateCreated.getDateStringOrEmptyString());
        formOut.setCreateLocation(this.jTextWhere.getText());
        formOut.setCreateStaff(this.jTextAccount.getText());
        formOut.setValue(0);
        formOut.setProductIds(this.getDetailsArray());
        
        return formOut;
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

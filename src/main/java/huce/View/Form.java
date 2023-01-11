/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import ObserverPattern.Subject;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public abstract class Form extends javax.swing.JPanel implements Subject {

    /**
     * Creates new form ProductImport
     */
    public Form() {
        initComponents();
        this.jTextAccount.setText(Login.loginAccount.getData()[0]);
        this.jDateCreated.setDateToToday();
    }


    public void setLookUpPanel(LookUpPanel panel) {
        this.jLookUpPanel.add(panel, BorderLayout.SOUTH);
    }

    public JTextField addJTextField(JPanel parent, String text, int column) {
        parent.add(new JLabel(text));
        JTextField textField = new JTextField(column);
        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        parent.add(textField);
        return textField;
    }

    public void setTitle(String title) {
        this.jLabel1.setText(title);
    }
    // return a table with titles as the column.

    public void setListProductTable(JTable table) {
        this.jListProductJTable = table;
        this.jTableListContainer.setViewportView(table);
    }

    public JTable getTableDetail() {
        return this.tableDetail;
    }

    public JTable getListProductJTable() {
        return this.jListProductJTable;
    }

    public String getValueInListProAt(String idProduct, int col) {
        var proTableModel = (DefaultTableModel) this.jListProductJTable.getModel();
        for (var row : proTableModel.getDataVector()) {
            if (row.get(1).equals(idProduct)) {
                return (String) row.get(col);
            }
        }
        return null;
    }
    abstract huce.Model.Form createFormModel();
    abstract ArrayList<ArrayList<String>> getDetailsArray();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelType = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        jButtonDel = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JSplitPane jSplitPane2 = new javax.swing.JSplitPane();
        jLookUpPanel = new javax.swing.JPanel();
        jLabelRight = new javax.swing.JLabel();
        jTableListContainer = new javax.swing.JScrollPane();
        javax.swing.JPanel jPanel4 = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        jTextIDForm = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        jDateCreated = new com.github.lgooddatepicker.components.DatePicker();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jTextWhere = new javax.swing.JTextField();
        javax.swing.JPanel jPanel8 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel10 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        jTextAmount = new javax.swing.JTextField();
        jTableContainer = new javax.swing.JScrollPane();
        jPanelBottom = new javax.swing.JPanel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        jTextAccount = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jPanelType.add(jLabel1);

        add(jPanelType, java.awt.BorderLayout.PAGE_START);

        jButtonDel.setText("Xóa phiếu");
        jPanel2.add(jButtonDel);

        jButtonCreate.setText("Tạo phiếu");
        jPanel2.add(jButtonCreate);

        jButtonPrint.setText("In phiếu");
        jPanel2.add(jButtonPrint);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLookUpPanel.setBackground(new java.awt.Color(204, 204, 204));
        jLookUpPanel.setLayout(new java.awt.BorderLayout());

        jLabelRight.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRight.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRight.setText("Danh sách sản phẩm đang có");
        jLabelRight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLookUpPanel.add(jLabelRight, java.awt.BorderLayout.PAGE_START);
        jLabelRight.getAccessibleContext().setAccessibleName("");

        jLookUpPanel.add(jTableListContainer, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jLookUpPanel);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanelTop.setPreferredSize(new java.awt.Dimension(891, 70));
        jPanelTop.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 7));

        jLabel2.setText("Số:");
        jPanelTop.add(jLabel2);

        jTextIDForm.setColumns(5);
        jTextIDForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanelTop.add(jTextIDForm);

        jLabel3.setText("Ngày lập:");
        jPanelTop.add(jLabel3);
        jPanelTop.add(jDateCreated);

        jLabel4.setText("Địa điểm:");
        jPanelTop.add(jLabel4);

        jTextWhere.setColumns(10);
        jTextWhere.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanelTop.add(jTextWhere);

        jPanel4.add(jPanelTop, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jLabel8.setText("Tổng số tiền:");
        jPanel10.add(jLabel8);

        jTextAmount.setColumns(15);
        jTextAmount.setEnabled(false);
        jPanel10.add(jTextAmount);

        jPanel8.add(jPanel10, java.awt.BorderLayout.PAGE_END);
        jPanel8.add(jTableContainer, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanelBottom.setLayout(flowLayout1);

        jLabel7.setText("Người lập phiếu:");
        jPanelBottom.add(jLabel7);

        jTextAccount.setColumns(10);
        jTextAccount.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanelBottom.add(jTextAccount);

        jPanel4.add(jPanelBottom, java.awt.BorderLayout.PAGE_END);

        jSplitPane2.setLeftComponent(jPanel4);

        jPanel3.add(jSplitPane2);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    protected JTable tableDetail;

    protected JTable jListProductJTable;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButtonCreate;
    protected javax.swing.JButton jButtonDel;
    protected javax.swing.JButton jButtonPrint;
    protected com.github.lgooddatepicker.components.DatePicker jDateCreated;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabelRight;
    protected javax.swing.JPanel jLookUpPanel;
    protected javax.swing.JPanel jPanelBottom;
    protected javax.swing.JPanel jPanelTop;
    protected javax.swing.JPanel jPanelType;
    protected javax.swing.JScrollPane jTableContainer;
    public javax.swing.JScrollPane jTableListContainer;
    protected javax.swing.JTextField jTextAccount;
    protected javax.swing.JTextField jTextAmount;
    protected javax.swing.JTextField jTextIDForm;
    protected javax.swing.JTextField jTextWhere;
    // End of variables declaration//GEN-END:variables
}

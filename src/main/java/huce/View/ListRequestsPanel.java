 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import huce.Controller.HandleSearchingRequestOut;
import huce.Controller.LoadListRequestOut;
import huce.DAO.FormRequestDAO;
import huce.Model.ApplyPanel;
import static huce.View.ListRequestsInPanel.PENDINGMODE;
import static huce.View.ListRequestsInPanel.PROCESSINGMODE;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ListRequestsPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListRequestsPanel
     */
    public ListRequestsPanel(JPanel goBackJPanel) {
        initComponents();
        var tableModel = (DefaultTableModel) jListRequestsTable.getModel();
        (new LoadListRequestOut()).loadTo(jListRequestsTable);
        
        this.jListRequestsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int row = jListRequestsTable.getSelectedRow();
                String state = (String) tableModel.getValueAt(row, 5);
                 jAcceptBtn.setEnabled(state.equals(PENDINGMODE) || state.equals(PROCESSINGMODE));
                jRefuseBtn.setEnabled(state.equals(PENDINGMODE));
            }

        });
        
        this.jAcceptBtn.addActionListener((e) -> {
            int row = jListRequestsTable.getSelectedRow();
            String id = (String) tableModel.getValueAt(row, 1);
            FormRequestDAO pAO = new FormRequestDAO();
            ApplyPanel.apply(goBackJPanel, new FormOut(goBackJPanel, (huce.Model.FormRequest) pAO.get(id)));
            jAcceptBtn.setEnabled(false);
            jRefuseBtn.setEnabled(false);
        });
        this.jRefuseBtn.addActionListener((e) -> {
            
            int row = jListRequestsTable.getSelectedRow();
            String id = (String) tableModel.getValueAt(row, 1);
            String status = (String) tableModel.getValueAt(row, 5);
            if(status.equals(PENDINGMODE)) {
            FormRequestDAO rqd = new FormRequestDAO();
            rqd.cancelForm(id);
            ApplyPanel.apply(goBackJPanel, new ListRequestsPanel(goBackJPanel));
            }
        });
//        this.jRefuseBtn.addActionListener((e) -> {
//            int row = jListRequestsTable.getSelectedRow();
//            tableModel.setValueAt(ListRequestsInPanel.CANCELMODE, row, 4);
//            jAcceptBtn.setEnabled(false);
//            jRefuseBtn.setEnabled(false);
//        });
        this.jViewNewestRequestsBtn.addActionListener((e) -> {
            new LoadListRequestOut().loadTo(jListRequestsTable);
        });
        
        this.jLookUpPanel.add(new LookUpPanel(new HandleSearchingRequestOut(), jListRequestsTable));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jListRequestsTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLookUpPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jAcceptBtn = new javax.swing.JButton();
        jRefuseBtn = new javax.swing.JButton();
        jViewNewestRequestsBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jListRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID phiếu", "ID cửa hàng", "Tên cửa hàng", "Địa chỉ", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jListRequestsTable.setShowGrid(false);
        jScrollPane1.setViewportView(jListRequestsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jLookUpPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel2.add(jLookUpPanel);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jAcceptBtn.setText("Duyệt");
        jAcceptBtn.setEnabled(false);
        jPanel1.add(jAcceptBtn);

        jRefuseBtn.setText("Từ chối");
        jRefuseBtn.setEnabled(false);
        jPanel1.add(jRefuseBtn);

        jViewNewestRequestsBtn.setText("Xem các yêu cầu mới");
        jPanel1.add(jViewNewestRequestsBtn);

        jPanel2.add(jPanel1);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh sách các yêu cầu");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAcceptBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jListRequestsTable;
    private javax.swing.JPanel jLookUpPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jRefuseBtn;
    private javax.swing.JButton jViewNewestRequestsBtn;
    // End of variables declaration//GEN-END:variables
}

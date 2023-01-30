/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import huce.DAO.ProductDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MAI NGOC DOAN
 */
public class Report extends javax.swing.JPanel {

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
        
        ProductDAO pdao = new ProductDAO();
        this.jDate.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now()));
        int sum = pdao.getAll().size();
        int notok = pdao.getExpiredProduct().size();
        this.jSumPro.setText(sum + "");
        this.jNotOkPro.setText(notok + "");

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDate = new javax.swing.JLabel();
        jSumPro = new javax.swing.JLabel();
        jNotOkPro = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Báo cáo thống kê kho");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Tổng số mặt hàng trong kho:");

        jLabel4.setText("Số mặt hàng hết hạn");

        jLabel5.setText("Ngày:");

        jDate.setText(".............");

        jSumPro.setText("....");

        jNotOkPro.setText("....");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jDate)
                .addGap(127, 127, 127))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNotOkPro)
                    .addComponent(jSumPro))
                .addContainerGap(551, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jDate))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSumPro))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jNotOkPro))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jNotOkPro;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jSumPro;
    // End of variables declaration//GEN-END:variables
}

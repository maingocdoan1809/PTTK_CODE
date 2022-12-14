/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package huce.View;

import huce.Controller.HandleSearching;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class LookUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form LookUpPanel
     */

    public LookUpPanel(HandleSearching handleSearching, JTable table) {
        initComponents();
        this.jButtonSearch.addActionListener((e) -> {
            handleSearching.search(table, this.jTextSearch.getText());
        });
        this.jClearResultBtn.addActionListener((e) -> {
            handleSearching.clear(table);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        jClearResultBtn = new javax.swing.JButton();
        jTextSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jClearResultBtn.setText("Clear");
        jPanel6.add(jClearResultBtn);

        jTextSearch.setColumns(15);
        jTextSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel6.add(jTextSearch);

        jButtonSearch.setText("Tìm kiếm");
        jPanel6.add(jButtonSearch);

        add(jPanel6);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonSearch;
    public javax.swing.JButton jClearResultBtn;
    public javax.swing.JTextField jTextSearch;
    // End of variables declaration//GEN-END:variables
}

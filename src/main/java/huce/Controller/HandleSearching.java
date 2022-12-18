/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public interface HandleSearching {
    void search(JTable table, String whatToSearch);
    void clear(JTable table);
}

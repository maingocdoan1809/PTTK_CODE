/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.Product;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public interface LoadListProductToForm {
    void loadTo(String id, JTable toTable, Product ...products);
}

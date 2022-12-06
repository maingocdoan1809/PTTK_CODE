/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormOut implements LoadListProductToForm{

    @Override
    public void loadTo(String id, JTable toTable) {
        System.out.println("Load " + id + " form to formOut");
    }
    
}

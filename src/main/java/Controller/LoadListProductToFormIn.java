/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormIn implements LoadListProductToForm{

    @Override
    public void loadTo(String id, JTable toTable) {
        System.out.println("Load " + id + " to formIn");
    }
    

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import huce.View.LookUpPanel;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class HandelSearchingRequestIn implements HandleSearching{

    @Override
    public void handel(LookUpPanel lookUpPanel, JTable table) {
        lookUpPanel.jButtonSearch.addActionListener((e) -> {
            System.out.println("Handle request in");
        });
    }
    
}

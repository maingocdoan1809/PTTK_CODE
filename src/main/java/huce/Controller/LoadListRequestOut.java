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
public class LoadListRequestOut implements LoadListRequest{

    @Override
    public void loadTo(JTable table) {
        System.out.println("Load to List RequestOut");
    }
    
}

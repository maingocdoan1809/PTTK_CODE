/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormOutDAO;
import huce.Model.Form;

/**
 *
 * @author Admin
 */
public class HandleCreateFormOut implements HandleCreateForm{

    @Override
    public boolean create(Form form) {
        System.out.println(form);
        if ( form == null ) {
            return false;
        }
        FormOutDAO fDAO = new FormOutDAO();
        fDAO.insert(form);
        return true;
    }
    
}

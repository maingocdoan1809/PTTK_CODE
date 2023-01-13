/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormInDAO;
import huce.Model.Form;

/**
 *
 * @author Admin
 */
public class HandleCreateFormIn implements HandleCreateForm{

    @Override
    public boolean create(Form form) {
        System.out.println(form);
        if ( form == null ) {
            return false;
        }
        FormInDAO fDAO = new FormInDAO();
        fDAO.insert(form);
        return true;
    }
    
}

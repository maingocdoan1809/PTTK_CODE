/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestInDAO;
import huce.Model.Form;

/**
 *
 * @author Admin
 */
public class HandleCreateFormRequestIn implements HandleCreateForm{

    @Override
    public boolean create(Form form) {
        System.out.println(form);
        if ( form == null ) {
            return false;
        }
        FormRequestInDAO requestInDAO = new FormRequestInDAO();
        requestInDAO.insert(form);
        return true;
    }
    
}

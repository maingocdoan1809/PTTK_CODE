/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.FormRequestDAO;
import huce.Model.Form;

/**
 *
 * @author Admin
 */
public class HandleCreateFormRequest implements HandleCreateForm{

    @Override
    public boolean create(Form form) {
        System.out.println(form);
        if ( form == null ) {
            return false;
        }
        FormRequestDAO requestInDAO = new FormRequestDAO();
        requestInDAO.insert(form);
        return true;
    }
    
}

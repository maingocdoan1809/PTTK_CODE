/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Form;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormRequestDAO implements FormDAO{

    @Override
    public boolean insert(Form data) {
        return FormDAO.super.insert(data); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Form get(String id) {
        
        return null;
    }
    
}

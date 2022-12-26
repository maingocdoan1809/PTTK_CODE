/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

import java.util.ArrayList;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormOut extends Form {

    private String idRequest;
    private int value;

    public void setIdRequest(String id) {
        this.idRequest = id;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public int getValue() {
        return value;
    }

}

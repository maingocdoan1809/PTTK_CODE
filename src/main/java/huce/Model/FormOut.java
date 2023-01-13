/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormOut extends Form {

    private String idRequest;
    private float value;

    public void setIdRequest(String id) {
        this.idRequest = id;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public float getValue() {
        return value;
    }

}

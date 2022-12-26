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
public abstract class Form {

    protected String id;
    protected String formIndex;
    protected String createDate;
    protected String createLocation;
    protected String createStaff;
    private ArrayList< ArrayList<String> > productIds;

    public void setId(String id) {
        this.id = id;
    }

    public void setFormIndex(String formIndex) {
        this.formIndex = formIndex;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setCreateLocation(String createLocation) {
        this.createLocation = createLocation;
    }

    public void setCreateStaff(String createStaff) {
        this.createStaff = createStaff;
    }

    public String getId() {
        return id;
    }

    public String getFormIndex() {
        return formIndex;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getCreateLocation() {
        return createLocation;
    }

    public String getCreateStaff() {
        return createStaff;
    }

    public ArrayList<ArrayList<String>> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<ArrayList<String>> productIds) {
        this.productIds = productIds;
    }
}

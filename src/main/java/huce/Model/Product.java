/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

/**
 *
 * @author MAI NGOC DOAN
 */
public class Product {

    private String id;
    private String name;
    private Float priceIn;
    private Float priceOut;
    private String issue; // nha sx
    private String from; // xuat xu;
    private String mgf; // ngay san xuat: manufacturing date
    private String exp; // han su dung
    private String unit; // don vi
    private Spot spot;

    public Product(String id, String name,
            String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public void setPrice(Float priceIn, Float priceOut) {
        this.priceIn = priceIn;
        this.priceOut = priceOut;
    }

    public void setManufacturer(String issue, String from) {
        this.issue = issue;
        this.from = from;
    }

    public void setDate(String mgf, String exp) {
        this.mgf = mgf;
        this.exp = exp;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public String[] toStringArr(int... stt) {
        var currLocation = spot.getCurrLocation();
        String idLocation = null;
        String kind = null;
        if (currLocation != null) {

            kind = currLocation.getName();
            idLocation = currLocation.getId() + " - " + this.id;
        }
        if (stt.length > 0) {
            return new String[]{stt[0] + "",
                id, name, idLocation, kind, priceOut + "", mgf, exp, spot.getRealQuantity() + ""
            };
        }
        return new String[]{
            id, name, idLocation, kind, priceOut + "", mgf, exp, spot.getRealQuantity() + ""
        };
    }

}

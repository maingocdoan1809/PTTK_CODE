/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

/**
 *
 * @author MAI NGOC DOAN
 */
public class Spot {
    private String id;
    private int maxQuantity;
    private int realQuantity;
    public Spot(String id, int max, int real) {
        this.id = id;
        this.maxQuantity = max;
        this.realQuantity = real;
    }
    public String[] toStringArr(int ...stt) {
        if (stt.length > 0) {
            return new String[]{stt[0] + "", id, maxQuantity + "", realQuantity + ""};
        }
        return new String[]{id, maxQuantity + "", realQuantity + ""};
    }
}

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
public class Location {
    private String id;
    private String name;
    ArrayList<Spot> spots;

    public Location(String id, String name) {
        this.id = id;
        this.name = name;
        spots = null;
    }
    public void setSpots(ArrayList<Spot> spots) {
        this.spots = spots;
    } 
    public ArrayList<Spot> getSpots() {
        return this.spots;
    }
    
    public String[] toStringArr(int ...stt) {
        if ( stt.length > 0 ) {
            return new String[]{stt[0] + "", id, name};
        }
        return new String[]{id, name};
    }
    
}

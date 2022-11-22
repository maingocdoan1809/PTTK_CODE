/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.WareHouse;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class DatabaseController {
    public static WareHouse loadData(Connection database) {
        WareHouse wareHouse = new WareHouse();
        return wareHouse;
    }
    public static boolean saveData(WareHouse wareHouse, Connection database) {
        return true;
    }
}

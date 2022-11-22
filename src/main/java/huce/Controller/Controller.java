/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package huce.Controller;

import huce.Model.WareHouse;
import huce.View.Login;
import huce.View.Main;
import huce.View.WarehousePanel;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public abstract  class Controller {
    private WareHouse wareHouse;
    public Controller(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }
    public abstract void controll( Main mainApp, WarehousePanel warehousePanel , Connection database,  Login login );
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.ApplyPanel;
import huce.Model.WareHouse;
import huce.View.Login;
import huce.View.Main;
import huce.View.WarehousePanel;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class LogoutController extends Controller {

    public LogoutController(WareHouse wareHouse) {
        super(wareHouse);
    }
    @Override
    public void controll(Main mainApp, WarehousePanel warehousePanel, Connection database, Login login) {
        warehousePanel.addLogoutListener((e) -> {
            login.resetText();
            ApplyPanel.apply(mainApp.jMainPanel, login);
        });
    }
}

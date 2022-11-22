/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.ApplyPanel;
import huce.View.Login;
import huce.View.Main;
import huce.View.WarehousePanel;
import java.sql.Connection;

/**
 *
 * @author Admin
 */
public class LogoutController {
    public LogoutController(Main mainApp, Login login, WarehousePanel mainPanel, Connection database) {
        mainPanel.addLogoutListener( (e) -> {
            login.resetText();
            ApplyPanel.apply(mainApp.jMainPanel, login);
        } );
    }
}

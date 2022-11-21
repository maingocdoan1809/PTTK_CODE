/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.View.Login;
import huce.View.Main;
import huce.View.WarehousePanel;

/**
 *
 * @author Admin
 */
public class LoginController {

    Login login;
    Main mainApp;

    public LoginController() {
        login = new Login();
        mainApp = new Main();
        login.addLoginListener((e) -> {
            if (login.getUsername().equals("maingocdoan")
                    && login.getPassword().equals("28025458")) {
                mainApp.showPanel(new WarehousePanel());
            } else {
                login.showError();
            }
        });
        mainApp.showPanel(login);
        mainApp.pack();
        mainApp.setLocationRelativeTo(null);
        mainApp.setVisible(true);

    }
//    private void showPanel(  )

}

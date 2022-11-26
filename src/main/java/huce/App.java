/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package huce;

import huce.Controller.DatabaseController;
import huce.Controller.LoginController;
import huce.Controller.LogoutController;
import huce.Controller.WarehouseController;
import huce.Model.WareHouse;
import huce.View.Form;
import huce.View.Login;
import huce.View.Main;
import huce.View.WarehousePanel;
import java.sql.Connection;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class App {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // connect to SQL here: 
                Connection database = null;
                // prepare model:
                WareHouse model = DatabaseController.loadData(database);
                Main main = new Main();
                Login login = new Login();
                WarehousePanel warehousePanel = new WarehousePanel();

                // add controller.
                LoginController logincontroller = new LoginController(model);
                LogoutController logoutController = new LogoutController(model);
                WarehouseController warehouseController = new WarehouseController(model);
                logincontroller.controll(main, warehousePanel, database, login);
                logoutController.controll(main, warehousePanel, database, login);
                warehouseController.controll(main, warehousePanel, database, null);
                // show app:
                main.pack();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }
}

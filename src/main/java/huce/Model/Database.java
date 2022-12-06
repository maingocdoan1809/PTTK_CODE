/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Database {

    private static Connection instance;

    public static Connection getConnection() {
        if (Database.instance == null) {
            try {
                Database.instance = DriverManager.getConnection(url, user, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return instance;
    }
    static String url = "jdbc:mysql://localhost:3306/QLKho";
    static String user = "root";
    static String password = "";

    private Database() {
    }

}

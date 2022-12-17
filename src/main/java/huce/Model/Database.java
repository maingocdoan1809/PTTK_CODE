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
    /**
     * 
     * @return a connection to a database with 3 properties:
     *  {@code url}, {@code username}, {@code password}, 
     * you can modify it through {@code Database}'s
     * static variables
     * 
     */
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
    private static String url = "jdbc:mysql://localhost:3306/qlkho";
    private static String user = "root";
    private static String password = "";
    public static void setDataBaseStr(String url) {
        Database.url = url;
    }
    public static void setUsername(String username) {
        Database.user = username;
    }
    public static void setPassword(String password) {
        Database.password = password;
    }
    private Database() {
    }

}

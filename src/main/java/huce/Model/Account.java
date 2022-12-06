/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

/**
 *
 * @author Admin
 */
public abstract class Account {
    String username;
    String password;
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String[] getData() {
        return new String[]{username, password};
    }
}

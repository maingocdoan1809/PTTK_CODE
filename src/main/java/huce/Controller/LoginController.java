/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.AccountDAO;
import huce.Model.Account;
import huce.Model.AdminAccount;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class LoginController {
    public Account login(String username, String password) {
        AccountDAO dao = new AccountDAO();
        var accounts = dao.getAll();
        var account = accounts.get(username);
        if ( account.getData()[2].equals(password) ) {
            return accounts.get(username);
        }

        return null;
    }
}

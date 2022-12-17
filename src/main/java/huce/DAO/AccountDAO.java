/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Account;
import huce.Model.AdminAccount;
import huce.Model.Database;
import huce.Model.StaffAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class AccountDAO implements DataAccess<Account>{

    /**
     * @deprecated This function is not supported by AccountDAO.
     * @param username
     * @return
     * @throws UnsupportedOperationException 
     */
    @Override
    public Account get(String username) throws UnsupportedOperationException{
        throw new UnsupportedOperationException("");
    }
    

    @Override
    public HashMap<String, Account> getAll() {
        HashMap<String, Account> data = new HashMap<>();
        Connection c = Database.getConnection();
        
        try {
            var stm = c.createStatement();
            var result = stm.executeQuery("Select * from `taikhoan` ");
            while (result.next()) {
                String username = result.getString("Tentaikhoan");
                String password = result.getString("matkhau");
                String position = result.getString("Chucvu");
                if ( position.equals("1")) {
                    data.put(username, new AdminAccount(username, password));
                } else {
                    data.put(username, new StaffAccount( username, password));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
        
    }

    
}

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

    /**
     * 
     * insert new Account to database
     * @param data : an Account to be inserted.
     */
    @Override
    public void insert(Account data) {
    }
    
    /**
     * @deprecated This function is not supported by AccountDAO.
     * @param id
     * @param newData
     * @throws UnsupportedOperationException 
     */
    @Override
    public void update(String id, Account newData) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }
    /**
     * @deprecated This function is not supported by AccountDAO.
     * @param id
     * @throws UnsupportedOperationException 
     */
    @Override
    public void delete(String id) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public HashMap<String, Account> getAll() {
        HashMap<String, Account> data = new HashMap<>();
        Connection c = Database.getConnection();
        
        try {
            var stm = c.createStatement();
            var result = stm.executeQuery("Select * from `1` ");
            while (result.next()) {
                String id = result.getString("ID");
                String username = result.getString("Username");
                String password = result.getString("Password");
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

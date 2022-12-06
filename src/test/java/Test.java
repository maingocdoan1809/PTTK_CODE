
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class Test {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    static String url = "jdbc:mysql://localhost:3306/QLKho";
    static String user = "root";
    static String password = "";

    public static void main(String[] args) {
        Connection c = getConnection();
        System.out.println(c);
        try {
            var stm = c.createStatement();
            var result = stm.executeQuery("Select * from `1`");
            while(result.next()) {
                System.out.println(result.getString("ID"));                
                System.out.println(result.getString("Username"));
                System.out.println(result.getString("Password"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

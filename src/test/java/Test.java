
import huce.DAO.LocationDAO;
import huce.Model.Location;
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

    public static void main(String[] args) {
        LocationDAO dao = new LocationDAO();
        var ps = dao.getAll();
        for (var p : ps.values()) {
            System.out.println("PID: " + p + "\n");
            System.out.println(p.getSpots());
        }
    }
}


import com.github.lgooddatepicker.components.DatePicker;
import huce.DAO.FormInDAO;
import huce.DAO.LocationDAO;
import huce.DAO.StoreDAO;
import huce.Model.FormIn;
import huce.Model.Location;
import huce.Model.Store;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

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
        FormInDAO formInDAO = new FormInDAO();
        var formIn = formInDAO.getAll("1234");
        System.out.println(formIn);
    }
}

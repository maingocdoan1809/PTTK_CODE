
import com.github.lgooddatepicker.components.DatePicker;
import huce.DAO.LocationDAO;
import huce.Model.Location;
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
        DatePicker d = new DatePicker();
        d.setLocale(Locale.CHINA);
        d.setDateToToday();
        System.out.println(d.getDate() );
    }
}


import com.github.lgooddatepicker.components.DatePicker;
import huce.DAO.LocationDAO;
import huce.Model.Spot;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



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
        LocationDAO locationDAO = new LocationDAO();
        
        var locations = locationDAO.getAll();
        
        var spots = new ArrayList<Spot>();
        
        locations.forEach( (idLocation, location) -> {
            for (var spot : location.getSpots()) {
                spots.add(spot);
            }
        });
        spots.forEach((spot) -> {
            System.out.println(spot.getId());
        });
    }
}

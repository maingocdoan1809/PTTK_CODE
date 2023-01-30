
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



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
        System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now()));
    }
}

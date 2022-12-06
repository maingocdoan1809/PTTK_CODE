/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import java.awt.List;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public interface DataAccect<T> {
    T get(String id);
    void insert(T data);
    void update(String id, T newData);
    void delete(String id);
    // String == id
    // T == object
    HashMap<String, T> getAll();
}

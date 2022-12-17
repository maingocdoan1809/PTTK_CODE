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
 * @param <T>
 */
public interface DataAccess<T> {

    default T get(String id) {
        throw new UnsupportedOperationException();
    }

    default void insert(T data) {
        throw new UnsupportedOperationException();
    }

    default void update(String id, T newData) {
        throw new UnsupportedOperationException();

    }

    default void delete(String id) {
        throw new UnsupportedOperationException();

    }

    // String == primary key
    // T == object
    default HashMap<String, T> getAll() {
        throw new UnsupportedOperationException();

    }
}

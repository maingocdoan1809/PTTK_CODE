/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.DAO.LocationDAO;
import huce.DAO.ProductDAO;
import huce.Model.Location;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadProductLocation {

    public void loadTo(JTable jLot, JTable jSpot) {
        LocationDAO ldao = new LocationDAO();
        var jLotModel = (DefaultTableModel) jLot.getModel();
        var jSpotModel = (DefaultTableModel) jSpot.getModel();

        jLotModel.setRowCount(0);
        jSpotModel.setRowCount(0);

        var locations = ldao.getAll();
        int stt = 1;
        for (var location : locations.values()) {
            jLotModel.addRow(location.toStringArr(stt));
            stt++;
        }
        jLot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jSpotModel.setRowCount(0);
                String locationId = (String) 
                        jLotModel.getValueAt(jLot.getSelectedRow(), 1);
                Location location = locations.get(locationId);
                int sttSpot = 1;
                for (var spot : location.getSpots()) {
                    jSpotModel.addRow(spot.toStringArr(sttSpot));
                    sttSpot++;
                }
            }

        });

    }
}

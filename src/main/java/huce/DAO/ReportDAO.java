/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.ReportModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A
 */
public class ReportDAO {

    public List<ReportModel> getOut(String date, String toDate) {
        Connection connection = Database.getConnection();
        List<ReportModel> reportList = new ArrayList<>();
        try {
            var stm = connection.createStatement();
            String query = """
                           SELECT ct.MaSp, sp.TenSp,COUNT(ct.SoLuong) as SoLuongXuat 
                           FROM chitietxuathang ct, sanpham sp, phieuxuat px 
                           WHERE ct.MaSp = sp.MaSp and px.MaPhieu = ct.MaPhieu and px.NgayLapPhieu BETWEEN '%s' AND '%s'
                           GROUP BY ct.MaPhieu ASC;
                           """.formatted(date, toDate);
            var result = stm.executeQuery(query);
            while (result.next()) {
                ReportModel report = new ReportModel(result.getString("MaSp"), result.getString("TenSp"), result.getInt("SoLuongXuat"));
                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportList;
    }
    
    public List<ReportModel> getIn(String date, String toDate) {
        Connection connection = Database.getConnection();
        List<ReportModel> reportList = new ArrayList<>();
        try {
            var stm = connection.createStatement();
            String query = """
                            SELECT ct.MaSp, sp.TenSp,COUNT(ct.SoLuongNhap) as SoLuongXuat 
                                                      FROM chitietnhaphang ct, sanpham sp, phieunhap pn 
                                                      WHERE ct.MaSp = sp.MaSp and pn.MaPhieu = ct.MaPhieu and pn.NgayLapPhieu BETWEEN '%s' AND '%s'
                                                      GROUP BY ct.MaPhieu ASC;;
                           """.formatted(date, toDate);
            var result = stm.executeQuery(query);
            while (result.next()) {
                ReportModel report = new ReportModel(result.getString("MaSp"), result.getString("TenSp"), result.getInt("SoLuongXuat"));
                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportList;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Form;
import huce.Model.FormRequestIn;
import huce.View.ListRequestsInPanel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormRequestInDAO implements FormDAO {

    @Override
    public Form get(String id) {
        Connection connection = Database.getConnection();
        try {

            var stm = connection.createStatement();
            var result = stm.executeQuery(
                    "Select * from `phieuyeucaunhap` where `MaphieuYCN` = '%s'".
                            formatted(id));
            FormRequestIn form = new FormRequestIn();

            result.next();
            form.setId(id);
            form.setProvider(result.getString("Mancc"));
            form.setCreateDate(result.getString("NgayLap"));
            form.setState(result.getString("Trangthai"));
            form.setCreateStaff(result.getString("Manguoilap"));

            String queryToGetDetail = """
                                      Select * from `chitietyeucaunhaphang`
                                      where `maphieuYCN` = '%s'
                                      """.formatted(form.getId());
            var resultDetail = stm.executeQuery(queryToGetDetail);
            ArrayList<ArrayList<String>> details = new ArrayList<>();
            while (resultDetail.next()) {
                ArrayList<String> row = new ArrayList<>();
                row.add(resultDetail.getString("MaSp"));
                row.add(resultDetail.getString("Soluongtheoyeucau"));
                details.add(row);
            }
            form.setProductIds(details);
            return form;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Form data) {
        return false;
    }

    @Override
    public HashMap<String, Form> getAll() {
        try {
            HashMap<String, Form> forms = new HashMap<>();
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            var result = stm.executeQuery("Select `maphieuYCN` from `phieuyeucaunhap`");
            while (result.next()) {
                String id = result.getString("MaphieuYCN");
                forms.put(id, get(id));
            }
            return forms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HashMap<String, HashMap<String, String>> getRemainProduct(String id) {
        String sqlGetAllProduct = """
                                  Select * from `chitietyeucaunhaphang`
                                  INNER JOIN `sanpham`
                                  ON sanpham.MaSp = chitietyeucaunhaphang.MaSp
                                  WHERE `MaPhieuYCN`= '%s'
                                  """.formatted(id);
        String sql = """
                     SELECT *, SUM(`SoLuongNhap`) as DaNhap from `chitietnhaphang`
                     WHERE `MaPhieu` in (
                         SELECT `MaPhieu` from `phieunhap`
                         WHERE `MaPhieuYCN` = '%s'
                     )
                     GROUP by `MaSp`
                     
                     """.formatted(id);
        try {
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            HashMap< String,HashMap<String, String>> data = new HashMap<>();
            
            var result = stm.executeQuery(sqlGetAllProduct);
            while (result.next()) {
//                int requestNum = Integer.parseInt( result.getString("Soluongyeucau") );
//                int realNum = Integer.parseInt(result.getString("Danhap"));
//                int remain = requestNum - realNum;
                HashMap<String, String> row = new HashMap<>();
                row.put("soluongtheoyeucau", result.getString("Soluongtheoyeucau"));
                row.put("tensp", result.getString("Tensp"));
                row.put("donvi", result.getString("donvi"));
                data.put( result.getString("MaSp"), row);
            }
            return  data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean changeMode(String id, String currmode, String toMode) {
        try {
            HashMap<String, Form> forms = new HashMap<>();
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            var result = stm.executeQuery(
                    "Select `trangthai` from `phieuyeucaunhap` where `trangthai` = '%s' and `maphieuYCN` = '%s'".
                            formatted(id, currmode));
            result.next();
            String isOk = result.getString("Trangthai");
            stm.execute("Update `phieuyeucaunhap` set `trangthai` = '%s' where `maphieuYCN` = '%s'".formatted(toMode));
        } catch (SQLException e) {
            System.out.println("Khong co phieu nao");
        }
        return false;
    }

    public boolean cancelForm(String id) {
        return changeMode(id, ListRequestsInPanel.PENDINGMODE, ListRequestsInPanel.CANCELMODE);
    }
}

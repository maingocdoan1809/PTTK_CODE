/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Form;
import huce.Model.FormRequest;
import huce.Model.Product;
import huce.View.ListRequestsInPanel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormRequestDAO implements FormDAO{

    @Override
    public boolean insert(Form data) {
        FormRequest formRequest = (FormRequest) data;

        try {

            Connection c = Database.getConnection();
            var stm = c.createStatement();

            String sql = """
                         Insert into `phieuyeucauxuat` values
                         ('%s', '%s', '%s', N'Đang chờ', '%s', '%s')
                         """.formatted(formRequest.getId(),
                    formRequest.getCreateStore(), formRequest.getCreateDate(),
                    formRequest.getState(),
                    formRequest.getReason(), 
                    formRequest.getCreateStaff());

            stm.execute(sql);

            // insert chitiet:
            var productRequests = formRequest.getProductIds();
            for (var p : productRequests) {
                String inStm = """
                               insert into `chitietyeucauxuathang`
                               values('%s', '%s', %d)
                               """.formatted(formRequest.getId(), p.get(0), Integer.parseInt(p.get(2)));
                stm.execute(inStm);
            }

            return true;
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Form get(String id) {
         Connection connection = Database.getConnection();
        try {

            var stm = connection.createStatement();
            var result = stm.executeQuery(
                    "Select * from `phieuyeucauxuat` where `MaphieuYCX` = '%s'".
                            formatted(id));
            FormRequest form = new FormRequest();

            result.next();
            form.setId(id);
            form.setCreateDate(result.getString("NgayLap"));
            form.setState(result.getString("Trangthai"));
            form.setCreateStaff(result.getString("Manguoilap"));
            form.setCreateStore(result.getString("MaCH"));            
            form.setReason(result.getString("LyDo"));

            
            String queryToGetDetail
                    = """
                    Select phieuyeucauxuat.MaPhieuYCX, chitietyeucauxuathang.MaSp, chitietyeucauxuathang.SoLuongYeuCau  , SUM(chitietxuathang.SoLuong) as DaNhap, chitietyeucauxuathang.SoLuongTheoYeuCau -SUM(chitietxuathang.SoLuong) as ConThieu from (
                    (phieuyeucauxuat left JOIN chitietyeucauxuathang
                    ON phieuyeucauxuat.MaPhieuYCN = chitietyeucauxuathang.MaPhieuYCX)
                    left JOIN (
                    phieuxuat INNER JOIN chitietxuathang
                    ON phieuxuat.MaPhieu = chitietxuathang.MaPhieu
                    )
                        ON phieuyeucauxuat.MaPhieuYCX = phieuxuat.MaPhieuYCN and chitietyeucauxuathang.MaSp = chitietxuathang.MaSp
                        )
                      where phieuyeucauxuat.MaPhieuYCX = '%s'
                        GROUP BY phieuyeucauxuat.MaPhieuYCX, chitietyeucauxuathang.MaSp
                        
                    """.formatted(form.getId());
            var resultDetail = stm.executeQuery(queryToGetDetail);
            ArrayList<ArrayList<String>> details = new ArrayList<>();
            ProductDAO pdao = new ProductDAO();
            while (resultDetail.next()) {
                ArrayList<String> row = new ArrayList<>();

                Product product = pdao.get(resultDetail.getString("MaSp"));
                row.add(product.getId());
                row.add(product.getName());
                row.add(resultDetail.getString("Soluongyeucau"));
                String conThieu = resultDetail.getString("ConThieu");
                if (conThieu == null) {
                    row.add(resultDetail.getString("Soluong"));
                } else {
                    row.add(conThieu);
                }
                row.add(product.getUnit());
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
    public HashMap<String, Form> getAll() {
        try {
            HashMap<String, Form> forms = new HashMap<>();
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            var result = stm.executeQuery("Select `maphieuYCX` from `phieuyeucauxuat`");
            while (result.next()) {
                String id = result.getString("MaphieuYCX");
                forms.put(id, get(id));
            }
            return forms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private boolean changeMode(String id, String toMode) {
        try {
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            stm.execute("Update `phieuyeucauxuat` set `trangthai` = '%s' where `maphieuYCX` = '%s'".formatted(toMode, id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean cancelForm(String id) {
        return changeMode(id, ListRequestsInPanel.CANCELMODE);
    }

    public boolean finishForm(String id) {
        return changeMode(id, ListRequestsInPanel.FINISHMODE);
    }

    public boolean processForm(String id) {
        return changeMode(id, ListRequestsInPanel.PROCESSINGMODE);
    }

    public int check(String id) {
        FormRequest formRequest = (FormRequest) get(id);
        var data = formRequest.getProductIds();
        int curr = 0;
        int init = 0;
        for (var product : data) {
            int request = Integer.parseInt(product.get(2));
            int remain = product.get(3) == null ? request : Integer.parseInt(product.get(3));
            init += request;
            curr += remain;
        }
        if (curr == 0) {
            JOptionPane.showMessageDialog(null, "Đã hoàn thành!");
            finishForm(id);
            return 1;
        } else if (curr < init) {
            processForm(id);
            return -1;
        }
        return 0;
    }
}

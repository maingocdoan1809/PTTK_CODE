/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Form;
import huce.Model.FormRequestIn;
import huce.Model.Product;
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

            String queryToGetDetail
                    = """
                    Select phieuyeucaunhap.MaPhieuYCN, chitietyeucaunhaphang.MaSp, chitietyeucaunhaphang.SoLuongTheoYeuCau  , SUM(chitietnhaphang.SoLuongNhap) as DaNhap, chitietyeucaunhaphang.SoLuongTheoYeuCau -SUM(chitietnhaphang.SoLuongNhap) as ConThieu from (
                    (phieuyeucaunhap left JOIN chitietyeucaunhaphang
                    ON phieuyeucaunhap.MaPhieuYCN = chitietyeucaunhaphang.MaPhieuYCN)
                    left JOIN (
                    phieunhap INNER JOIN chitietnhaphang
                    ON phieunhap.MaPhieu = chitietnhaphang.MaPhieu
                    )
                        ON phieuyeucaunhap.MaPhieuYCN = phieunhap.MaPhieuYCN and chitietyeucaunhaphang.MaSp = chitietnhaphang.MaSp
                        )
                      where phieuyeucaunhap.MaPhieuYCN = '%s'
                        GROUP BY phieuyeucaunhap.MaPhieuYCN, chitietyeucaunhaphang.MaSp
                        
                    """.formatted(form.getId());
            var resultDetail = stm.executeQuery(queryToGetDetail);
            ArrayList<ArrayList<String>> details = new ArrayList<>();
            ProductDAO pdao = new ProductDAO();
            while (resultDetail.next()) {
                ArrayList<String> row = new ArrayList<>();

                Product product = pdao.get(resultDetail.getString("MaSp"));
                row.add(product.getId());
                row.add(product.getName());
                row.add(resultDetail.getString("Soluongtheoyeucau"));
                String conThieu = resultDetail.getString("ConThieu");
                if ( conThieu == null ) {
                    row.add(resultDetail.getString("Soluongtheoyeucau"));
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
    public boolean insert(Form data) {
        
        FormRequestIn formRequestIn = (FormRequestIn) data;
        
        try {
            
            Connection c = Database.getConnection();
            var stm = c.createStatement();
            
            String sql = """
                         Insert into `phieuyeucaunhap` values
                         ('%s', '%s', '%s', N'Đang chờ', '%s')
                         """.formatted(formRequestIn.getId(),
                                 formRequestIn.getProvider(), formRequestIn.getCreateDate(),
                                 formRequestIn.getCreateStaff());
            
            stm.execute(sql);
            
            // insert chitiet:
            
            var productRequests = formRequestIn.getProductIds();
            for ( var p : productRequests ) {
                String inStm = """
                               insert into `chitietyeucaunhaphang`
                               values('%s', '%s', %d)
                               """.formatted( formRequestIn.getId(), p.get(0), Integer.parseInt(p.get(2))  );
                stm.execute(inStm);
            }
            
            return true;
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
                
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

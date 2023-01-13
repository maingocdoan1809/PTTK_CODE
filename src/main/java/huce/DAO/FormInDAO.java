/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Form;
import huce.Model.FormIn;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author MAI NGOC DOAN
 */
public class FormInDAO implements FormDAO{

    @Override
    public Form get(String id) {
        Connection connection = Database.getConnection();
        try {
            var stm = connection.createStatement();
            FormIn formIn = new FormIn();
            String query = """
                           SELECT * FROM `phieunhap` 
                           where `maphieu` = '%s'
                           """.formatted(id);
            var result = stm.executeQuery(query);
            while (result.next()) {
                formIn.setId( result.getString("Maphieu") );                
                formIn.setIdFormRequestIn(result.getString("MaphieuYCN") );
                formIn.setCreateDate(result.getString("Ngaylapphieu"));
                formIn.setCreateLocation(result.getString("Diadiemlapphieu") );
                formIn.setValue(result.getFloat("Tongsotien") );
                formIn.setCreateStaff(result.getString("Manguoilap"));
            }
            
            String queryToGetDetail = """
                                      Select * from `chitietnhaphang`
                                      where `maphieu` = '%s'
                                      """.formatted(formIn.getId());
            var resultDetail = stm.executeQuery(queryToGetDetail);
            ArrayList<ArrayList<String>> details = new ArrayList<>();
            while (resultDetail.next()) {
                
                ArrayList<String> row = new ArrayList<>();
                row.add( resultDetail.getString("MaSp") );
                row.add( resultDetail.getString("Soluongnhap") );
                row.add( resultDetail.getString("Thanhtien") );
                details.add(row);
            }
            formIn.setProductIds(details);
            return formIn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Form data) {
        Connection connection = Database.getConnection();
        try {
            FormIn formIn = (FormIn) data;
            var stm = connection.createStatement();
            var queryInsertFormIn = """
                                    
                                    Insert into `phieunhap` values(
                                    '%s', '%s', '%s', '%s', %f, '%s'
                                    )
                                    
                                    """.formatted(
                                            formIn.getId(),
                                            formIn.getIdFormRequestIn(),
                                            formIn.getCreateDate(),
                                            formIn.getCreateLocation(),
                                            formIn.getValue(),
                                            formIn.getCreateStaff()   
                                    );
            stm.execute(queryInsertFormIn);
            var details = formIn.getProductIds();
            ProductDAO pdao = new ProductDAO();
            for ( var p : details ) {
                int importNum = Integer.parseInt(p.get(1));
                String idProduct = p.get(0);
                var queryInsertDetail = """
                                        Insert into `chitietnhaphang` values(
                                         '%s', '%s', '%d', '%f'
                                        )
                                        """.formatted(
                                                formIn.getId(),
                                                idProduct,
                                                importNum,
                                                Float.parseFloat(p.get(2))
                                        );
                stm.execute(queryInsertDetail);
                pdao.importProduct(idProduct, importNum);
            }
            
            FormRequestInDAO formRequestInDAO = new FormRequestInDAO();
            formRequestInDAO.check(formIn.getIdFormRequestIn());
            JOptionPane.showMessageDialog(null, "Kho đã được cập nhật!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Form> getAll(String idRequest) {
        Connection connection = Database.getConnection();
        try {
            
            var stm = connection.createStatement();
            ArrayList<Form> allForms = new ArrayList<>();
            var ids = stm.executeQuery("Select `maphieu` from `phieunhap` where `maphieuycn` = '%s'".formatted(idRequest));
            
            while(ids.next()) {
                allForms.add( get(ids.getString("maphieu")) );
            }
            
            return allForms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

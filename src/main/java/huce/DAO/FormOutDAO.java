/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.DAO;

import huce.Model.Database;
import huce.Model.Form;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormOutDAO implements FormDAO {

    public ArrayList<Form> getAll(String idRequest) {
        Connection connection = Database.getConnection();
        try {
            
            var stm = connection.createStatement();
            ArrayList<Form> allForms = new ArrayList<>();
            var ids = stm.executeQuery("Select `maphieu` from `phieuxuat` where `maphieuycx` = '%s'".formatted(idRequest));
            
            while(ids.next()) {
                allForms.add( get(ids.getString("maphieu")) );
            }
            
            return allForms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(Form data) {
        Connection connection = Database.getConnection();
        try {
            huce.Model.FormOut formOut = (huce.Model.FormOut) data;
            var stm = connection.createStatement();
            var queryInsertFormIn = """
                                    
                                    Insert into `phieuxuat` values(
                                    '%s', '%s', '%s', '%s', %f, '%s'
                                    )
                                    
                                    """.formatted(
                                            formOut.getId(),
                                            formOut.getIdRequest(),
                                            formOut.getCreateDate(),
                                            formOut.getCreateLocation(),
                                            formOut.getValue(),
                                            formOut.getCreateStaff()   
                                    );
            stm.execute(queryInsertFormIn);
            var details = formOut.getProductIds();
            ProductDAO pdao = new ProductDAO();
            for ( var p : details ) {
                int importNum = Integer.parseInt(p.get(1));
                String idProduct = p.get(0);
                var queryInsertDetail = """
                                        Insert into `chitietxuathang` values(
                                         '%s', '%s', '%d', '%f'
                                        )
                                        """.formatted(
                                                formOut.getId(),
                                                idProduct,
                                                importNum,
                                                Float.parseFloat(p.get(2))
                                        );
                stm.execute(queryInsertDetail);
                pdao.exportProduct(idProduct, importNum);
            }
            
            FormRequestDAO formRequestDAO = new FormRequestDAO();
            formRequestDAO.check(formOut.getIdRequest());
            JOptionPane.showMessageDialog(null, "Kho đã được cập nhật!");
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
            huce.Model.FormOut formOut = new huce.Model.FormOut();
            String query = """
                           SELECT * FROM `phieuxuat` 
                           where `maphieu` = '%s'
                           """.formatted(id);
            var result = stm.executeQuery(query);
            while (result.next()) {
                formOut.setId(result.getString("Maphieu"));
                formOut.setIdRequest(result.getString("MaphieuYCX"));
                formOut.setCreateLocation(result.getString("MaCh"));
                formOut.setCreateDate(result.getString("Ngaylapphieu"));
                formOut.setCreateLocation(result.getString("Diadiemlapphieu"));
                formOut.setValue(result.getFloat("Tongsotien"));
                formOut.setCreateStaff(result.getString("Manguoilap"));
            }

            String queryToGetDetail = """
                                      Select * from `chitietxuathang`
                                      where `maphieu` = '%s'
                                      """.formatted(formOut.getId());
            var resultDetail = stm.executeQuery(queryToGetDetail);
            ArrayList<ArrayList<String>> details = new ArrayList<>();
            while (resultDetail.next()) {

                ArrayList<String> row = new ArrayList<>();
                row.add(resultDetail.getString("MaSp"));
                row.add(resultDetail.getString("Soluong"));
                row.add(resultDetail.getString("Thanhtien"));
                details.add(row);
            }
            formOut.setProductIds(details);
            return formOut;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

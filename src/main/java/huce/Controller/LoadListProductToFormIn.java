/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.Form;
import huce.Model.Product;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LoadListProductToFormIn implements LoadListProductToForm {

    @Override
    public void loadTo(Form formIn, JTable toTable, Product... products) {
        var tableModel = (DefaultTableModel) toTable.getModel();
         int stt = 1;
        tableModel.setRowCount(0);

        var productList = formIn.getProductIds();
        productList.sort((ArrayList<String> a, ArrayList<String> b) -> {
            Integer remaina = Integer.valueOf(a.get(3));
            Integer remainb = Integer.valueOf(b.get(3));
            if (remaina < remainb) {
                return 1;
            }
            if (remaina > remainb) {
                return -1;
            }
            return 0;
        });

        for (var idP : formIn.getProductIds()) {
            ArrayList<String> row = new ArrayList<>();
            row.add(stt + "");
            row.addAll(idP);
            tableModel.addRow(row.toArray());
            stt++;
        }

    }

}

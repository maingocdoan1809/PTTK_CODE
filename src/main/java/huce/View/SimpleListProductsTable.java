/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SimpleListProductsTable extends JTable {

    private DefaultTableModel tbDefaultTableModel;

    public SimpleListProductsTable(Form form, String ...title) {
        String[] titleTable = new String[]{
                    "STT", "ID", "Tên sản phẩm", "Số lượng trong kho", "Đơn vị"
                };
        if ( title.length > 0 ) {
            titleTable = title;
        }
        this.tbDefaultTableModel = new javax.swing.table.DefaultTableModel(
                null,
                titleTable
        ) {
            boolean[] canEdit = {false, false, false, false, false, false};
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[row];
            }
            
        };
        this.setModel(this.tbDefaultTableModel);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    InpProductData newFrame = new InpProductData(form);
                    int rowSelected = getSelectedRow();
                    String id = (String) tbDefaultTableModel.getValueAt(rowSelected, 1);
                    String name = (String) tbDefaultTableModel.getValueAt(rowSelected, 2);
                    newFrame.jTextID.setText(id);
                    newFrame.jTextName.setText(name);
                    newFrame.pack();
                    newFrame.setLocationRelativeTo(null);
                    newFrame.setVisible(true);
                }
            }

        });

    }
 
    public DefaultTableModel getDefaultTableModel() {
        return this.tbDefaultTableModel;
    }
}

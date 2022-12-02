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

    public SimpleListProductsTable(Form form) {
        this.tbDefaultTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    new Object[]{"1", "1345", "Ban Phim", "239", "Cái"},
                new Object[]{"2", "4535", "Chuot khong day", "34", "Cái"},
                new Object[]{"3", "6745", "Snack cay cay" ,"55", "Gói"},
                new Object[]{"4", "3445", "Pepsi", "40", "Chai/1.5l"}},
                new String[]{
                    "STT", "ID", "Tên sản phẩm", "Số lượng yêu cầu còn lại", "Đơn vị"
                }
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

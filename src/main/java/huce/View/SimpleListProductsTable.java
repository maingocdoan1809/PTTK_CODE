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
public class SimpleListProductsTable extends JTable{
    private DefaultTableModel tbDefaultTableModel;
    public SimpleListProductsTable() {
        this.tbDefaultTableModel = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                new Object[] {"1", "abc", "350045", "239", "Cái"}},
                new String[] {
                    "STT" , "ID", "Tên sản phẩm", "Giá tiền","Số lượng còn", "Đơn vị"
                }
               
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
       this.setModel(this.tbDefaultTableModel);
        InputProductData inputProductData = new InputProductData();
        this.addMouseListener( new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if ( e.getClickCount() == 2 ) {
                   JFrame newFrame = new JFrame();
                   int rowSelected = getSelectedRow();
                   
                   String id = (String) tbDefaultTableModel.getValueAt(rowSelected, 1);                   
                   String name =(String) tbDefaultTableModel.getValueAt(rowSelected, 2);
                   inputProductData.jTextID.setText(id);
                   inputProductData.jTextName.setText(name);
                   newFrame.add(inputProductData);
                   newFrame.pack();
                   newFrame.setLocationRelativeTo(null);
                   newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                   newFrame.setVisible(true);
               }
           }
           
       } );

    }
    public DefaultTableModel getDefaultTableModel() {
           return this.tbDefaultTableModel;
    }
}

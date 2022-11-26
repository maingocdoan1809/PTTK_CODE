/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.ApplyPanel;
import huce.Model.WareHouse;
import huce.View.Form;
import huce.View.FormIn;
import huce.View.FormOut;
import huce.View.FormRequest;
import huce.View.InputProductData;
import huce.View.ListProducts;
import huce.View.ListRequestsPanel;
import huce.View.Login;
import huce.View.LookUpPanel;
import huce.View.Main;
import huce.View.ProductLotPanel;
import huce.View.SimpleListProductsTable;
import huce.View.WarehousePanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class WarehouseController extends Controller{

    public WarehouseController(WareHouse wareHouse) {
        super(wareHouse);
    }

    @Override
    public void controll(Main mainApp, WarehousePanel warehousePanel, Connection database, Login login) {
        LookUpPanel lookUpPanel = new LookUpPanel(database);
        SimpleListProductsTable splTable = new SimpleListProductsTable();
        warehousePanel.addImportBtnListener( (e) -> {
            Form form = new FormIn();
            form.setListProductTable(splTable);
            form.setLookUpPanel(lookUpPanel);
            form.handleEvent(database);
            ApplyPanel.apply(warehousePanel.jMainPanel, form);
        } );
        warehousePanel.addExportBtnListener( (e) -> {
            Form form =  new FormOut();
            form.setListProductTable(splTable);
            form.setLookUpPanel(lookUpPanel);
            form.handleEvent(database);
            ApplyPanel.apply(warehousePanel.jMainPanel, form);
        } );

        warehousePanel.addViewProductsBtnListener((e) -> {
            ListProducts listProducts = new ListProducts();
            listProducts.setLookUpPanel(lookUpPanel);
            ApplyPanel.apply(warehousePanel.jMainPanel, listProducts);
        });
        warehousePanel.addViewProductLotBtnListener((e) -> {
            ProductLotPanel panel = new ProductLotPanel();
            ApplyPanel.apply(warehousePanel.jMainPanel, panel);
        });
        warehousePanel.addRequestBtnListener((e) -> {
            ListRequestsPanel panel = new ListRequestsPanel();
            ApplyPanel.apply(warehousePanel.jMainPanel, panel);
        });
    }
    
}

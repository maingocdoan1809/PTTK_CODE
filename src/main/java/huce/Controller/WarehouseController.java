/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Controller;

import huce.Model.ApplyPanel;
import huce.Model.WareHouse;
import huce.View.FormIn;
import huce.View.FormOut;
import huce.View.FormRequest;
import huce.View.ListProducts;
import huce.View.ListRequestsPanel;
import huce.View.Login;
import huce.View.LookUpPanel;
import huce.View.Main;
import huce.View.ProductLotPanel;
import huce.View.WarehousePanel;
import java.sql.Connection;

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
        warehousePanel.addImportBtnListener( (e) -> {
            FormIn form = new FormIn();
            form.setLookUpPanel(lookUpPanel);
            form.handleEvent(database);
            form.setListProductTable(warehousePanel.getListProduct());
            ApplyPanel.apply(warehousePanel.jMainPanel, form);
        } );
        warehousePanel.addExportBtnListener( (e) -> {
            FormOut form = new FormOut();
            form.setLookUpPanel(lookUpPanel);

            form.setListProductTable(warehousePanel.getListProduct());
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

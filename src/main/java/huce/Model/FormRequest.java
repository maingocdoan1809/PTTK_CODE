/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huce.Model;

/**
 *
 * @author MAI NGOC DOAN
 */
public class FormRequest extends Form {

    private String createStore;
    private String reason;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getCreateStore() {
        return createStore;
    }

    public String getReason() {
        return reason;
    }

    public void setCreateStore(String createStore) {
        this.createStore = createStore;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

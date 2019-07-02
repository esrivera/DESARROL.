/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Galito
 */
public class Order {

    private int idOrder;
    private String nameOrder;
    private String currentDate;
    private String deliveryDate;
    private int idMoto;
    private int quantity;

    public Order() {
    }

    public Order(int idOrder, String NameOder, String fechaActual, String fechaEntrega, int idMoto, int cantidad) {
        this.idOrder = idOrder;
        this.nameOrder = NameOder;
        this.currentDate = fechaActual;
        this.deliveryDate = fechaEntrega;
        this.idMoto = idMoto;
        this.quantity = cantidad;
    }

    
    

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOder() {
        return nameOrder;
    }

    public void setNameOder(String NameOder) {
        this.nameOrder = NameOder;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

}

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
    private String NameOder;
    private String fechaActual;
    private String fechaEntrega;
    private int idMoto;
    private int cantidad;

    public Order() {
    }

    public Order(int idOrder, String NameOder, String fechaActual, String fechaEntrega, int idMoto, int cantidad) {
        this.idOrder = idOrder;
        this.NameOder = NameOder;
        this.fechaActual = fechaActual;
        this.fechaEntrega = fechaEntrega;
        this.idMoto = idMoto;
        this.cantidad = cantidad;
    }

    
    

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOder() {
        return NameOder;
    }

    public void setNameOder(String NameOder) {
        this.NameOder = NameOder;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

}

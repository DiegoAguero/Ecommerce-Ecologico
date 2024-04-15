/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */
public class Detail_Order {
    private int idOrder;
    private int idProduct;
    private int quantity;
    public Detail_Order(int idOrder, int idProduct, int quantity){
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Detail_Order{" + "idOrder=" + idOrder + ", idProduct=" + idProduct + ", quantity=" + quantity + '}';
    }
    
}

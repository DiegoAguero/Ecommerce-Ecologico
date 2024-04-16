/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */
public class PurchaseDetails {
    private int quantity;
    private String nameProduct;
    private float priceProduct;
    public PurchaseDetails(int quantity, String nameProduct, float priceProduct){
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }
    
}

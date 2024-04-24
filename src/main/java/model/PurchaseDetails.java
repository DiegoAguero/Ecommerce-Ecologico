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
    private int idOrder;
    private int quantity;
    private String nameProduct;
    private float priceProduct;
    private String image_url;
    private float totalPrice;
    public PurchaseDetails(int idOrder, int quantity, String nameProduct, float priceProduct, String image_url, float totalPrice){
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.image_url = image_url;
        this.totalPrice = totalPrice;
    }
    public void setIdOrder(int idOrder){
        this.idOrder = idOrder;
    }
    public void setImageUrl(String image_url){
        this.image_url = image_url;
    }
    public void setTotalPrice(float totalPrice){
        this.totalPrice = totalPrice;
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
    public float getTotalPrice(){
        return this.totalPrice;
    }
    public String getImageUrl(){
        return this.image_url;
    }
    public int getIdOrder(){
        return this.idOrder;
    }
    
}

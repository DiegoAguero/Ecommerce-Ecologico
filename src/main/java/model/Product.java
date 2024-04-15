/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int idCategory;
    private String image_url;
    
    public Product(int id, String name, String description, float price, int stock, int idCategory, String image_url){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.idCategory = idCategory;
        this.image_url = image_url;
    }
    public int getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Product{ name=" + name + ", description=" + description + ", price=" + price + ", stock=" + stock + ", idCategory=" + idCategory + ", image_url=" + image_url + '}';
    }
    
}

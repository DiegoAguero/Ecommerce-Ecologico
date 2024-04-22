/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.*;

import com.google.gson.*;

import model.Cart;
/**
 *
 * @author Mati
 */
public class FormData {
    private String street;
    private String postalCode;
    private byte door;
    private byte floor;
    private String stairs;
    private String name;
    private String email;
    private String telephoneNumber;
    private ArrayList<Cart> cartList;
    // private Type cartItemType = new TypeToken<List<Cart>>(){}.getType();

    public FormData(String street, String postalCode, byte door, byte floor, String stairs, String name, String email, String telephoneNumber, ArrayList<Cart> cart){
        this.street = street;
        this.postalCode = postalCode;
        this.door = door;
        this.floor = floor;
        this.stairs = stairs;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.cartList = cart;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public byte getDoor() {
        return door;
    }

    public byte getFloor() {
        return floor;
    }

    public String getStairs() {
        return stairs;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public ArrayList<Cart> getCartList() {
        return cartList;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setDoor(byte door) {
        this.door = door;
    }

    public void setFloor(byte floor) {
        this.floor = floor;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setCartList(ArrayList<Cart> cartList) {
        this.cartList = cartList;
    }
    
}

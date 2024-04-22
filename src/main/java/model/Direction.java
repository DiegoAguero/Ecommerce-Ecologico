/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */
public class Direction {
    private String street;
    private byte door;
    private byte floor;
    private String stairs;
    private String postalCode;
    public Direction(String street, String postalCode){
        this.street = street;
        this.postalCode = postalCode;
    }
    public Direction(String street, String postalCode, byte door, byte floor){
        this(street, postalCode);
        this.door = door;
        this.floor = floor;
    }
    public Direction(String street, String postalCode, byte door, byte floor, String stairs){
        this(street, postalCode, door, floor);
        this.stairs = stairs;      
    }

    public void setStreet(String street) {
        this.street = street;
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
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return this.postalCode;
    }
    public String getStreet() {
        return street;
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

    @Override
    public String toString() {
        return "Direction{" + "street=" + street + ", door=" + door + ", floor=" + floor + ", stairs=" + stairs + '}';
    }
    
}

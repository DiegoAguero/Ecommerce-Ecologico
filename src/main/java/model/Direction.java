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
    
    public Direction(String street){
        this.street = street;
    }
    public Direction(String street, byte door, byte floor){
        this(street);
        this.door = door;
        this.floor = floor;
    }
    public Direction(String street, byte door, byte floor, String stairs){
        this(street, door, floor);
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

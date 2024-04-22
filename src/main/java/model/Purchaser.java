/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mati
 */
public class Purchaser {
    private String name;
    private int idDirection;
    private String telephone_number;
    private String email;
    public Purchaser(String name, int idDirection, String telephone_number, String email){
        this.name = name;
        this.idDirection = idDirection;
        this.telephone_number = telephone_number;
        this.email = email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setIdDirection(int idDirection) {
        this.idDirection = idDirection;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getEmail(){
        return this.email;
    }

    public String getName() {
        return name;
    }

    public int getIdDirection() {
        return idDirection;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    @Override
    public String toString() {
        return "Purchaser{" + "name=" + name + ", idDirection=" + idDirection + ", telephone_number=" + telephone_number + '}';
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Mati
 */
public class Order {
    private LocalDateTime date;
    private int idPurchaser;

    public Order(int idPurchaser){
        this.date = LocalDateTime.now();
        this.idPurchaser = idPurchaser;
    }
    public LocalDateTime getDate(){
        return this.date;
    }
    public void setDate(){
        this.date = LocalDateTime.now();
    }
    public int getIdPurchaser(){
        return this.idPurchaser;
    }
    public void setIdPurchaser(int idPurchaser){
        this.idPurchaser = idPurchaser;
    }
}

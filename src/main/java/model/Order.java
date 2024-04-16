/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
/**
 *
 * @author Mati
 */
public class Order {
    private Date date;
    private int idPurchaser;

    public Order(int idPurchaser){
        this.date = new Date(System.currentTimeMillis());
        this.idPurchaser = idPurchaser;
    }
    public Date getDate(){
        return this.date;
    }
    public void setDate(){
        this.date = new Date(System.currentTimeMillis());
    }
    public int getIdPurchaser(){
        return this.idPurchaser;
    }
    public void setIdPurchaser(int idPurchaser){
        this.idPurchaser = idPurchaser;
    }

    @Override
    public String toString() {
        return "Order{" + "date=" + date + ", idPurchaser=" + idPurchaser + '}';
    }
    
}

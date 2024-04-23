/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;

/**
 *
 * @author Mati
 */
import model.Purchaser;
public class PurchaserQuery {
    public int insertPurchaser(Purchaser purchaser, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO compradores (nombre, idDireccion, telefono, email) VALUES (?, ?, ?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, purchaser.getName());
        st.setInt(2, purchaser.getIdDirection());
        st.setString(3, purchaser.getTelephone_number());
        st.setString(4, purchaser.getEmail());
        int rowsInserted = st.executeUpdate();
        ResultSet id = st.getGeneratedKeys();
        int getId = 0;
        if(id.next()){
            getId = id.getInt(1);
        }
        if(rowsInserted == 0){
            throw new Error("Error inserting an Purchaser...");
        }
        id.close();
        return getId;
    }
}

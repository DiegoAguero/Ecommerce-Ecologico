/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 * @author Mati
 */
import java.sql.*;
import model.Order;
public class OrderQuery {
    public int insertQuery(Order order, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO pedidos (fecha, idComprador) VALUES (?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);
        st.setDate(1, order.getDate());
        st.setInt(2, order.getIdPurchaser());
        int rowsInserted = st.executeUpdate();
        ResultSet id = st.getGeneratedKeys();
        int getId = 0;
        if(id.next()){
            getId = id.getInt(1);
        }
        if(rowsInserted == 0){
            throw new Error("Error inserting an Category...");
        }
        id.close();
        return getId;
    }
}

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package db;

/**
 * @author Mati
 */
import java.sql.*;
import model.Direction;
public class DirectionQuery {
    public DirectionQuery(){}
    public int insertDirection(Direction direction, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO direcciones (calle, puerta, piso, escalera, codigoPostal) VALUES  (?, ?, ?, ?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, direction.getStreet());
        st.setInt(2, direction.getDoor());
        st.setInt(3, direction.getFloor());
        st.setString(4, direction.getStairs());
        st.setString(5, direction.getPostalCode());
        int rowsInserted = st.executeUpdate();
        ResultSet id = st.getGeneratedKeys();
        int getId = 0;
        if(id.next()){
            getId = id.getInt(1);
        }
        if(rowsInserted == 0){
            throw new Error("Error inserting the Direction...");
        }
        return getId;
    }

}

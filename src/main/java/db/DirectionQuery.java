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
        String SQLQuery = "INSERT INTO direcciones (calle, puerta, piso, escalera) VALUES  (?, ?, ?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, direction.getStreet());
        st.setInt(1, direction.getDoor());
        st.setInt(2, direction.getFloor());
        st.setString(3, direction.getStairs());
        int rowsInserted = st.executeUpdate();
        if(rowsInserted == 0){
            throw new Error("Error updating the Category...");
        }
        return rowsInserted;
    }

}

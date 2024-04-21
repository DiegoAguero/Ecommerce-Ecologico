/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 * @author Mati
 */
import model.Detail_Order;
import java.sql.*;
import java.util.ArrayList;
import model.PurchaseDetails;
public class Detail_OrderQuery {
    public Detail_OrderQuery(){}
    public int insertDetail_Order(Detail_Order detail_order, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO detalles_pedidos (idPedido, idProducto, cantidad) VALUES (?, ?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setInt(1, detail_order.getIdOrder());
        st.setInt(2, detail_order.getIdProduct());
        st.setInt(3, detail_order.getQuantity());
        int rowsInserted = st.executeUpdate();
        if(rowsInserted == 0){
            throw new Error("Error inserting an Category...");
        }
        return rowsInserted;
    }
    public ArrayList<PurchaseDetails> showPurchaseDetails(Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT dp.cantidad, p.nombre, p.precio FROM detalles_pedidos dp JOIN productos p ON dp.idProducto = p.id";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<PurchaseDetails> details = new ArrayList<>();
        if(rs.next()){
            int quantity = rs.getInt("cantidad");
            String nameOfProduct = rs.getString("nombre");
            float priceOfProduct = rs.getFloat("precio");
            details.add(new PurchaseDetails(quantity, nameOfProduct, priceOfProduct));
        }
        return details;
    }
}

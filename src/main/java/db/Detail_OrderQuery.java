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
            throw new Error("Error inserting the Detail_Order...");
        }
        return rowsInserted;
    }
    public ArrayList<PurchaseDetails> showPurchaseDetails(int idOrder, Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT ped.id, dp.cantidad, prod.nombre, prod.imagen_url, ped.precioTotal FROM pedidos ped JOIN detalles_pedidos dp ON ped.id = dp.idPedido JOIN productos prod ON dp.idProducto = prod.id WHERE ped.id = " + idOrder;
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<PurchaseDetails> details = new ArrayList<>();
        if(rs.next()){
            int orderId = rs.getInt("id");
            int quantity = rs.getInt("cantidad");
            String nameOfProduct = rs.getString("nombre");
            float priceOfProduct = rs.getFloat("precio");
            String image_url = rs.getString("imagen_url");
            float totalPrice = rs.getFloat("precioTotal");
            details.add(new PurchaseDetails(orderId, quantity, nameOfProduct, priceOfProduct, image_url, totalPrice));
        }
        return details;
    }
}

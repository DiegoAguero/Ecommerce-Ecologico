/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mati
 */
import model.Product;
public class ProductQuery {
    public ProductQuery(){}
    public int insertProduct(Product product, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO productos (nombre, descripcion, precio, stock, idCategoria, imagen_url) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, product.getName());
        st.setString(2, product.getDescription());
        st.setFloat(3, product.getPrice());
        st.setInt(4, product.getStock());
        st.setInt(5, product.getIdCategory());
        st.setString(6, product.getImage_url());
        int rowsInserted = st.executeUpdate();
        if(rowsInserted == 0){
            throw new Error("Error updating the Category...");
        }
        return rowsInserted;
    }
    public ArrayList orderByCategory(int idCat, Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM productos WHERE idCategoria = " + idCat;
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<Product> productList = new ArrayList<Product>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("nombre");
            String description = rs.getString("descripcion");
            float price = rs.getFloat("precio");
            int stock = rs.getInt("stock");
            int idCategory = rs.getInt("idCategoria");
            String image_url = rs.getString("imagen_url");
            Product product = new Product(id, name, description, price, stock, idCategory, image_url);
            productList.add(product);
        }
        return productList;
    }
    public ArrayList<Product> getAllProducts(Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM productos";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<Product> productList = new ArrayList<Product>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("nombre");
            String description = rs.getString("descripcion");
            float price = rs.getFloat("precio");
            int stock = rs.getInt("stock");
            int idCategory = rs.getInt("idCategoria");
            String image_url = rs.getString("imagen_url");
            Product product = new Product(id, name, description, price, stock, idCategory, image_url);
            productList.add(product);
        }
        return productList;
    }
    public Product getProductById(int id, Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM productos WHERE id = " + id;
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        Product product;
        while(rs.next()){
            int prodId = rs.getInt("id");
            String name = rs.getString("nombre");
            String description = rs.getString("descripcion");
            float price = rs.getFloat("precio");
            int stock = rs.getInt("stock");
            int idCategory = rs.getInt("idCategoria");
            String image_url = rs.getString("imagen_url");
            product = new Product(prodId, name, description, price, stock, idCategory, image_url);
        }

        return product;
    }

}

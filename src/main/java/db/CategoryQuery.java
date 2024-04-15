/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import model.Category;
import java.util.ArrayList;
/**
 * @author Mati
 */
public class CategoryQuery {
    public CategoryQuery(){}
    public int insertCategory(Category category, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO categorias (nombre) VALUES (?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, category.getName());
        int rowsInserted = st.executeUpdate();
        if(rowsInserted == 0){
            throw new Error("Error inserting an Category...");
        }
        return rowsInserted;
    }
    public int updateCategory(String oldCategory, Category category, Connection stablishConnection) throws SQLException{
        String SQLQuery = "UPDATE categorias SET nombre = ? WHERE nombre = ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, category.getName());
        st.setString(2, oldCategory);
        int rowsUpdated = st.executeUpdate();
        if(rowsUpdated == 0){
            throw new Error("Error updating the Category...");
        }
        return rowsUpdated;
    }
    public ArrayList getCategorys(Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM categorias";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        ArrayList<String> categoryList = new ArrayList<>();
        while(rs.next()){
            String nameOfCategory = rs.getString("nombre");
            categoryList.add(nameOfCategory);
        }
        return categoryList;
    }
    public int deleteCategory(Category category, Connection stablishConnection) throws SQLException{
        String SQLQuery = "DELETE FROM category WHERE nombre LIKE ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, category.getName());
        int categoryDeleted = st.executeUpdate();
        if(categoryDeleted == 0){
            throw new Error("Error deleting the category...");
        }
        return categoryDeleted;
    }
}

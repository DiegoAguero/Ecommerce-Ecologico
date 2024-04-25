/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.soap.Detail;
import java.util.*;
import db.Detail_OrderQuery;
import model.Detail_Order;
import db.Connect;
import db.OrderQuery;
import model.Order;
import db.PurchaserQuery;
import model.Purchaser;
import model.Direction;
import db.DirectionQuery;
import java.sql.*;
import com.google.gson.*;
import db.ProductQuery;
import model.Product;
/**
 *
 * @author Mati
 */
@WebServlet(name = "apiCheckout", urlPatterns = {"/apiCheckout"})
public class apiCheckout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("application/json");
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            requestBody.append(line);
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(requestBody.toString(), JsonObject.class);
        JsonArray cartArray = jsonObject.getAsJsonArray("cart");
        DirectionQuery directionQuery = new DirectionQuery();
        PurchaserQuery purchaserQuery = new PurchaserQuery();
        OrderQuery orderQuery = new OrderQuery();
        Detail_OrderQuery detail_OrderQuery = new Detail_OrderQuery();
        ProductQuery productQuery = new ProductQuery();
        ArrayList<Product> productWithoutStock = new ArrayList<Product>();
        try {
            boolean isStockEnough = true;
            Connection connect = Connect.getConnection();
            //Check stock before buying
            for (int i = 0; i < cartArray.size(); i++) {
                JsonObject item = cartArray.get(i).getAsJsonObject();
                int idProduct = item.get("id").getAsInt();
                int productQuantity = item.get("quantity").getAsInt();
                Product productToUpdate = productQuery.getProductById(idProduct, connect);
                if(productToUpdate.getStock() < productQuantity){
                    Product prod = productQuery.getProductById(idProduct, connect);
                    // Product product = new Product(prod.getId(), prod.getName(), prod.getDescription(), prod.getPrice(), prod.getStock(), prod.getIdCategory(), prod.getImage_url());
                    productWithoutStock.add(prod);
                    isStockEnough = false;
                }
            }
            if(isStockEnough == true){
                //Create direction and get idDirection
                String street = jsonObject.get("street").getAsString();
                String postalCode = jsonObject.get("postalCode").getAsString();
                byte door = jsonObject.get("door").getAsByte();
                byte floor = jsonObject.get("floor").getAsByte();
                String stairs = jsonObject.get("stairs").getAsString();
                int idDirection = directionQuery.insertDirection(new Direction(street, postalCode, door, floor, stairs), connect);
                //Create purchaser and get idPurchaser
                String name = jsonObject.get("name").getAsString();
                String email = jsonObject.get("email").getAsString();
                String telephoneNumber = jsonObject.get("telephone").getAsString();
                int idPurchaser = purchaserQuery.insertPurchaser(new Purchaser(name, idDirection, telephoneNumber, email), connect);
                float totalPrice = jsonObject.get("totalPrice").getAsFloat();
                int idOrder = orderQuery.insertQuery(new Order(idPurchaser, totalPrice), connect);
                //Create and set the idOrder, idProduct and quantity to Detail_Order
                for (int i = 0; i < cartArray.size(); i++) {
                    JsonObject item = cartArray.get(i).getAsJsonObject();
                    int idProduct = item.get("id").getAsInt();
                    int productQuantity = item.get("quantity").getAsInt();
                    detail_OrderQuery.insertDetail_Order(new Detail_Order(idOrder, idProduct, productQuantity), connect);
                    Product productToUpdate = productQuery.getProductById(idProduct, connect);
                    int newStock = productToUpdate.getStock() - productQuantity; 
                    productToUpdate.setStock(newStock);
                    productQuery.updateProduct(productToUpdate, connect);
                }
                JsonObject jsonResponse = new JsonObject();
                jsonResponse.addProperty("status", "success");
                JsonObject showSuccessMessage = new JsonObject();
                showSuccessMessage.addProperty("message", "¡La compra ha sido completada con éxito!");
                jsonResponse.add("message", showSuccessMessage);
                response.getWriter().write(jsonResponse.toString());
            }else{
                JsonObject jsonResponse = new JsonObject();
                jsonResponse.addProperty("status", "error");
                JsonArray errorProducts = new JsonArray();
                for(Product product : productWithoutStock){
                    JsonObject errorProduct = new JsonObject();
                    errorProduct.addProperty("name", product.getName());
                    errorProduct.addProperty("error", "not enough stock for: " + product.getName());
                    errorProducts.add(errorProduct);    
                }
                jsonResponse.add("products", errorProducts);
                System.out.println(jsonResponse);
                response.getWriter().write(jsonResponse.toString()); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
import db.Detail_OrderQuery;
import model.Detail_Order;
import db.Connect;
import db.OrderQuery;
import model.Order;
import db.PurchaserQuery;
import model.Purchaser;
import model.Direction;
import model.FormData;
import db.DirectionQuery;
import java.sql.*;
import com.google.gson.*;
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
        response.setContentType("text/html;charset=UTF-8");

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
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            requestBody.append(line);
        }
        Gson gson = new Gson();
        FormData data = gson.fromJson(requestBody.toString(), FormData.class);
        DirectionQuery directionQuery = new DirectionQuery();
        PurchaserQuery purchaserQuery = new PurchaserQuery();
        OrderQuery orderQuery = new OrderQuery();
        System.out.println(data);
        // try {
            // Connection connect = Connect.getConnection();
            // //Create direction and get idDirection
            // String street = request.getParameter("street");
            // String postalCode = request.getParameter("postalCode");
            // byte door = Byte.valueOf(request.getParameter("door"));
            // byte floor = Byte.valueOf(request.getParameter("floor"));
            // String stairs = request.getParameter("stairs");
            // int idDirection = directionQuery.insertDirection(new Direction(street, postalCode, door, floor, stairs), connect);
            // //Create purchaser and get idPurchaser
            // String name = request.getParameter("name");
            // String email = request.getParameter("email");
            // String telephoneNumber = request.getParameter("telephone");
            // int idPurchaser = purchaserQuery.insertPurchaser(new Purchaser(name, idDirection, telephoneNumber, email), connect);
            // int idOrder = orderQuery.insertQuery(new Order(idPurchaser), connect);
            
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
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

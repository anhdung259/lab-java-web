/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.cart;

import dung.dtos.FoodDto;
import dung.model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Haima
 */
public class AddToCartController extends HttpServlet {

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
         request.setCharacterEncoding("UTF-8");
        try{
     HttpSession session = request.getSession();
            Cart shoppingCart = (Cart) session.getAttribute("CART");
            if (shoppingCart == null) {
                shoppingCart = new Cart();
            }
            String id = request.getParameter("txtFoodID");
            int idItem= Integer.parseInt(id);
            System.out.println(idItem);
            String foodName = request.getParameter("txtFoodName");
            String image = request.getParameter("txtImage");
            String price = request.getParameter("txtPrice");
            float PriceItem = Float.parseFloat(price);
           FoodDto dto = new FoodDto(foodName, image, PriceItem, 1, idItem);
            shoppingCart.AddtoCart(dto);
            session.setAttribute("CART", shoppingCart);
            float total =shoppingCart.getTotal();
           session.setAttribute("Total",total);
        } catch (Exception e) {
            log("Error at addtoCart:" + e.getMessage());
        }
        request.getRequestDispatcher("LoadController").forward(request, response);
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

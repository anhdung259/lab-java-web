/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.FoodDto;
import dung.dtos.OrderDto;
import dung.dtos.TransactionDto;
import dung.model.Cart;
import dung.model.FoodDao;
import dung.model.ShoppingDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Haima
 */
public class BuyController extends HttpServlet {

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
        try {
            boolean checkQuantity = true;
            boolean checkBuy = false;
            HttpSession session = request.getSession();
            String Username = (String) session.getAttribute("USER");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateBuy = sdf.format(date);
            ShoppingDao dao = new ShoppingDao();
            FoodDao fooddao = new FoodDao();
            Cart shoppingCart = (Cart) session.getAttribute("CART");
            float total = shoppingCart.getTotal();
            TransactionDto dtoTranc = new TransactionDto(Username, dateBuy, total);

            for (FoodDto dto : shoppingCart.getItems().values()) {
                if (dto.getQuantity() > dao.checkQuantity(dto.getFoodID())) {
                    checkQuantity = false;
                    request.setAttribute("FAIL", "Sorry," + dto.getFoodName() + " is out of stock");
                }
            }
            if (checkQuantity == true) {
                boolean check = dao.BuyCart(dtoTranc);
                if (check) {
                    List<TransactionDto> listTrans = dao.loadTrans();
                    int transID = listTrans.get(listTrans.size() - 1).getTransactionID();
                    for (FoodDto dto : shoppingCart.getItems().values()) {
                        int FoodIDItem = dto.getFoodID();
                        String FoodNameItem = dto.getFoodName();
                        int QuantityItem = dto.getQuantity();
                        OrderDto orderdto = new OrderDto(FoodIDItem, QuantityItem, transID, FoodNameItem, dateBuy, Username);
                        checkBuy = dao.AddtoOrder(orderdto);
                        int quantityUpdate = dao.checkQuantity(dto.getFoodID())-dto.getQuantity(); /// giá trong kho
                        fooddao.UpdateQuantity(quantityUpdate, dto.getFoodID());
                    }
                    if (checkBuy) {
                        shoppingCart.clear();
                        total = shoppingCart.getTotal();
                        session.setAttribute("Total", total);
                        request.setAttribute("OKE", "Mua hàng thành công");

                    } else {
                        request.setAttribute("NOTDONE", "có gì đó sai");
                    }

                } else {
                    request.setAttribute("FAIL", "có gì đó sai");
                }
            }

        } catch (Exception e) {
            log("buy err" + e.getMessage());
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
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

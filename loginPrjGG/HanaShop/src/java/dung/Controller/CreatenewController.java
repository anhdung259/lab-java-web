/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.FoodDto;
import dung.model.CategoryDao;
import dung.model.FoodDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Haima
 */
public class CreatenewController extends HttpServlet {

    private final String SUCCESS = "createFood.jsp";

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
        String url = SUCCESS;
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateCreate = sdf.format(date);
            String Foodname = request.getParameter("txtName");
            String Description = request.getParameter("txtDescription");
            String txtprice = request.getParameter("txtPrice");
            Float price = Float.parseFloat(txtprice);
            String txtquantity = request.getParameter("txtQuantity");
            int quantity = Integer.parseInt(txtquantity);
            String Image = request.getParameter("txtImage");
            String category = request.getParameter("txtCategory");
            CategoryDao cateDao = new CategoryDao();
            int cateId = cateDao.findCateID(category);
            FoodDto dto = new FoodDto(Foodname, Image, Description, dateCreate, price, quantity, cateId);
            FoodDao dao = new FoodDao();
            boolean check = dao.createFood(dto);
            if (check) {
                request.setAttribute("OK", "Create food successfull");
            } else {
                request.setAttribute("FAIL", "An error occurred please try again");
            }
        } catch (Exception e) {
            log("error at creatController:" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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

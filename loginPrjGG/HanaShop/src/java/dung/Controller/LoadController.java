/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.Controller;

import dung.dtos.CategoryDto;
import dung.dtos.FoodDto;
import dung.model.CategoryDao;
import dung.model.FoodDao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class LoadController extends HttpServlet {
    
    private static final String ADMIN = "LoadAdminController";
    private static final String USER =  "user.jsp";
    private static final String INDEX = "index.jsp";

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

        String url = INDEX;
        int page = 1;
        int rowsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        try {
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("ROLE");
            FoodDao dao = new FoodDao();
            CategoryDao cateDao = new CategoryDao();
            List<CategoryDto> listCate= cateDao.loadCategory();           
            List<FoodDto> list = dao.loadFood((page - 1) * rowsPerPage, rowsPerPage);
            int noOfRecords = dao.countFoodActive();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / rowsPerPage);
            request.setAttribute("LIST", list);
            request.setAttribute("LISTCATE", listCate);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            if (role.equals("user")) {
                url = USER;
            } else if (role.equals("admin")) {
                url = ADMIN;
            } else {
                url = INDEX;
            }
            System.out.println(role);
        } catch (Exception e) {
            log("Error at LoadController" + e.getMessage());
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

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
        DAO d = new DAO();
        String addPro = request.getParameter("addSubmit"),
                delete = request.getParameter("delete_submit"),
                update = request.getParameter("update_submit");
        if (addPro != null) {
            String proName = request.getParameter("product_name"),
                    proId = request.getParameter("product_category_id"),
                    proCollection = request.getParameter("product_collection_id"),
                    img = request.getParameter("image_link");
            if (d.Product_Insert(proName, Integer.parseInt(proId), Integer.parseInt(proCollection), img)) {
                request.setAttribute("mess", "Add Success");
            } else {
                request.setAttribute("mess", "Add failed");
            };
        } else if (delete != null) {
            String id = request.getParameter("product_id_delete");
            if (d.Product_Delete(Integer.parseInt(id))) {
                request.setAttribute("mess1", "Delete Success");
            } else {
                request.setAttribute("mess1", "Delete fail");
            }
        }
        if (update != null) {
            String id = request.getParameter("product_id_update"),
                    name = request.getParameter("product_name_update"),
                    pId = request.getParameter("product_category_id_update"),
                    cId = request.getParameter("product_collection_id_update"),
                    img = request.getParameter("image_link_update");
            if (d.Product_Update(Integer.parseInt(id), name,Integer.parseInt(pId) , Integer.parseInt(cId), img)) {
                 request.setAttribute("mess2", "Update Success");
            } else {
                 request.setAttribute("mess2", "Update failed");
            }
        }
        request.getRequestDispatcher("admin.jsp").forward(request, response);

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

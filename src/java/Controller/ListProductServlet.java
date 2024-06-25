/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.Product;
import Model.Product_Category;
import Model.Product_collection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ListProductServlet", urlPatterns = {"/product"})
public class ListProductServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        DAO d = new DAO();
        List<Product_Category> cList = d.getAllCategoryNoParents();
        List<Product> pList = d.getAllProduct();
        request.setAttribute("product", pList);
        request.setAttribute("data", cList);
        request.getRequestDispatcher("category.jsp").forward(request, response);
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
        String sid = request.getParameter("pro");
        int id = Integer.parseInt(sid);
        DAO d = new DAO();
        List<Product_collection> sList = d.getAllCollectionByCategory(id);
        PrintWriter out = response.getWriter();
        for (Product_collection p : sList) {
            out.println(" <li class=\"card-info-collection\" id=\"collection_${status.index}\">\n"
                    + "                            <a href=\"#\" class=\"card-link\">\n"
                    + "                                <img\n"
                    + "                                    src=\"./img/" + p.getImage() + "\"\n"
                    + "                                    alt=\"\"\n"
                    + "                                    class=\"card-image\"\n"
                    + "                                    />\n"
                    + "                                <span class=\"card-name black-text-no-underline\"\n"
                    + "                                      >" + p.getProduct_collection_name() + "</span\n"
                    + "                                >\n"
                    + "                            </a>\n"
                    + "                        </li>");
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

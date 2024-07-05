/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.ProductDetail;
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
@WebServlet(name = "ProductDescribeServlet", urlPatterns = {"/describe"})
public class ProductDescribeServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductDescribeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDescribeServlet at " + request.getContextPath() + "</h1>");
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
        DAO d = new DAO();
        String product_id = request.getParameter("amount");
        ProductDetail p = d.getProductDetailById(Integer.parseInt(product_id));
        PrintWriter out = response.getWriter();
        if (p != null) {
            out.println("<p class=\"product_name\">\n"
                    + "                            " + p.getProduct_name() + "\n"
                    + "                        </p>");
            if (p.getMaterial() != null) {
                out.println(" <p class=\"product_material\">\n"
                        + "                            Material\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_material_type\">" + p.getMaterial() + "</span>\n"
                        + "                        </p>");
            }
            if (p.getGemstone() != null) {
                out.println("<p class=\"product_germstone\">\n"
                        + "                            Gemstone\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_germstone_type\">" + p.getGemstone() + "</span>\n"
                        + "                        </p>");
            }
            if (p.getColour() != null) {
                out.println("<p class=\"product_germstone\">\n"
                        + "                            Color\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_germstone_type\">" + p.getColour() + "</span>\n"
                        + "                        </p>");
            }
            if (p.getSize() != null) {
                out.println("<p class=\"product_germstone\">\n"
                        + "                            Size\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_germstone_type\">" + p.getSize() + "</span>\n"
                        + "                        </p>");
            }
            if (p.getOffactive_family() != null) {
                out.println("<p class=\"product_germstone\">\n"
                        + "                            Olfactive Family\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_germstone_type\">" + p.getOffactive_family() + "</span>\n"
                        + "                        </p>");
            }
            out.println("  <p class=\"product_price\">\n"
                    + "                            <span class=\"product_price_num\">đ" + p.getPrice() + "</span>\n"
                    + "                            <span class=\"product_price_taxes\">Including Taxes</span>\n"
                    + "                        </p>\n"
                    + "                        <a href=\"/RloyalPRJ/productDetail?pId=" + p.getProduct_id() + "\" class=\"product_discover_more\">DISCOVER MORE</a>  ");
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

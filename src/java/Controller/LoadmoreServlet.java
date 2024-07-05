 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.Product;
import Model.ProductDetail;
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
@WebServlet(name = "LoadmoreServlet", urlPatterns = {"/loadmore"})
public class LoadmoreServlet extends HttpServlet {

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
        String amountRaw = request.getParameter("amount");
        int amount = Integer.parseInt(amountRaw);
        List<Product> list = d.getNext3Product(amount);
        PrintWriter out = response.getWriter();

        for (Product p : list) {
            ProductDetail product = d.getProductDetailById(p.getProduct_id());
            if (product == null) {
                out.println(" <div class=\"productItem category_product_1\">\n"
                        + "                    <img\n"
                        + "                        class=\"product_img\"\n"
                        + "                        src=\"./product_img/" + p.getImage() + "\"\n"
                        + "                        alt=\"\"\n"
                        + "                        />\n"
                        + "                    <div class=\"product_describe_overlay\">\n"
                        + "                        <p class=\"product_name\">\n"
                        + "                            " + p.getProduct_name() + "\n"
                        + "                        </p>\n"
                        + "                        <p class=\"product_material\">\n"
                        + "                            Material\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_material_type\">Rose gold</span>\n"
                        + "                        </p>\n"
                        + "                        <p class=\"product_germstone\">\n"
                        + "                            Germstone\n"
                        + "                            <br>\n"
                        + "                            <span class=\"product_germstone_type\">Diamond</span>\n"
                        + "                        </p>\n"
                        + "                        <p class=\"product_price\">\n"
                        + "                            <span class=\"product_price_num\">đ165,000,000</span>\n"
                        + "                            <span class=\"product_price_taxes\">Including Taxes</span>\n"
                        + "                        </p>\n"
                        + "                        <a href=\"/RloyalPRJ/productDetail?pId=${product.product_id}\" class=\"product_discover_more\">DISCOVER MORE</a>                   \n"
                        + "                    </div>\n"
                        + "                </div>");
            } else {
                out.println(" <div class=\"productItem category_product_1\">\n"
                        + "                    <img\n"
                        + "                        class=\"product_img\"\n"
                        + "                        src=\"./product_img/" + p.getImage() + "\"\n"
                        + "                        alt=\"\"\n"
                        + "                        />");
                out.println("                    <div class=\"product_describe_overlay\">\n"
                        + "                        <p class=\"product_name\">\n"
                        + "                            " + p.getProduct_name() + "\n"
                        + "                        </p>");
                if (product.getMaterial() != null) {
                    out.println(" <p class=\"product_material\">\n"
                            + "                            Material\n"
                            + "                            <br>\n"
                            + "                            <span class=\"product_material_type\">" + product.getMaterial() + "</span>\n"
                            + "                        </p>");
                }
                if (product.getGemstone() != null) {
                    out.println("<p class=\"product_germstone\">\n"
                            + "                            Gemstone\n"
                            + "                            <br>\n"
                            + "                            <span class=\"product_germstone_type\">" + product.getGemstone() + "</span>\n"
                            + "                        </p>");
                }
                if (product.getColour() != null) {
                    out.println("<p class=\"product_germstone\">\n"
                            + "                            Color\n"
                            + "                            <br>\n"
                            + "                            <span class=\"product_germstone_type\">" + product.getColour() + "</span>\n"
                            + "                        </p>");
                }
                if (product.getSize() != null) {
                    out.println("<p class=\"product_germstone\">\n"
                            + "                            Size\n"
                            + "                            <br>\n"
                            + "                            <span class=\"product_germstone_type\">" + product.getSize() + "</span>\n"
                            + "                        </p>");
                }
                if (product.getOffactive_family() != null) {
                    out.println("<p class=\"product_germstone\">\n"
                            + "                            Olfactive Family\n"
                            + "                            <br>\n"
                            + "                            <span class=\"product_germstone_type\">" + product.getOffactive_family() + "</span>\n"
                            + "                        </p>");
                }
                out.println("  <p class=\"product_price\">\n"
                        + "                            <span class=\"product_price_num\">đ" + product.getPrice() + "</span>\n"
                        + "                            <span class=\"product_price_taxes\">Including Taxes</span>\n"
                        + "                        </p>\n"
                        + "                        <a href=\"/RloyalPRJ/productDetail?pId=" + p.getProduct_id() + "\" class=\"product_discover_more\">DISCOVER MORE</a>                   \n"
                        + "                    </div>\n"
                        + "                </div>");
            }

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

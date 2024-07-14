/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.Cart;
import Model.CartItem;
import Model.ProductDetail;
import Model.ProductImg;
import Model.Product_Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "RemoveItemSerlvlet", urlPatterns = {"/remove"})
public class RemoveItemSerlvlet extends HttpServlet {

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
            out.println("<title>Servlet RemoveItemSerlvlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveItemSerlvlet at " + request.getContextPath() + "</h1>");
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
        List<ProductDetail> p = d.getAllProductDetails();
        Cookie[] arr = request.getCookies();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        String id = request.getParameter("pId");
        String size = request.getParameter("size");
        String rId = request.getParameter("rId");
        if (txt.isEmpty()) {
            txt = id + ":" + size;
        } else {
            txt = txt + "." + id + ":" + size;
        }
        try {
            DecimalFormat formatter = new DecimalFormat("#,###");
            Cart cart = new Cart(txt, p, d.getAllProduct_img());
            double price = 0;
            System.out.println(rId);
            if (rId != null) {
                cart.removeItem(Integer.parseInt(rId));
            }
            List<CartItem> cList = cart.getItems();
            if (cList != null) {
                for (CartItem a : cList) {
                    price += a.getPrice();
                }
                String totalPrice = formatter.format(price);
                txt = "";
                if (cList.size() > 0) {
                    txt = cList.get(0).getProduct().getProduct_id() + ":" + cList.get(0).getSize();
                    for (int i = 1; i < cList.size(); i++) {
                        txt += "," + cList.get(i).getProduct().getProduct_id() + ":" + cList.get(i).getSize();
                    }
                }

                List<Product_Category> pList = d.getAllCategoryNoParents();
                request.setAttribute("cart", cList);
                request.setAttribute("data", pList);
                request.setAttribute("price", totalPrice);
                Cookie c = new Cookie("cart", txt);
                c.setMaxAge((2 * 24 * 60 * 60));
                response.addCookie(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);

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

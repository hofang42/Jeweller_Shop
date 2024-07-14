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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
        Cookie arr[] = request.getCookies();
        DAO d = new DAO();
        List<ProductDetail> list = d.getAllProductDetails();
        List<ProductImg> img = d.getAllProduct_img();
        String txt = "";
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                }
            }
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        double price = 0;
        try {
            Cart cart = new Cart(txt, list, img);
            List<CartItem> cList = cart.getItems();
            if (cList != null) {
                for (CartItem c : cList) {
                    price += c.getPrice();
                }
                String totalPrice = formatter.format(price);
                request.setAttribute("cart", cList);
                request.setAttribute("price", totalPrice);
            }
            System.out.println("abc");
            System.out.println(cList);
            List<Product_Category> pList = d.getAllCategoryNoParents();
            request.setAttribute("data", pList);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (txt.isEmpty()) {
            txt = id + ":" + size;
        } else {
            txt = txt + "." + id + ":" + size;
        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge((2 * 24 * 60 * 60));
        response.addCookie(c);
        try {
            DecimalFormat formatter = new DecimalFormat("#,###");
            Cart cart = new Cart(txt, p, d.getAllProduct_img());
            double price = 0;
            List<CartItem> cList = cart.getItems();
            if (cList != null) {
                for (CartItem a : cList) {
                    price += a.getPrice();
                }
                String totalPrice = formatter.format(price);
                request.setAttribute("cart", cList);
                List<Product_Category> pList = d.getAllCategoryNoParents();
                request.setAttribute("data", pList);
                request.setAttribute("price", totalPrice);
            }
            System.out.println("abc");
            System.out.println(cList);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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

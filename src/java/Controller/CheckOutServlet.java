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
import Model.Receipt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/checkout"})
public class CheckOutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckOutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String direct = request.getParameter("direct"),
                vnpay = request.getParameter("vnpay"),
                full_name = request.getParameter("full_name"),
                email = request.getParameter("email"),
                address = request.getParameter("address"),
                city = request.getParameter("city"),
                phone = request.getParameter("phone"),
                state = request.getParameter("state"),
                zip_code = request.getParameter("zip_code"),
                user_id = request.getParameter("user_id"),
                totalRaw = request.getParameter("total");
        Cookie arr[] = request.getCookies();
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
        Cart cart = new Cart(txt, list, img);
        List<CartItem> cList = cart.getItems();
        String confirm = request.getParameter("status");
        if (direct != null) {
            String total = totalRaw.replaceAll(",", "");
            if (session.getAttribute("acc") != null) {
                d.Payment_insert(Integer.parseInt(user_id), full_name, email, address, city, phone, state, Integer.parseInt(zip_code), Integer.parseInt(total), "Success");

            } else if (session.getAttribute("accGoogle") != null) {
                d.Payment_insert_google(user_id, full_name, email, address, city, phone, state, Integer.parseInt(zip_code), Integer.parseInt(total), "Success");

            }
            for (CartItem c : cList) {
                d.Order_insert(c.getProduct().getProduct_id(), c.getQuantity(), d.getMaxPaymentId().getId());
            }
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
            List<Product_Category> pList = d.getAllCategoryNoParents();
            request.setAttribute("data", pList);
            Receipt rec = d.getMaxPaymentId();
            request.setAttribute("info", rec);
            request.setAttribute("total", totalRaw);
            request.getRequestDispatcher("receipt.jsp").forward(request, response);
        } else if (vnpay != null || confirm != null) {
            if (confirm == null) {
                System.out.println(totalRaw);
                String total = totalRaw.replaceAll(",", "");
                if (session.getAttribute("acc") != null) {
                    d.Payment_insert(Integer.parseInt(user_id), full_name, email, address, city, phone, state, Integer.parseInt(zip_code), Integer.parseInt(total), "failed");

                } else if (session.getAttribute("accGoogle") != null) {
                    d.Payment_insert_google(user_id, full_name, email, address, city, phone, state, Integer.parseInt(zip_code), Integer.parseInt(total), "failed");

                }
                for (CartItem c : cList) {
                    d.Order_insert(c.getProduct().getProduct_id(), c.getQuantity(), d.getMaxPaymentId().getId());
                }
                request.setAttribute("total", totalRaw);
                request.getRequestDispatcher("vnpay_pay.jsp").forward(request, response);
            } else if (confirm.equals("00")) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
                DecimalFormat formatter = new DecimalFormat("#,###");
                d.Update_status("Success", d.getMaxPaymentId().getId());
                String priceRaw = request.getParameter("price");
                System.out.println(priceRaw);
                String price = formatter.format(Double.parseDouble(priceRaw));
                Receipt rec = d.getMaxPaymentId();
                request.setAttribute("info", rec);
                request.setAttribute("total", price);
                request.getRequestDispatcher("receipt.jsp").forward(request, response);
            }

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

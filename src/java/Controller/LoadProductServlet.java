/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.PaymentInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "LoadProductServlet", urlPatterns = {"/loadProduct"})
public class LoadProductServlet extends HttpServlet {

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
            out.println("<title>Servlet LoadProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadProductServlet at " + request.getContextPath() + "</h1>");
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
        String date = request.getParameter("date");
        DAO d = new DAO();
        List<PaymentInfo> list = null;
        int total = 0;

        list = d.getPaymentDetails(Date.valueOf(date));
        for (PaymentInfo p : list) {
            total += p.getAmount();
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        String pric = formatter.format(total);
        System.out.println(list);
        PrintWriter out = response.getWriter();
        out.println(" <span class=\"material-symbols-sharp\">trending_up</span>\n"
                + "                        <div class=\"middle\">\n"
                + "                            <div class=\"left\">\n"
                + "                                <h3>Total Sales</h3>\n"
                + "                                <h1>$" + pric + "</h1>\n"
                + "                            </div>\n"
                + "                            <div class=\"progress\">\n"
                + "                                <svg>\n"
                + "                                <circle r=\"30\" cy=\"40\" cx=\"40\"></circle>\n"
                + "                                </svg>\n"
                + "                                <div class=\"number\">80%</div>\n"
                + "                            </div>\n"
                + "                            <small>Last 24 hours</small>\n"
                + "                        </div>");
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
        String date = request.getParameter("date");
        DAO d = new DAO();
        List<PaymentInfo> list = null;
        int total = 0;

        list = d.getPaymentDetails(Date.valueOf(date));
        for (PaymentInfo p : list) {
            total += p.getAmount();
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        String pric = formatter.format(total);
        System.out.println(list);
        PrintWriter out = response.getWriter();
        for (PaymentInfo p : list) {
            out.println("<h1>Recent Orders</h1>\n"
                    + "                    <table>\n"
                    + "                        <thead>\n"
                    + "                            <tr>\n"
                    + "                                <th>Product Name</th>\n"
                    + "                                <th>Product ID</th>\n"
                    + "                                <th>Amounts</th>\n"
                    + "                                <th>Status</th>\n"
                    + "                            </tr>\n"
                    + "                        </thead>\n"
                    + "                        <tbody>\n"
                    + "                                <tr>\n"
                    + "                                    <td>" + p.getProduct_name() + "</td>\n"
                    + "                                    <td>" + p.getProduct_id() + "</td>\n"
                    + "                                    <td>" + p.getPrice() + "</td>\n"
                    + "                                    <td>" + p.getStatus() + "</td>\n"
                    + "                                    <td class=\"primary\">Details</td>\n"
                    + "                                </tr>\n"
                    + "                        </tbody>\n"
                    + "                    </table>");
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

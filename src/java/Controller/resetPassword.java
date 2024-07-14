/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import JDBC.DAO;
import Model.TokenForgetPassword;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author tuank
 */
@WebServlet(name = "resetPassword", urlPatterns = {"/resetPassword"})
public class resetPassword extends HttpServlet {
    DAO d = new DAO();
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
            out.println("<title>Servlet resetPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet resetPassword at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String token = request.getParameter("token");
        
        resetService rs = new resetService();
        if(token != null)
        {
            String mess = "";
            TokenForgetPassword tokenForgetPassword = d.getTokenPassword(token);
            if(tokenForgetPassword == null)
            {
                request.setAttribute("mess", "token invalid");
                request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
                return;
            }
            if(tokenForgetPassword.isIsUsed())
            {
                request.setAttribute("mess", "token is used");
                request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
                return;
            }
//            if(!rs.isExpireTime(tokenForgetPassword.getExpiryTime()))
//            {
//                request.setAttribute("mess", "token is expired");
//                request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
//                return;
//            }
            User user = d.getUserById(tokenForgetPassword.getUserID());
            request.setAttribute("email", user.getUser_email());
            session.setAttribute("token", tokenForgetPassword.getToken());
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            
        }
        else{
            request.getRequestDispatcher("requestPassword.jsp").forward(request, response);
        }
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        //validate password...
        if(!password.equals(confirmPassword))
        {
            request.setAttribute("mess", "Password must same");
            request.setAttribute("email", email );
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            return;
        }
       
        //update is used of token
        TokenForgetPassword tokenForgetPassword = new TokenForgetPassword();
        tokenForgetPassword.setToken((String)session.getAttribute("token"));
        tokenForgetPassword.setIsUsed(true);
        d.updatePassword(email, password);
        d.updateStatus(tokenForgetPassword);
        
        //save user in session
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
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

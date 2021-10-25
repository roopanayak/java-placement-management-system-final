/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dhruval
 */
public class Register extends HttpServlet {

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
        String uname=request.getParameter("username");
        String pwd=request.getParameter("password");
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String branch=request.getParameter("branch");
        String user=request.getParameter("userId");
        String pass=request.getParameter("password");
        try(PrintWriter out=response.getWriter())
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","");
               


                   String q="insert into userdb(username,password,firstname,lastname,email,branch,user)"+"values(?,?,?,?,?,?,?)";

                    try{
                        PreparedStatement psmt=conn.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);


                        psmt.setString(1,uname);
                        psmt.setString(2,pwd);
                        psmt.setString(3,fname);
                        psmt.setString(4,lname);
                        psmt.setString(5,email);
                        psmt.setString(6,branch);
                        psmt.setString(7,user);
                        int row=psmt.executeUpdate();
                        out.println("YOU REGISTERED SUCESSFULLY");
                        out.println("NOW LOGIN!!!!");

                        RequestDispatcher rs=request.getRequestDispatcher("index.html");
                        rs.include(request, response);

                    }
                    catch(SQLException e){
                        out.println(e);
                    }                      
            } 
            catch (Exception ex) {
                 Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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

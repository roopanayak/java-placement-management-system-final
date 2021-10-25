/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruval
 */
public class Login extends HttpServlet {

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
             RequestDispatcher rd1=request.getRequestDispatcher("/Home.jsp");
              RequestDispatcher rd=request.getRequestDispatcher("/Home_admin.jsp");
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            //String fnm=request.getParameter("fname");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
          
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","");
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select username,password,user from userdb ");
            
            
                while(rs.next())
                {
                       
                    
                   if((rs.getString("username")).equals(username) && (rs.getString("password")).equals(password))
                    {
                        
                       // out.println(rs.getString("username")+" "+rs.getString("password"));
                        HttpSession session= request.getSession();
                        session.setAttribute("uname", username);
                        session.setAttribute("branch",request.getParameter("branch"));
                        if(rs.getString("user").equals("1")){
                             rd.forward(request, response);
                        }
                        else{
                            rd1.forward(request, response);
                        }
                      // rd1.forward(request, response);
                    }
                }
            }
            catch(Exception e){
                 out.println(e+"   hiqq");
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

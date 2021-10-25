package my;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
public class AddPlacement extends HttpServlet {

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
        String cname=request.getParameter("cname");
        String pkg=request.getParameter("package");
        String no=request.getParameter("no_students");
        String branch=request.getParameter("branch");
        try(PrintWriter out=response.getWriter())
        {
            try{
                  Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","");


                   String q="insert into placement(c_name,package,no_students,branch)"+"values(?,?,?,?)";

                    try{
                        PreparedStatement psmt=conn.prepareStatement(q,Statement.RETURN_GENERATED_KEYS);


                        psmt.setString(1,cname);
                        psmt.setString(2,pkg);
                        psmt.setString(3,no);
                        psmt.setString(4,branch);
                        
                        int row=psmt.executeUpdate();
                        out.println("Data Successfully Updated");
                   

                        RequestDispatcher rs=request.getRequestDispatcher("/Home_admin.jsp");
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
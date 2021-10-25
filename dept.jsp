<%-- 
    Document   : dept
    Created on : 23 Oct, 2021, 8:03:20 PM
    Author     : Roopa
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Level</title>
        <style>
             body {
              background-image: url(imgs/homepg.jpg);
              background-repeat: no-repeat;
              background-attachment: fixed;
              background-size: cover;
            }
            .container { 
              height: 200px;
              position: relative;
              border: 3px solid green;  
            }
            .vertical-center {
              margin: 0;
              position: absolute;
              top: 80%;
              left: 80%;
              -ms-transform: translateY(-50%);
              transform: translateY(-50%);
            }
            .button {
                background-color: darkturquoise;
                border: none;
                color: white;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            .button:hover {
                background-color: dimgrey;
                color: white;
            } 
        </style>
    </head>
    <body>
        <%String br=request.getParameter("dept");%>
        <h1><center><font color="black">Our Past Records Of Placements in <%=br%> Department</font></center></h1>
        <div>
            <div class=container">
                <div class="vertical-center">
                    <button onclick="window.location.href = 'Home.jsp'" style="border:1px solid blue;" class="button">Home</button>
                  
                </div>
            </div>
        </div>
        <table bgcolor=lightblue align="center" width="700" height="30" border="3">
                 <tr>
                     <th><font color="black">Sr.No</th>
                     <th><font color="black">Company Name</th>
                     <th><font color="black">Package(Monthly)</th>
                     <th><font color="black">Total Number Of Students</th>
                     
                 </tr>
        <%
            try{
                int count=0;
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","");
                
                String s = "select * from placement where branch = '"+br+"'";
                
                try{
                        Statement stmt = conn.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery(s);
                        
                        while(rs.next()){
                            count++;
        %>
         
         
             
                <tr>
                    <td><%=count%></td>
                    <td><%=rs.getString("c_name")%></td>
                    <td><%=rs.getString("package")%></td>
                    <td><%=rs.getString("no_students")%></td>
                    
                </tr>
                
            
        <%
            // out.println(rs.getString("c_name")+" "+rs.getString("package")+" "+rs.getString("no_students")+" "+rs.getString("branch"));
                        }
        %>
        </table>
        <%
                       // RequestDispatcher rs=request.getRequestDispatcher("index.html");
                        //rs.include(request, response);
                    }
                    catch(SQLException e){
                        out.println(e);
                    }               
            }
            catch(Exception e){System.err.println("e");}
        %>
    </body>
</html>

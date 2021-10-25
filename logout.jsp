<%-- 
    Document   : logout
    Created on : 23 Oct, 2021, 8:03:55 PM
    Author     : Roopa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    session.invalidate();
     RequestDispatcher rs=request.getRequestDispatcher("Home.html");
     rs.forward(request, response);
%>

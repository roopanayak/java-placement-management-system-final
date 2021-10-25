<%-- 
    Document   : Home
    Created on : 23 Oct, 2021, 8:01:03 PM
    Author     : Roopa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Management System</title>
        <style>
            body {
              background-image: url(imgs/clg.jpg);
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
              top: 30%;
              left: 80%;
              -ms-transform: translateY(-50%);
              transform: translateY(-50%);
            }
            .vertical-center1 {
              margin: 0;
              position: absolute;
              top: 20%;
              left: 70%;
              -ms-transform: translateY(-50%);
              transform: translateY(-50%);
            }
            .vertical-center2 {
              margin: 0;
              position: absolute;
              top: 30%;
              left: 60%;
              -ms-transform: translateY(-50%);
              transform: translateY(-50%);
            }
            .vertical-center3 {
              margin: 0;
              position: absolute;
              top: 90%;
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
    <%
      
        if(!(session.isNew()))
        {
            if(session.getAttribute("uname") != null)
            {
                    String s = (String)session.getAttribute("uname");
            
     %>
    <body>
         <h1><center><font color="black">University Management System</font></center></h1>
          <h1><center><font color="black">WELCOME <%=s%></font></center></h1>
          
         <div>
            <div class=container">
                <div class="vertical-center3">
                    <button onclick="window.location.href = 'Home.html'" style="border:1px solid blue;" class="button">Logout</button>
                  
                </div>
            </div>
        </div>
          <h2 class="vertical-center1">Placement Cell</h2>
         <div>
            <div class=container">
                <div class="vertical-center2">
                    <button onclick="window.location.href = 'university.jsp'" style="border:1px solid blue;" class="button">University Level</button>
                  
                </div>
            </div>
        </div>
         <div>
            <div class=container">
                <div class="vertical-center">
                    <button onclick="window.location.href = 'dept.html'" style="border:1px solid blue;" class="button">Department Level</button>
                  
                </div>
            </div>
        </div>
        
    </body>
     <%
            } }else{
               
                response.sendRedirect("index.html");
                
                ////rd.forward(request,response);
            }
    %>
</html>
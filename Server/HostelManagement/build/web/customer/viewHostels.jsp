
<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hostel</title>
        
        <style>
            
            
            .button_login {
                background-color: #003399; /* Green */
            border: none;
            color: white;
            padding: 12px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            
            }
            
            .main{
                background-color: #eaf1f7
            }
            .hostel,.detail{
                width: 90%;
                height: 200px;
                margin: auto;
                margin-bottom: 5px;
                border-radius: 10px;
                float: center;
                padding: 10px;
                color: #f3e8e80;
               /*  
                
                border: 5px solid black;
               / 
                
                 */
                background-color: #e9edd3;
                font-family:Arial ;
                font-size: 15px;
                
            }
            .hostel .descr{
                margin-left: 10px;
                float: left;
                width: 50%;
                /*border: 1px dotted;*/
                padding: 5px;
                background-color: #e9edd3;
            }
            .hostel .img{
                float: left;
                width: 40%;
                height: 120px;
                background-size: 100% 100%;
                border-radius: 20px;
                background-image: #eaf1f7;
            }
            .hostel a{text-decoration: none;}
           .button_knowmore{
                position: relative;
                top:5px;
                border: 3px outset;
                padding: 3px;
                background-color: #b0b2a7;
                color: white;
                border-radius: 5px;
            }
          /*   .button_1{
                position: relative;
                top:25px;
                left:-150px;
                border: 3px outset;
                padding: 3px;
                background-color: #3300cc;
                color: white;
                border-radius: 5px;
            }
            */
            .button:hover{
                background-color: #cc0000;
            }
        </style>
    </head>
    <body>
        
        <center>
            <a href="../guest/login_form.jsp" class="button_login">LOGIN</a>
        &nbsp;
       
        </center>
        
        <br/>
        <%
            try {
                Database db = new Database();
                String sql = "select * from hostel";
                ArrayList<String[]> hos = db.Select(sql, null);
                for (String[] h : hos) {
        %>
        
       
        <div class="main">
            <div class="hostel">
                <div>
                    View in Map
                    <a href="location.jsp?lat=<%= h[2]%>&lon=<%= h[3]%>"><img src="../img/map.png" alt="Map" height="30px"/></a>
                </div>
                <div class="img" style="background-image: url(../img/main1.jpg)"></div>
                <div class="descr">
                    <div>Hostel Name: <%= h[1]%></div>
                    <div>Address: <%= h[4]%></div>
                    <div>Place: <%= h[5]%></div>
                    <div>
                        Rating <img src="../img/star_1.png" width="15px"/>
                        <img src="../img/star_1.png" width="15px"/>
                        <img src="../img/star_1.png" width="15px"/>
                        <img src="../img/star_2.png" width="15px"/>
                        <img src="../img/star_2.png" width="15px"/>
                    </div>
                <div>
                        <a href="hostelDetails.jsp?hid=<%=h[0]%>" class="button_knowmore"> Know More ...</a>
                </div>
                    <div style="clear: both"></div>
<!--                    <div style="width:400px">
                        <a href="#" class="button_1"> Info </a>
                        <a href="#" class="button_1"> Know </a>
                        <a href="#" class="button_1"> Know </a>
                        </div>-->
                </div>
            </div>
        </div>
                
<!--        <div class="detail">

        </div>-->
        <%
                }
            } catch (Exception exc) {
                out.println(exc);
            }
        %>
    </body>
</html>

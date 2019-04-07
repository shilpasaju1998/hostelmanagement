
<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hostel</title>
        <style>
            .hostel,.detail{
                width: 100%;
                height: 500px;
                float: left;
               /* border: 5px solid black;
                margin: auto;
                margin-bottom: 5px;*/
                border-radius: 10px;
                padding: 10px;
                background-color: #e9edd3;
                font-family: Arial;
                font-size: 15px;
                color: #990000;
            }
            .hostel .descr{
                margin-left: 10px;
                float: left;
                width: 100%;
                /*border: 1px dotted;*/
                padding: 5px;
                overflow: auto;
            }
           .hostel .tab{
              
               
            }
            .hostel .img{
                float: left;
                width: 100%;
                height: 120px;
                background-size: 100% 100%;
                border-radius: 20px;
            }
            .hostel a{text-decoration: none;}
            .button{
                position: relative;
                top:5px;
                border: 3px outset;
                padding: 3px;
                background-color: #009900;
                color: white;
                border-radius: 5px;
            }
            .button_1{
                position: relative;
                top:25px;
                left:-150px;
                border: 3px outset;
                padding: 3px;
                background-color: #3300cc;
                color: white;
                border-radius: 5px;
            }
            .button:hover{
                background-color: #cc0000;
            }
            
        </style>
    </head>
    <body>
        <br/>
        <%
            try {
                String hid = request.getParameter("hid");
                Database db = new Database();
                String sql = "select * from hostel where hid = " + hid;
                ArrayList<String[]> hos = db.Select(sql, null);
                for (String[] h : hos) {
        %>
        <div class="hostel">
            <div>
                View in Map
                <a href="#"><img src="../img/map.png" alt="Map" height="30px"/></a>
            </div>
            <div class="img" style="background-image: url(../img/main1.jpg)"></div>
            <div class="descr">
                <div>Hostel Name: <%= h[1]%></div>
                <div >
                    Rating <img src="../img/star_1.png" width="15px"/>
                    <img src="../img/star_1.png" width="15px"/>
                    <img src="../img/star_1.png" width="15px"/>
                    <img src="../img/star_2.png" width="15px"/>
                    <img src="../img/star_2.png" width="15px"/>
                </div>
                <div>Address: <%= h[4]%></div>
                <div>Place: <%= h[5]%></div>
                
                <div >
                    <table >
                        <tr>
                            <th>Room Type</th>
                            <th>Price</th>
                            <th>No. of Beds</th>
                            <th>Available</th>
                        </tr>
                        <%
                            sql = "select rtype,price,nob from roomtype rt join rooms r on rt.rtid=r.rtid where hid = " + hid;
                            ArrayList<String[]> det = db.Select(sql, null);
                            for (String[] d : det) {
                        %>
                        <tr>
                            <td><%=d[0]%></td>
                            <td><%=d[1]%></td>
                            <td><%=d[2]%></td>
                            <td><%=d[2]%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
                <div>
                    <a href="booking.jsp?hid=<%=hid%>" class="button"> Book </a>
                </div>
                <div style="clear: both"></div>
                <!--                <div style="width:400px">
                                    <a href="#" class="button_1"> Info </a>
                                    <a href="#" class="button_1"> Know </a>
                                    <a href="#" class="button_1"> Know </a>
                                </div>-->
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

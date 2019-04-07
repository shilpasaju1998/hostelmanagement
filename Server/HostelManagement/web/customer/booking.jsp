<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<html>
    <head>
        <title>title</title>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="../js/validation-sherin_3.js" type="text/javascript"></script>

        <script>
            $(function () {
                $('#rid').change(function () {
                    $('#submit').removeAttr('disabled')
                    v = {
                        'rid': $(this).val(),
                        'fd': $('#fd').val(),
                        'td': $('#td').val()
                    }
                    $.post('getAvailable.jsp', v, function (dt) {
                        $('#err').html(dt)
                        if(dt.trim()==='0'){
                            $('#submit').attr('disabled','disabled')
                        }
                    });
                });
            })
        </script>
        <style>
            .form{
                background-color: #e9edd3;
                padding: 10px;

                position: absolute;
                left: 50%; top:50%;
                transform: translate(-50%,-50%);
            }
            .form input,textarea,select{
                width:100%;
                padding: 4px;
                border:none;
                border-bottom: 1px solid;
                outline: none;
                background-color: transparent;
            }
            .form textarea{
                height: 100px;
                resize: none;
            }
            .form input[type="submit"]{
                width: 50%;
                background-color: #003333;
                border: 4px groove;
                color: white;
            }
            .form input[type="submit"]:hover{
                background-color: #cc0000;
            }
            .form th{
                text-align: left;
            }
        </style>
    </head>
    <body>
        <%
            try {
                Database db = new Database();
                String un = (String) session.getAttribute("username");
                if (un == null) {
                    response.sendRedirect("../guest/login_form.jsp");
                }
                String hid = request.getParameter("hid");

                String fd = request.getParameter("fd");
                if (fd != null) {
                    String td = request.getParameter("td");
                    String reason = request.getParameter("reason");
                    String rid = request.getParameter("rid");
                    String idproof = request.getParameter("idproof");

                    String sql = "select ifnull(max(bid),0)+1 from booking";
                    String bid = db.Select(sql, null).get(0)[0];
                    sql = "insert into booking values(?,?,?,?,?,?,?,0)";
                    String[] param = {
                        bid, fd, td, rid, un, reason, idproof
                    };
                    db.Modify(sql, param);
                    response.sendRedirect("viewBooking.jsp");
                }

                String sql = "select * from roomtype rt join rooms r on rt.rtid=r.rtid where hid = " + hid;
                ArrayList<String[]> dt = db.Select(sql, null);
        %>

        <form method="post">
            <input type="hidden" name="hid" value="<%=hid%>"/>
            <table class="form">
                <tr>
                    <th>From Date</th>
                    <td><input type="date" id="fd" name="fd" placeholder="From Date" required="required"  onchange="dateWithCur('fd', 0, 0, 'err')"/>
                    </td>
                </tr>
                <tr>
                    <th>To Date</th>
                    <td><input type="date" id = "td" name="td" placeholder="To Date" required="required"  onchange="dateCompare('fd', 'td', 0, 0, 'err')"/></td>
                </tr>
                <tr>
                    <th>Room</th>
                    <th>
                        <select id="rid" name="rid" required="required">
                            <option value="">--Choose--</option>
                            <%
                                for (String[] d : dt) {
                            %>
                            <option value="<%=d[4]%>"> <%=d[1] + " - (" + d[2] + " beds)"%> </option>
                            <%
                                }
                            %>
                        </select>
                    </th>
                </tr>
                <tr>
                    <td colspan="2">
                        <h3 id="err"></h3>
                    </td>
                </tr>
                <tr>
                    <th>Reason</th>
                    <td>
                        <textarea name="reason" placeholder="Reason"  required="required"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>Id Proof</th>
                    <td><input type="text" name="idproof" placeholder="Id Proof" required="required"/> </td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <div id="err" style="color: red;height: 20px"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="Save" id="submit"/>
                    </td>
                </tr>
            </table>
        </form>


        <%
            } catch (Exception exc) {
                System.out.println("Error: " + exc);
            }
        %>
    </body>
</html>

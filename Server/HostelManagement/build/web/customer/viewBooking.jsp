<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<html>
    <head>
        <style>
            body{
                background-image: url(../img/search.png);
                background-size: 100% 100%;
            }
        </style>
    </head>

    <body>

        <%
            try {
                Database db = new Database();
                String id = request.getParameter("id");
                if (id != null) {
                    String sql = "update booking set status = 3 where bid = " + id;
                    db.Modify(sql, null);
                }
                String un = (String) session.getAttribute("username");
                String sql = "select * from booking where uname = ?";
                String[] param = {un};
                ArrayList<String[]> al = db.Select(sql, param);
        %>
        <table border="1" width="100%" cellspacing="0">
            <tr>
                <th>Bid</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>RoomId</th>
                <th>Username</th>
                <th>Reason</th>
                <th>Id Proof</th>
                <th>Status</th>
                <th>Cancel</th>
                <th>Payment</th>
            </tr>

            <%
                for (String[] x : al) {
                    out.print("<tr>");
                    for (int i = 0; i < x.length; i++) {
                        String y = x[i];
                        if (i == 7) {
                            y = y.equals("0") ? "Pending" : y.equals("1") ? "Accepted" : y.equals("2") ? "Rejected" : "Canceled";
                        }
                        out.print("<td>" + y + "</td>");
                    }
                    out.println("<td> <a href='?id=" + x[0] + "'>Cancel</a> </td>");
                    out.println("<td> <a href='viewPayment.jsp?bid=" + x[0] + "'>Payment</a> </td>");
                    out.print("</tr>");
                }
            %>
        </table>
        <%
            } catch (Exception exc) {

            }
        %>
    </body>
</html>
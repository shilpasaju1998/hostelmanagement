<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<html>
    <head>

    </head>

    <body>
        <%
            String bid = request.getParameter("bid");
            try {
                Database db = new Database();

                String sql = "select * from payment where bid = ? order by payid desc";
                String[] param = {bid};
                ArrayList<String[]> al = db.Select(sql, param);
                if (al.size() > 0) {
        %>
        <table border="1" width="100%" cellspacing="0">
            <tr>
                <th>Payment ID</th>
                 <th>Mode Of Payment</th>
                <th>Booking ID</th>
               
                <th>Date</th>
                <th>Amount</th>

            </tr>

            <%
                for (String[] x : al) {
                    out.print("<tr>");
                    for (String y : x) {
                        out.print("<td>" + y + "</td>");
                    }

                    out.print("</tr>");
                }
            %>
        </table>
        <%
                } else {
                    out.println("<h2 style='color:red'>Not found any payment details ! </h2>");
                }
            } catch (Exception exc) {

            }
        %>

        <h3>
            <a href="paymentForm.jsp?bid=<%=bid%>">Make Payment</a>
            <a href="viewBooking.jsp">Back</a>
        </h3>
    </body>
</html>
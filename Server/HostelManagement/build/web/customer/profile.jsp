<%@page import="stech.db.Database"%>
<%@page import="java.util.ArrayList"%>
<html>
    <body>
        <%
            try {
                Database db = new Database();
                String un = (String) session.getAttribute("username");
                String sql = "select * from customers where uname = ?";
                String[] p = {un};
                ArrayList<String[]> data = db.Select(sql, p);
                String[] dt = data.get(0);
        %>

        <table>
            <tr>
                <th>User Name</th>
                <td>: <%=dt[0]%></td>
            </tr>
            <tr>
                <th>Name</th>
                <td>: <%=dt[1]%></td>
            </tr>
            <tr>
                <th>Address</th>
                <td>: <%=dt[2]%></td>
            </tr>
            <tr>
                <th>Description</th>
                <td>: <%=dt[3]%></td>
            </tr>
            <tr>
                <th>Contact</th>
                <td>: <%=dt[4]%></td>
            </tr>
        </table>
        <%
            } catch (Exception exc) {
                out.println(exc);
            }
        %>
        <a href="editProfile.jsp">Edit</a>
    </body>
</html>
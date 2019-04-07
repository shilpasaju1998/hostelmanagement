<%@page import="stech.db.Database"%>
<%@page import="java.util.ArrayList"%>
<html>
    <body>
        <%
            try {
                Database db = new Database();
                
                String usr = request.getParameter("un");
                if(usr!=null){
                    String add = request.getParameter("add");
                    String des = request.getParameter("des");
                    String con = request.getParameter("con");
                    String sql ="update customers set address=?,descri=?,contact=? where uname=?";
                    String []p = {add,des,con,usr};
                    db.Modify(sql, p);
                }
                
                String un = (String) session.getAttribute("username");
                String sql = "select * from customers where uname = ?";
                String[] p = {un};
                ArrayList<String[]> data = db.Select(sql, p);
                String[] dt = data.get(0);
        %>
        <form method="post">
            <input type="hidden" name="un" value="<%=dt[0]%>"/>
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
                    <td>:<textarea name="add"><%=dt[2]%></textarea> </td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>:<textarea name="des" ><%=dt[3]%></textarea></td>
                </tr>
                <tr>
                    <th>Contact</th>
                    <td>:<input type="number" value="<%=dt[4]%>" name="con"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <a href="profile.jsp">Cancel</a>
                        <input type="submit" value="Update"/>
                    </td>
                </tr>
            </table>
        </form>
        <%
            } catch (Exception exc) {
                out.println(exc);
            }
        %>
    </body>
</html>
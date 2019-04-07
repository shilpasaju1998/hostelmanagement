<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<%
    String username = request.getParameter("username");
    if (username != null) {
        String psd = request.getParameter("psd");
        try {
            Database db = new Database();
            String sql = "select category from login where username = ? and password = ?";
            session.setAttribute("username", username);
            String[] param = new String[]{
                username, psd
            };
            ArrayList<String[]> datas = db.Select(sql, param);
            if (datas.size() > 0) {
                out.print(datas.get(0)[0]);
            } else {
                out.print("Error:Invalid User Name or Password");
            }
        } catch (Exception exc) {
            out.print("Error:" + exc);
        }
    }
%>
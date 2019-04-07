<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<%
    try {
        Database db = new Database();
        String sql = "select * from roomtype";
        ArrayList<String[]> datas = db.Select(sql, null);
        String dt = "";
        for (String[] x : datas) {
            for (String y : x) {
                dt += y + "~";
            }
            dt = dt.substring(0, dt.length() - 1);
            dt += "`";
        }
        dt = dt.substring(0, dt.length() - 1);
        out.print(dt);
    } catch (Exception exc) {
        out.print(exc.toString());
    }
%>
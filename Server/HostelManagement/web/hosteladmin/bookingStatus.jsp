<%@page import="java.util.ArrayList"%>
<%@page import="stech.db.Database"%>
<%
    try {
        Database db = new Database();
        String bid = request.getParameter("bid");
        String st = request.getParameter("status");
//        String de = request.getParameter("desc");
        String sql = "update booking set status = ? where bid = ?";
        String[] params = {st, bid};
        db.Modify(sql, params);

        out.print("Done");
    } catch (Exception exc) {
        out.print(exc.toString());
    }
%>
<%@page import="stech.db.Database"%>
<%
    String msg = "";
    try {
        String sql = "select (select availability from rooms where rid=?) - "
                + " count(*) from booking where fdate>= ? and tdate <= ? and rid= ? ";
        String rid = request.getParameter("rid");
        String fd = request.getParameter("fd");
        String td = request.getParameter("td");
        String[] params = {rid, fd, td, rid};
        Database db = new Database();
        String bal = db.Select(sql, params).get(0)[0];
        msg = bal;
    } catch (Exception exc) {
        msg = exc.toString();
    }
    out.println(msg);
%>
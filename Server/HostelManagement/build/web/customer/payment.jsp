<%@page import="stech.db.Database"%>
<%
    String msg = "";
    try {
        Database db = new Database();
        String bid = request.getParameter("bid");
        String mode = request.getParameter("mode");
        String amt = request.getParameter("amt");
        String sql = "select ifnull(max(payid),0) + 1 from payment";

        String pid = db.Select(sql, null).get(0)[0];
        sql = "insert into payment values(?,?,?,CURRENT_TIMESTAMP,?)";
        String[] param = {
            pid, mode, bid, amt
        };
        db.Modify(sql, param);
        msg = "Payment Done !!!";
    } catch (Exception exc) {
        msg = exc.toString();
    }
    out.print(msg);
%>

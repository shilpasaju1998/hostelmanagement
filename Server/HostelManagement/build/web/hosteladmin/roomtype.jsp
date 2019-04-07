<%@page import="stech.db.Database"%>
<%
    String rtype = request.getParameter("rtype");
    if (rtype != null) {

        String nob = request.getParameter("nob");
        String des = request.getParameter("des");
        try {
            Database db = new Database();
            String sql = "select ifnull(max(rtid),0)+1 from roomtype";
            String rtid = db.Select(sql, null).get(0)[0];
            sql = "insert into roomtype(rtid,rtype,nob,descri) values(?,?,?,?)";
            String[] param = new String[]{
                rtid, rtype, nob, des
            };
            int code = db.Modify(sql, param);
            if (code > 0) {

                out.print("Message: Saved");

            }

        } catch (Exception exc) {
            out.print("Error:" + exc);
        }
    }
%>
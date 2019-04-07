<%@page import="stech.db.Database"%>
<%
    String hid = request.getParameter("hstlid");
    if (hid != null) {

        String descri = request.getParameter("descri");
        String rating = request.getParameter("rating");
        String uname  = request.getParameter("uname");
        try {
            Database db = new Database();
            String sql = "select ifnull(max(rid),0)+1 from review";
            String rid = db.Select(sql, null).get(0)[0];
            sql = "insert into review(rid,uname,hid,descri,rating) values(?,?,?,?,?)";
            String[] param = new String[]{
                rid, uname, hid, descri, rating
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
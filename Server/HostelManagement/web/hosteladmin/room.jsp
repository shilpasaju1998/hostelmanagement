<<%@page import="stech.db.Database"%>
<%
    String hid = request.getParameter("hid");
    if (hid != null) {

        String rtid = request.getParameter("rtid");
        String price = request.getParameter("price");
        String availability = request.getParameter("availability");
        try {
            Database db = new Database();
            String sql = "select ifnull(max(rtid),0)+1 from rooms";
            String rid = db.Select(sql, null).get(0)[0];
            sql = "insert into rooms(rid,hid,rtid,price,availability) values(?,?,?,?,?)";
            String[] param = new String[]{
                rid,hid,rtid, price, availability
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
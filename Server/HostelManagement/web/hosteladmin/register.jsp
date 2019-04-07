<%@page import="stech.db.Database"%>
<%
    String hname = request.getParameter("hname");
    if (hname != null) {

        String lat = request.getParameter("lat");
        String longi = request.getParameter("longi");
        String add = request.getParameter("add");
        String place = request.getParameter("place");
        String desc = request.getParameter("desc");
        try {
            Database db = new Database();
            String sql = "select ifnull(max(hid),0)+1 from hostel";
            String hid = db.Select(sql, null).get(0)[0];
            sql = "insert into hostel(hid,hname,lat,longi,address,place,description) values(?,?,?,?,?,?,?)";
            String[] param = new String[]{
                hid, hname, lat, longi, add, place, desc
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
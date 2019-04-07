<%@page import="stech.db.Database"%>
<%
    String uname = request.getParameter("uname");
    if (uname != null) {
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        try {
            Database db = new Database();
            String sql = "insert into tblLogin values(uname,pwd,type,status) values(?,?,2,1)";
            String []param = new String[]{
                uname,pwd
            };
            int code = db.Modify(sql, param);
            if(code>0){
                sql = "insert into tblUser values(uname,name,address,cdate) values(?,?,?,CURRENT_TIMESTAMP)";
                param = new String[]{
                    uname,name,address
                };
                code = db.Modify(sql, param);
                 if(code>0){
                    out.print("Message: Saved"); 
                 }
            }
            
        } catch (Exception exc) {
            out.print("Error:" + exc);
        }
    }
%>
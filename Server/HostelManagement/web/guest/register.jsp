<%@page import="stech.db.Database"%>
<%
    String mail = request.getParameter("mail");
    if (mail != null) {
        String pwd = request.getParameter("pwd");
        String cat = request.getParameter("cat");
         String name = request.getParameter("name");
        String address = request.getParameter("address");
         String desri = request.getParameter("desri");
         String contact = request.getParameter("contact");
        try {
            Database db = new Database();
            String sql = "insert into login(username,password,category) values(?,?,?)";
            String []param = new String[]{
                mail,pwd,cat
            };
            int code = db.Modify(sql, param);
            if(code>0){
                sql = "insert into customers(uname,name,address,descri,contact) values(?,?,?,?,?)";
                param = new String[]{
                    mail,name,address,desri,contact
                };
                code = db.Modify(sql, param);
                 if(code>0){
                    out.print("Message: Saved"); 
//                    response.sendRedirect("");
                 }
            }
            
        } catch (Exception exc) {
            out.print("Error:" + exc);
        }
    }
%>

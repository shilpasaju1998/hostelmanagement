package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import stech.db.Database;

public final class viewBooking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-image: url(../img/search.png);\n");
      out.write("                background-size: 100% 100%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            try {
                Database db = new Database();
                String id = request.getParameter("id");
                if (id != null) {
                    String sql = "update booking set status = 3 where bid = " + id;
                    db.Modify(sql, null);
                }
                String un = (String) session.getAttribute("username");
                String sql = "select * from booking where uname = ?";
                String[] param = {un};
                ArrayList<String[]> al = db.Select(sql, param);
        
      out.write("\n");
      out.write("        <table border=\"1\" width=\"100%\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bid</th>\n");
      out.write("                <th>From Date</th>\n");
      out.write("                <th>To Date</th>\n");
      out.write("                <th>RoomId</th>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Reason</th>\n");
      out.write("                <th>Id Proof</th>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <th>Cancel</th>\n");
      out.write("                <th>Payment</th>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                for (String[] x : al) {
                    out.print("<tr>");
                    for (int i = 0; i < x.length; i++) {
                        String y = x[i];
                        if (i == 7) {
                            y = y.equals("0") ? "Pending" : y.equals("1") ? "Accepted" : y.equals("2") ? "Rejected" : "Canceled";
                        }
                        out.print("<td>" + y + "</td>");
                    }
                    out.println("<td> <a href='?id=" + x[0] + "'>Cancel</a> </td>");
                    out.println("<td> <a href='viewPayment.jsp?bid=" + x[0] + "'>Payment</a> </td>");
                    out.print("</tr>");
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

            } catch (Exception exc) {

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

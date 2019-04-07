package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import stech.db.Database;

public final class booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>title</title>\n");
      out.write("        <script src=\"../js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/validation-sherin_3.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $('#rid').change(function () {\n");
      out.write("                    v = {\n");
      out.write("                        'rid': $(this).val(),\n");
      out.write("                        'fd': $('#fd').val(),\n");
      out.write("                        'td': $('#td').val()\n");
      out.write("                    }\n");
      out.write("                    $.post('getAvailable.jsp',v,function (dt){\n");
      out.write("                        \n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            })\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            .form{\n");
      out.write("                background-color: #e9edd3;\n");
      out.write("                padding: 10px;\n");
      out.write("\n");
      out.write("                position: absolute;\n");
      out.write("                left: 50%; top:50%;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("            }\n");
      out.write("            .form input,textarea,select{\n");
      out.write("                width:100%;\n");
      out.write("                padding: 4px;\n");
      out.write("                border:none;\n");
      out.write("                border-bottom: 1px solid;\n");
      out.write("                outline: none;\n");
      out.write("                background-color: transparent;\n");
      out.write("            }\n");
      out.write("            .form textarea{\n");
      out.write("                height: 100px;\n");
      out.write("                resize: none;\n");
      out.write("            }\n");
      out.write("            .form input[type=\"submit\"]{\n");
      out.write("                width: 50%;\n");
      out.write("                background-color: #003333;\n");
      out.write("                border: 4px groove;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .form input[type=\"submit\"]:hover{\n");
      out.write("                background-color: #cc0000;\n");
      out.write("            }\n");
      out.write("            .form th{\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try {
                Database db = new Database();
                String un = (String) session.getAttribute("username");
                if (un == null) {
                    response.sendRedirect("../guest/login_form.jsp");
                }
                String hid = request.getParameter("hid");

                String fd = request.getParameter("fd");
                if (fd != null) {
                    String td = request.getParameter("td");
                    String reason = request.getParameter("reason");
                    String rid = request.getParameter("rid");
                    String idproof = request.getParameter("idproof");

                    String sql = "select ifnull(max(bid),0)+1 from booking";
                    String bid = db.Select(sql, null).get(0)[0];
                    sql = "insert into booking values(?,?,?,?,?,?,?)";
                    String[] param = {
                        bid, fd, td, rid, un, reason, idproof
                    };
                    db.Modify(sql, param);
                    response.sendRedirect("viewBooking.jsp");
                }

                String sql = "select * from roomtype rt join rooms r on rt.rtid=r.rtid where hid = " + hid;
                ArrayList<String[]> dt = db.Select(sql, null);
        
      out.write("\n");
      out.write("\n");
      out.write("        <form method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"hid\" value=\"");
      out.print(hid);
      out.write("\"/>\n");
      out.write("            <table class=\"form\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>From Date</th>\n");
      out.write("                    <td><input type=\"date\" id=\"fd\" name=\"fd\" placeholder=\"From Date\" required=\"required\"  onchange=\"dateWithCur('fd', 0, 0, 'err')\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>To Date</th>\n");
      out.write("                    <td><input type=\"date\" id = \"td\" name=\"td\" placeholder=\"To Date\" required=\"required\"  onchange=\"dateCompare('fd', 'td', 0, 0, 'err')\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Room</th>\n");
      out.write("                    <th>\n");
      out.write("                        <select id=\"rid\" name=\"rid\" required=\"required\">\n");
      out.write("                            <option value=\"\">--Choose--</option>\n");
      out.write("                            ");

                                for (String[] d : dt) {
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(d[4]);
      out.write("\"> ");
      out.print(d[1] + " - (" + d[2] + " beds)");
      out.write(" </option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Reason</th>\n");
      out.write("                    <td>\n");
      out.write("                        <textarea name=\"reason\" placeholder=\"Reason\"  required=\"required\"></textarea>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Id Proof</th>\n");
      out.write("                    <td><input type=\"text\" name=\"idproof\" placeholder=\"Id Proof\" required=\"required\"/> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"right\">\n");
      out.write("                        <div id=\"err\" style=\"color: red;height: 20px\"></div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" align=\"right\">\n");
      out.write("                        <input type=\"submit\" value=\"Save\" id=\"submit\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            } catch (Exception exc) {
                System.out.println("Error: " + exc);
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

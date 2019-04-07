package org.apache.jsp.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import stech.db.Database;

public final class viewHostels_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Hostel</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            .button_login {\n");
      out.write("                background-color: #003399; /* Green */\n");
      out.write("            border: none;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 28px;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("            display: inline-block;\n");
      out.write("            font-size: 16px;\n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .main{\n");
      out.write("                background-color: #eaf1f7\n");
      out.write("            }\n");
      out.write("            .hostel,.detail{\n");
      out.write("                width: 90%;\n");
      out.write("                height: 200px;\n");
      out.write("                margin: auto;\n");
      out.write("                margin-bottom: 5px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                float: center;\n");
      out.write("                padding: 10px;\n");
      out.write("                color: #f3e8e80;\n");
      out.write("               /*  \n");
      out.write("                \n");
      out.write("                border: 5px solid black;\n");
      out.write("               / \n");
      out.write("                \n");
      out.write("                 */\n");
      out.write("                background-color: #e9edd3;\n");
      out.write("                font-family:Arial ;\n");
      out.write("                font-size: 15px;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            .hostel .descr{\n");
      out.write("                margin-left: 10px;\n");
      out.write("                float: left;\n");
      out.write("                width: 50%;\n");
      out.write("                /*border: 1px dotted;*/\n");
      out.write("                padding: 5px;\n");
      out.write("                background-color: #e9edd3;\n");
      out.write("            }\n");
      out.write("            .hostel .img{\n");
      out.write("                float: left;\n");
      out.write("                width: 40%;\n");
      out.write("                height: 120px;\n");
      out.write("                background-size: 100% 100%;\n");
      out.write("                border-radius: 20px;\n");
      out.write("                background-image: #eaf1f7;\n");
      out.write("            }\n");
      out.write("            .hostel a{text-decoration: none;}\n");
      out.write("           .button_knowmore{\n");
      out.write("                position: relative;\n");
      out.write("                top:5px;\n");
      out.write("                border: 3px outset;\n");
      out.write("                padding: 3px;\n");
      out.write("                background-color: #b0b2a7;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("          /*   .button_1{\n");
      out.write("                position: relative;\n");
      out.write("                top:25px;\n");
      out.write("                left:-150px;\n");
      out.write("                border: 3px outset;\n");
      out.write("                padding: 3px;\n");
      out.write("                background-color: #3300cc;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("            */\n");
      out.write("            .button:hover{\n");
      out.write("                background-color: #cc0000;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <center>\n");
      out.write("            <a href=\"../guest/login_form.jsp\" class=\"button_login\">LOGIN</a>\n");
      out.write("        &nbsp;\n");
      out.write("       \n");
      out.write("        </center>\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        ");

            try {
                Database db = new Database();
                String sql = "select * from hostel";
                ArrayList<String[]> hos = db.Select(sql, null);
                for (String[] h : hos) {
        
      out.write("\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        <div class=\"main\">\n");
      out.write("            <div class=\"hostel\">\n");
      out.write("                <div>\n");
      out.write("                    View in Map\n");
      out.write("                    <a href=\"location.jsp?lat=");
      out.print( h[2]);
      out.write("&lon=");
      out.print( h[3]);
      out.write("\"><img src=\"../img/map.png\" alt=\"Map\" height=\"30px\"/></a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"img\" style=\"background-image: url(../img/main1.jpg)\"></div>\n");
      out.write("                <div class=\"descr\">\n");
      out.write("                    <div>Hostel Name: ");
      out.print( h[1]);
      out.write("</div>\n");
      out.write("                    <div>Address: ");
      out.print( h[4]);
      out.write("</div>\n");
      out.write("                    <div>Place: ");
      out.print( h[5]);
      out.write("</div>\n");
      out.write("                    <div>\n");
      out.write("                        Rating <img src=\"../img/star_1.png\" width=\"15px\"/>\n");
      out.write("                        <img src=\"../img/star_1.png\" width=\"15px\"/>\n");
      out.write("                        <img src=\"../img/star_1.png\" width=\"15px\"/>\n");
      out.write("                        <img src=\"../img/star_2.png\" width=\"15px\"/>\n");
      out.write("                        <img src=\"../img/star_2.png\" width=\"15px\"/>\n");
      out.write("                    </div>\n");
      out.write("                <div>\n");
      out.write("                        <a href=\"hostelDetails.jsp?hid=");
      out.print(h[0]);
      out.write("\" class=\"button_knowmore\"> Know More ...</a>\n");
      out.write("                </div>\n");
      out.write("                    <div style=\"clear: both\"></div>\n");
      out.write("<!--                    <div style=\"width:400px\">\n");
      out.write("                        <a href=\"#\" class=\"button_1\"> Info </a>\n");
      out.write("                        <a href=\"#\" class=\"button_1\"> Know </a>\n");
      out.write("                        <a href=\"#\" class=\"button_1\"> Know </a>\n");
      out.write("                        </div>-->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                \n");
      out.write("<!--        <div class=\"detail\">\n");
      out.write("\n");
      out.write("        </div>-->\n");
      out.write("        ");

                }
            } catch (Exception exc) {
                out.println(exc);
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

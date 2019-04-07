package org.apache.jsp.guest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link href=\"../css/first.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"../js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $('#log').click(function () {\n");
      out.write("                    un = $('#username').val()\n");
      out.write("                    pw = $('#psd').val()\n");
      out.write("                    v = {\n");
      out.write("                        'username': un, 'psd': pw\n");
      out.write("                    }\n");
      out.write("                    $.post('login.jsp', v, function (dt) {\n");
      out.write("                        dt = dt.trim()\n");
      out.write("                        if (dt === '3')\n");
      out.write("                            $('#err').text('Deactivated ?\\n contact admin !')\n");
      out.write("                        else if (dt === '2')\n");
      out.write("                            location.href = '../customer/home.jsp'\n");
      out.write("                        else\n");
      out.write("                            $('#err').text('Not a valid user!')\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            .login{\n");
      out.write("                position: absolute;\n");
      out.write("                left: 50%; top: 50%;\n");
      out.write("                transform: translate(-50%,-50%);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login\">\n");
      out.write("            <h3><b>LOGIN</b></h3>\n");
      out.write("            <input type=\"text\" name=\"username\" id =\"username\" placeholder=\"User Name\"/>\n");
      out.write("            <input type=\"password\" name=\"psd\" id=\"psd\" placeholder=\"Password\"/>\n");
      out.write("            <input type=\"button\" value=\"Login\" id=\"log\"/>\n");
      out.write("            <h3 id=\"err\"></h3>\n");
      out.write("            <h4>\n");
      out.write("                New User ?  Sign up from Menu.\n");
      out.write("            </h4>\n");
      out.write("        </div>\n");
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

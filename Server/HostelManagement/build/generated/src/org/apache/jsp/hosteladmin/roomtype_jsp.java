package org.apache.jsp.hosteladmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import stech.db.Database;

public final class roomtype_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

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

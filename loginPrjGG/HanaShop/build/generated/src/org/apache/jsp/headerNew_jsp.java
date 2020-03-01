package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class headerNew_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Bootstrap Example</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("  <style>\n");
      out.write("    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */\n");
      out.write("    .row.content {height: 1000px;\n");
      out.write("                  width: 800px;\n");
      out.write("        }\n");
      out.write("    \n");
      out.write("    /* Set gray background color and 100% height */\n");
      out.write("    .sidenav {\n");
      out.write("      background-color: #f1f1f1;\n");
      out.write("      height: 100%;\n");
      out.write("    }\n");
      out.write("        \n");
      out.write("    /* On small screens, set height to 'auto' for the grid */\n");
      out.write("    @media screen and (max-width: 767px) {\n");
      out.write("      .row.content {height: auto;} \n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse visible-xs\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a href=\"#\">Dashboard</a></li>\n");
      out.write("        <li><a href=\"#\">Age</a></li>\n");
      out.write("        <li><a href=\"#\">Gender</a></li>\n");
      out.write("        <li><a href=\"#\">Geo</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  <div class=\"row content\">\n");
      out.write("    <div class=\"col-sm-3 sidenav hidden-xs\">\n");
      out.write("      <h2>Logo</h2>\n");
      out.write("      <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("        <li class=\"active\"><a href=\"#section1\">Dashboard</a></li>\n");
      out.write("        <li><a href=\"#section2\">Age</a></li>\n");
      out.write("        <li><a href=\"#section3\">Gender</a></li>\n");
      out.write("        <li><a href=\"#section3\">Geo</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("       <div id=\"products\" class=\"row list-group\">\n");
      out.write("                <div class=\"item  col-xs-3 col-lg-3\">\n");
      out.write("                    <div class=\"thumbnail\">\n");
      out.write("                        <img class=\"group list-group-image\" src=\"https://source.unsplash.com/400x250/?mobile\" alt=\"\" />\n");
      out.write("                        <div class=\"caption\">\n");
      out.write("                            <h4 class=\"group inner list-group-item-heading\">\n");
      out.write("                                Product title</h4>\n");
      out.write("                            <p class=\"group inner list-group-item-text\">\n");
      out.write("                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,\n");
      out.write("                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <p class=\"lead\">\n");
      out.write("                                        $21.000</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <a class=\"btn btn-success\" href=\"#1\">Add to cart</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item  col-xs-3 col-lg-3\">\n");
      out.write("                    <div class=\"thumbnail\">\n");
      out.write("                        <img class=\"group list-group-image\" src=\"https://source.unsplash.com/400x250/?watch\" alt=\"\" />\n");
      out.write("                        <div class=\"caption\">\n");
      out.write("                            <h4 class=\"group inner list-group-item-heading\">\n");
      out.write("                                Codehim.com</h4>\n");
      out.write("                            <p class=\"group inner list-group-item-text\">\n");
      out.write("                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,\n");
      out.write("                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <p class=\"lead\">\n");
      out.write("                                        $21.000</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <a class=\"btn btn-success\" href=\"#2\">Add to cart</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"item  col-xs-3 col-lg-3\">\n");
      out.write("                    <div class=\"thumbnail\">\n");
      out.write("                        <img class=\"group list-group-image\" src=\"https://source.unsplash.com/400x250/?t-shirt\" alt=\"\" />\n");
      out.write("                        <div class=\"caption\">\n");
      out.write("                            <h4 class=\"group inner list-group-item-heading\">\n");
      out.write("                                Product title</h4>\n");
      out.write("                            <p class=\"group inner list-group-item-text\">\n");
      out.write("                                Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,\n");
      out.write("                                sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <p class=\"lead\">\n");
      out.write("                                        $21.000</p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-12 col-md-6\">\n");
      out.write("                                    <a class=\"btn btn-success\" href=\"#3\">Add to cart</a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("       </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("    <br>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
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

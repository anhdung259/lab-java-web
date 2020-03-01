package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Loginwithgg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta name=\"google-signin-scope\" content=\"profile email\">\n");
      out.write("    <meta name=\"google-signin-client_id\" content=\"1046183644041-dqlejguijkshce070av33vk3pe679r64.apps.googleusercontent.com\">\n");
      out.write("    <script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"g-signin2\" data-onsuccess=\"onSignIn\" data-theme=\"dark\"></div>\n");
      out.write("    <script>\n");
      out.write("      function onSignIn(googleUser) {\n");
      out.write("        // Useful data for your client-side scripts:\n");
      out.write("        var profile = googleUser.getBasicProfile();\n");
      out.write("        console.log(\"ID: \" + profile.getId()); // Don't send this directly to your server!\n");
      out.write("        console.log('Full Name: ' + profile.getName());\n");
      out.write("        console.log('Given Name: ' + profile.getGivenName());\n");
      out.write("        console.log('Family Name: ' + profile.getFamilyName());\n");
      out.write("        console.log(\"Image URL: \" + profile.getImageUrl());\n");
      out.write("        console.log(\"Email: \" + profile.getEmail());\n");
      out.write("\n");
      out.write("        // The ID token you need to pass to your backend:\n");
      out.write("        var id_token = googleUser.getAuthResponse().id_token;\n");
      out.write("        console.log(\"ID Token: \" + id_token);\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("  </body>\n");
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

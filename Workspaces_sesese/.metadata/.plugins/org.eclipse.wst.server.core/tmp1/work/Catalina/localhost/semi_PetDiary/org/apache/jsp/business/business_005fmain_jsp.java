/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-04-22 17:35:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.business;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.pet.ft.dto.BusinessDto;
import com.pet.ft.model.PetBizImpl;
import com.pet.ft.model.PetBiz;

public final class business_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/main/header.jsp", Long.valueOf(1618726694000L));
    _jspx_dependants.put("/main/footer.jsp", Long.valueOf(1618722532000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.pet.ft.dto.BusinessDto");
    _jspx_imports_classes.add("com.pet.ft.model.PetBizImpl");
    _jspx_imports_classes.add("com.pet.ft.model.PetBiz");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write('\r');
      out.write('\n');
 response.setContentType("text/html; charset=UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>관리자 모드</title>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\t.viewMember, .viewBorder, .viewBook{\r\n");
      out.write("\t\tposition: fixed\t;\r\n");
      out.write("\t\tborder-bottom : 2px solid black;\t\r\n");
      out.write("\t\twidth:180px;\r\n");
      out.write("\t\theight:20px;\r\n");
      out.write("\t\tmargin : 50px;\r\n");
      out.write("\t\tbackground-color: skyblue;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tborder-radius: 6px;\r\n");
      out.write("\t\tcursor:pointer\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.viewMember:hover, .viewBorder:hover, .viewBook:hover{\r\n");
      out.write("\t\tbackground-color:mistyrose;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.viewBorder {\r\n");
      out.write("\t\tmargin: 100px 50px;\r\n");
      out.write("\t\tbackground-color: #ff6670;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.viewBook{\r\n");
      out.write("\t\tmargin: 150px 50px;\r\n");
      out.write("\t\tbackground-color: gray;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

      out.write("\r\n");
      out.write("<link href=\"/semi_PetDiary/resources/css/stylesheet.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <script src=\"https://kit.fontawesome.com/95780683f0.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" \t<nav class=\"header\">\r\n");
      out.write("\t\t<div class=\"header_logo\">\r\n");
      out.write("\t\t\t<i class=\"fas fa-paw\"></i>\r\n");
      out.write("\t\t\t<a href=\"\">Pet Diary</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"header_menu\">\r\n");
      out.write("    \t\t\r\n");
      out.write("       \t \t\t<li><a href=\"#\">다이어리</a></li>\r\n");
      out.write("        \t\t<li><a href=\"#\">나와 닮은 동물 찾기</a></li>\r\n");
      out.write("       \t\t\t<li><a href=\"#\">병원상담</a></li>\r\n");
      out.write("      \t\t\t<li><a href=\"#\">음식/카페</a></li>\r\n");
      out.write("       \t\t\t<li><a href=\"/semi_PetDiary/pet.do?command=community\">커뮤니티</a></li>\r\n");
      out.write("       \t\t    <li>\r\n");
      out.write("          \t\t\t <form action=\"#\" method=\"post\">\r\n");
      out.write("            \t  \t\t <input type=\"text\" id=\"searchBox\">\r\n");
      out.write("            \t  \t\t <input type=\"submit\" value=\"검색\">\r\n");
      out.write("          \t\t\t </form>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("       \t\t\t\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("   \t\t\r\n");
      out.write("   \t\t<ul class=\"header_login\">\r\n");
      out.write("   \t\t\t<li><a href=\"#\">로그인</a></li>\r\n");
      out.write("   \t\t\t<li><a href=\"#\">회원가입</a></li>\r\n");
      out.write("   \t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<ul class=\"header_icons\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li><a href=\"/semi_PetDiary/pet.do?command=business\"><i class=\"fas fa-user-circle\"></i></a></li>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<a href=\"#\" class=\"header_toggleBtn\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-bars\"></i>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</nav>\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	PetBiz biz = new PetBizImpl();
	int mRes = biz.totalMember();
	int rRes = biz.totalReport();
	int bRes = biz.totalBook();
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- <div class=\"viewMember\" onclick=\"location.href='/semi_PetD\tiary/pet.do?command=list'\"> -->\r\n");
      out.write("\t<div class=\"viewMember\" onclick=\"location.href='/semi_PetDiary/paging.do?command=member'\">\r\n");
      out.write("\t\t<span>전체 회원 조회 : </span>&nbsp;\r\n");
      out.write("\t\t<span class=\"dot\">");
      out.print(mRes );
      out.write("</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"viewBorder\" onclick=\"location.href='/semi_PetDiary/paging.do?command=report'\">\r\n");
      out.write("\t\t<span>신고 글 조회 : </span>&nbsp;\r\n");
      out.write("\t\t<span class=\"dot\">");
      out.print(rRes );
      out.write("</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"viewBook\" onclick=\"location.href='/semi_PetDiary/paging.do?command=book'\">\r\n");
      out.write("\t\t<span>예약 조회 : </span>&nbsp;\r\n");
      out.write("\t\t<span class=\"dot\">");
      out.print(bRes );
      out.write("</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 request.setCharacterEncoding("UTF-8"); 
      out.write('\r');
      out.write('\n');
 response.setContentType("text/html; charset=UTF-8"); 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tfooter {\r\n");
      out.write("\t\tbackground-color: white;\r\n");
      out.write("\t\tborder-top: 1px solid #c4c4c4;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.footerlogo img {\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 100px;\r\n");
      out.write("\t\tpadding-left: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.aboutus {\r\n");
      out.write("\t\tpadding-left: 10px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 0;\r\n");
      out.write("\t\tmin-width: 100%;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tz-index: 1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.social {\r\n");
      out.write("\t\tbottom: 10px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tpadding-right: 30px;\r\n");
      out.write("\t\tz-index: 1;\r\n");
      out.write("\t\tmargin-left: 1700px;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.quick {\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 0;\r\n");
      out.write("\t\tbackground-color: salmon;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\theight: 100px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.quick div span {\r\n");
      out.write("\t\tpadding : 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\th1 {\r\n");
      out.write("\t\tfont-size: 22px; \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.social div img {\r\n");
      out.write("\t\twidth: 40px;\r\n");
      out.write("\t\theight: 40px;\r\n");
      out.write("\t\tpadding: 5px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<div class=\"footerlogo\">\r\n");
      out.write("\t\t\t<img src=\"/semi_PetDiary/resources/image/footerlogo.png\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"aboutus\">\r\n");
      out.write("\t\t\t<h1>ABOUT US</h1>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<span>서울특별시 강남구 테헤란로14길 6 남도빌딩</span><br/>\r\n");
      out.write("\t\t\t\t<span>semiproject.pet@gmail.com</span><br/>\r\n");
      out.write("\t\t\t\t<span>TEAM 화이팅!</span><br/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"social\">\r\n");
      out.write("\t\t\t<h1>SOCIAL</h1>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<span><a href=\"#\"><img src=\"/semi_PetDiary/resources/image/instagram.png\"></a></span>\r\n");
      out.write("\t\t\t\t<span><a href=\"#\"><img src=\"/semi_PetDiary/resources/image/facebook.png\"></a></span>\r\n");
      out.write("\t\t\t\t<span><a href=\"#\"><img src=\"/semi_PetDiary/resources/image/google.png\"></a></span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"quick\">\r\n");
      out.write("\t\t\t<h3>QUICK LINKS</h3>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<span>HOME</span>\r\n");
      out.write("\t\t\t\t\t<span>다이어리</span>\r\n");
      out.write("\t\t\t\t\t<span>병원 찾기</span>\r\n");
      out.write("\t\t\t\t\t<span>반려동물 출입가능 시설 찾기</span>\r\n");
      out.write("\t\t\t\t\t<span>예약내역</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

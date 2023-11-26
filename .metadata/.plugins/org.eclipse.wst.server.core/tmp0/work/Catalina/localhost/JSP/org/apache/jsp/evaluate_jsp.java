/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-11-25 09:45:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import evaluation.EvaluationDTO;
import java.util.ArrayList;
import evaluation.EvaluationDAO;
import java.io.PrintWriter;

public final class evaluate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("evaluation.EvaluationDTO");
    _jspx_imports_classes.add("evaluation.EvaluationDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("	\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width\" , initial-scale=\"1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./css/custom.css\">\r\n");
      out.write("<title>JSP 게시판 웹 사이트</title>\r\n");
      out.write("<meta charset=\"EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("	<!-- <!--부트스트랩 CSS 추가하기\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"./css/bootstrapeval.min.css?ver=1\"> -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
	
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-default\">\r\n");
      out.write("		<div class=\"navbar-header\">\r\n");
      out.write("			<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("				data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\"\r\n");
      out.write("				aria-expanded=\"false\">\r\n");
      out.write("				<span class=\"icon-bar\"></span> \r\n");
      out.write("				<span class=\"icon-bar\"></span> \r\n");
      out.write("				<span class=\"icon-bar\"></span>\r\n");
      out.write("			</button>\r\n");
      out.write("			<a class=\"navbar-brand\" href=\"main.jsp\">강의평가 웹 사이트</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("			<ul class=\"nav navbar-nav\">\r\n");
      out.write("				<li><a href=\"main.jsp\">메인</a></li>\r\n");
      out.write("				<li><a href=\"bbs.jsp\">자유게시판</a></li>\r\n");
      out.write("				<li><a href=\"chatroom.jsp\">실시간채팅</a></li>\r\n");
      out.write("				<li class = \"active\"><a href=\"evaluate.jsp\">강의평가</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");
	
			if(userID == null){
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("				<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("					data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("					aria-expanded=\"false\">접속하기<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a href=\"login.jsp\">로그인</a></li>\r\n");
      out.write("						<li><a href=\"join.jsp\">회원가입</a></li>	\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("			");

			} else{
			
      out.write("\r\n");
      out.write("			<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("				<li class=\"dropdown\">\r\n");
      out.write("				<a href=\"#\" class=\"dropdown-toggle\"\r\n");
      out.write("					data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\"\r\n");
      out.write("					aria-expanded=\"false\">회원관리<span class=\"caret\"></span></a>\r\n");
      out.write("					<ul class=\"dropdown-menu\">\r\n");
      out.write("						<li><a href=\"logoutAction.jsp\">로그아웃</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</li>\r\n");
      out.write("			</ul>\r\n");
      out.write("				\r\n");
      out.write("			");
 
			}
			
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</nav>\r\n");
      out.write("	<section class=\"container\">\r\n");
      out.write("		<form method=\"get\" action=\"./evaluate.jsp\" class=\"form-inline mt-3\">\r\n");
      out.write("			<select name=\"lectureDivide\" class=\"form-control mx-1 mt-2\">\r\n");
      out.write("				<option value=\"전체\">전체</option>\r\n");
      out.write("				<option value=\"전공\">전공</option>\r\n");
      out.write("				<option value=\"교양\">교양</option>\r\n");
      out.write("				<option value=\"기타\">기타</option>\r\n");
      out.write("			</select>\r\n");
      out.write("			<input type=\"text\" name=\"search\" class=\"form-control mx-1 mt-2\" placeholder=\"내용을 입력하세요\">\r\n");
      out.write("			<button type=\"submit\" class=\"btn btn-primary mx-1 mt-2\">검색</button>\r\n");
      out.write("			<a class=\"btn btn-primary mx-1 mt-2\" data-toggle=\"modal\" href=\"#registerModal\">등록하기</a>\r\n");
      out.write("			\r\n");
      out.write("		</form>\r\n");
      out.write("	</section>\r\n");
      out.write("	<section class=\"container center\">\r\n");
      out.write("	");

	EvaluationDAO evaldao = new EvaluationDAO();
	ArrayList<EvaluationDTO> list = evaldao.getList();
	for(int i = 0; i<list.size();i++){
	
	
      out.write("\r\n");
      out.write("	<div class=\"card bg-light mt-3\">\r\n");
      out.write("		<div class=\"card-header bg-light\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-8 text-left\">");
      out.print(list.get(i).getLectureName());
      out.write(" &nbsp; <small>");
      out.print(list.get(i).getProfessorName());
      out.write("</small></div>\r\n");
      out.write("				<div class=\"col-4 text-right\">\r\n");
      out.write("					종합 <span style=\"color: red;\">");
      out.print(list.get(i).getTotalScore());
      out.write("</span>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div class=\"card-body\">\r\n");
      out.write("			<h5 class=\"card-title\">\r\n");
      out.write("				");
      out.print(list.get(i).getEvaluationTitle());
      out.write("&nbsp;<small>");
      out.print(list.get(i).getLectureYear());
      out.write('년');
      out.print(list.get(i).getSemesterDivide());
      out.write("</small>\r\n");
      out.write("			</h5>\r\n");
      out.write("			<p class=\"card-text\">");
      out.print(list.get(i).getEvaluationContent());
      out.write("</p>\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-9 text-left\">\r\n");
      out.write("					성적 <span style=\"color:red;\">");
      out.print(list.get(i).getCreditScore());
      out.write("</span>\r\n");
      out.write("					난이도 <span style=\"color:red;\">");
      out.print(list.get(i).getComfortableScore());
      out.write("</span>\r\n");
      out.write("					강의 <span style=\"color:red;\">");
      out.print(list.get(i).getLectureScore());
      out.write("</span>\r\n");
      out.write("					<span style=\"color:green;\">(추천: 15)</span>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"col-3 text-right\">\r\n");
      out.write("					<a onclick=\"return confirm('추천하시겠습니까?')\" href=\"./likeAction.jsp?evaluationID=\">추천</a>\r\n");
      out.write("					<a onclick=\"return confirm('삭제하시겠습니까?')\" href=\"./deleteAction.jsp?evaluationID=\">삭제</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	</section>\r\n");
      out.write("	<div class=\"modal fade\" id=\"registerModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("		<div class=\"modal-dialog\">\r\n");
      out.write("			<div class=\"modal-content\">\r\n");
      out.write("				<div class=\"modal-header\">\r\n");
      out.write("					<h5 class=\"modal-title\" id=\"modal\">평가 등록</h5>\r\n");
      out.write("					<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"close\">\r\n");
      out.write("						<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("					</button>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"modal-body\">\r\n");
      out.write("					<form action=\"evaluationRegisterAction.jsp\" method=\"post\">\r\n");
      out.write("						<div class=\"form-row\">\r\n");
      out.write("							<div class=\"form-group col-sm-6\">\r\n");
      out.write("								<label>강의명</label>\r\n");
      out.write("								<input type=\"text\" name=\"lectureName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"form-group col-sm-6\">\r\n");
      out.write("								<label>교수명</label>\r\n");
      out.write("								<input type=\"text\" name=\"professorName\" class=\"form-control\" maxlength=\"20\">\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-row\">\r\n");
      out.write("							<div class=\"form-group col-sm-4\">\r\n");
      out.write("							<label>수강연도</label>\r\n");
      out.write("							<select name=\"lectureYear\" class=\"form-control\">\r\n");
      out.write("								<option value=\"2018\">2018</option>\r\n");
      out.write("								<option value=\"2019\">2019</option>\r\n");
      out.write("								<option value=\"2020\">2020</option>\r\n");
      out.write("								<option value=\"2021\">2021</option>\r\n");
      out.write("								<option value=\"2022\">2022</option>\r\n");
      out.write("								<option value=\"2023\" selected>2023</option>\r\n");
      out.write("								<option value=\"2024\">2024</option>\r\n");
      out.write("								<option value=\"2025\">2025</option>\r\n");
      out.write("								<option value=\"2026\">2026</option>\r\n");
      out.write("								<option value=\"2027\">2027</option>\r\n");
      out.write("								<option value=\"2028\">2028</option>\r\n");
      out.write("								<option value=\"2029\">2029</option>\r\n");
      out.write("								<option value=\"2030\">2030</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group col-sm-4\">\r\n");
      out.write("							<label>수강학기</label>\r\n");
      out.write("							<select name=\"semesterDivide\" class=\"form-control\">\r\n");
      out.write("								<option value=\"1학기\" selected>1학기</option>\r\n");
      out.write("								<option value=\"여름학기\">여름학기</option>\r\n");
      out.write("								<option value=\"2학기\">2학기</option>\r\n");
      out.write("								<option value=\"겨울학기\">겨울학기</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("						<div class=\"form-group col-sm-4\">\r\n");
      out.write("							<label>강의구분</label>\r\n");
      out.write("							<select name=\"lectureDivide\" class=\"form-control\">\r\n");
      out.write("								<option value=\"전공\" selected>전공</option>\r\n");
      out.write("								<option value=\"교양\">교양</option>\r\n");
      out.write("								<option value=\"기타\">기타</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label>제목</label>\r\n");
      out.write("							<input type=\"text\" name=\"evaluationTitle\" class=\"form-control\" maxlength=\"30\">\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label>내용</label>\r\n");
      out.write("							<textarea name=\"evaluationContent\" class=\"form-control\" maxlength=\"2048\" style=\"height: 180px;\"></textarea>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"form-row\">\r\n");
      out.write("							<div class=\"form-group col-sm-3\">\r\n");
      out.write("								<label>종합</label>\r\n");
      out.write("								<select name=\"totalScore\" class=\"form-control\">\r\n");
      out.write("									<option value=\"A\" selected>A</option>\r\n");
      out.write("									<option value=\"B\">B</option>\r\n");
      out.write("									<option value=\"C\">C</option>\r\n");
      out.write("									<option value=\"D\">D</option>\r\n");
      out.write("									<option value=\"F\">F</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"form-group col-sm-3\">\r\n");
      out.write("								<label>성적</label>\r\n");
      out.write("								<select name=\"creditScore\" class=\"form-control\">\r\n");
      out.write("									<option value=\"A\" selected>A</option>\r\n");
      out.write("									<option value=\"B\">B</option>\r\n");
      out.write("									<option value=\"C\">C</option>\r\n");
      out.write("									<option value=\"D\">D</option>\r\n");
      out.write("									<option value=\"F\">F</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"form-group col-sm-3\">\r\n");
      out.write("								<label>난이도</label>\r\n");
      out.write("								<select name=\"comfortableScore\" class=\"form-control\">\r\n");
      out.write("									<option value=\"A\" selected>A</option>\r\n");
      out.write("									<option value=\"B\">B</option>\r\n");
      out.write("									<option value=\"C\">C</option>\r\n");
      out.write("									<option value=\"D\">D</option>\r\n");
      out.write("									<option value=\"F\">F</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"form-group col-sm-3\">\r\n");
      out.write("								<label>강의</label>\r\n");
      out.write("								<select name=\"lectureScore\" class=\"form-control\">\r\n");
      out.write("									<option value=\"A\" selected>A</option>\r\n");
      out.write("									<option value=\"B\">B</option>\r\n");
      out.write("									<option value=\"C\">C</option>\r\n");
      out.write("									<option value=\"D\">D</option>\r\n");
      out.write("									<option value=\"F\">F</option>\r\n");
      out.write("								</select>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"modal-footer\">\r\n");
      out.write("							<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("							<button type=\"submit\" class=\"btn btn-primary\">등록하기</button>\r\n");
      out.write("						</div>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"modal fade\" id=\"reportModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("		<div class=\"modal-dialog\">\r\n");
      out.write("			<div class=\"modal-content\">\r\n");
      out.write("				<div class=\"modal-header\">\r\n");
      out.write("					<h5 class=\"modal-title\" id=\"modal\">신고하기</h5>\r\n");
      out.write("					<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"close\">\r\n");
      out.write("						<span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("					</button>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<!--제이쿼리 자바스크립트 추가하기  -->\r\n");
      out.write("	<script src=\"./js/jquery.min.js\"></script>\r\n");
      out.write("	<!--파퍼 자바스크립트 추가하기  -->\r\n");
      out.write("	<script src=\"./js/popper.min.js\"></script>\r\n");
      out.write("	<!--부트스트랩 자바스크립트 추가하기  -->\r\n");
      out.write("	<script src=\"./js/bootstrapeval.min.js\"></script>\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("	<script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("	<style>\r\n");
      out.write("	\r\n");
      out.write(" 	 .card {\r\n");
      out.write("        border: 1px solid #ddd;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        overflow: hidden;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    .col-8,.col-9,.col-3,\r\n");
      out.write("    .col-4 {\r\n");
      out.write("        padding: 0 15px;\r\n");
      out.write("    }\r\n");
      out.write("  \r\n");
      out.write("	</style>\r\n");
      out.write("	\r\n");
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

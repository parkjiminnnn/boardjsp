/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2023-11-12 16:55:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.UserDAO;
import evaluation.EvaluationDAO;
import evaluation.EvaluationDTO;
import util.SHA256;
import java.io.PrintWriter;

public final class evaluationRegisterAction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("util.SHA256");
    _jspx_imports_classes.add("java.io.PrintWriter");
    _jspx_imports_classes.add("evaluation.EvaluationDTO");
    _jspx_imports_classes.add("evaluation.EvaluationDAO");
    _jspx_imports_classes.add("user.UserDAO");
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
      out.write("\r\n");
      out.write("\r\n");

	//강의 평가 등록 코드
	request.setCharacterEncoding("euc-kr"); 
	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
	if(userID == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.')");
		script.println("location.href = 'login.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
	String lectureName = null;		
	String professorName = null;
	int lectureYear = 0;
	String semesterDivide = null;
	String lectureDivide = null;
	String evaluationTitle = null;
	String evaluationContent = null;
	String totalScore = null;
	String creditScore = null;
	String comfortableScore = null;
	String lectureScore = null;
	
	if(request.getParameter("lectureName")!=null){
		lectureName = request.getParameter("lectureName");
	}
	if(request.getParameter("professorName")!=null){
		professorName = request.getParameter("professorName");
	}
	if(request.getParameter("lectureYear")!=null){
		try{
		lectureYear = Integer.parseInt(request.getParameter("lectureYear"));
		}catch(Exception e){
			System.out.println("강의 연도 데이터 오류");	
		}
	}
	if(request.getParameter("semesterDivide")!=null){
		semesterDivide = request.getParameter("semesterDivide");
	}
	if(request.getParameter("lectureDivide")!=null){
		lectureDivide = request.getParameter("lectureDivide");
	}
	if(request.getParameter("evaluationTitle")!=null){
		evaluationTitle = request.getParameter("evaluationTitle");
	}
	if(request.getParameter("evaluationContent")!=null){
		evaluationContent = request.getParameter("evaluationContent");
	}
	if(request.getParameter("totalScore")!=null){
		totalScore = request.getParameter("totalScore");
	}
	if(request.getParameter("creditScore")!=null){
		creditScore = request.getParameter("creditScore");
	}
	if(request.getParameter("comfortableScore")!=null){
		comfortableScore = request.getParameter("comfortableScore");
	}
	if(request.getParameter("lectureScore")!=null){
		lectureScore = request.getParameter("lectureScore");
	}
	if(lectureName == null || professorName == null || lectureYear == 0 || semesterDivide == null || 
		   lectureDivide == null || evaluationTitle == null || evaluationContent == null || totalScore == null || 
		   creditScore == null || comfortableScore == null || lectureScore == null){	
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
		
	} 
	EvaluationDAO evaluationDAO = new EvaluationDAO();
	int result = evaluationDAO.write(new EvaluationDTO(0, userID, lectureName, professorName, 
			lectureYear, semesterDivide, lectureDivide, evaluationTitle, evaluationContent,
			totalScore, creditScore, comfortableScore, lectureScore, 0));
	if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('강의 평가 등록에 실패했습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'evaluate.jsp';");
		script.println("</script>");
		script.close();
		return;
	}


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

<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import = "bbs.BbsDAO" %>
	<%@page import = "bbs.Bbs" %>
	<%@page import = "java.util.ArrayList" %>
	<%@page import = "chat.Chat" %>
	<%@page import = "chat.chatDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>강의평가 웹사이트</title>
<style type="text/css">
	a, a:hover{
		color: #000000;
		text-decoration: none;
	}
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String userID = null;
		if(session.getAttribute("userID") != null){
			userID = (String) session.getAttribute("userID");
		}
		int pageNumber = 1;
		if(request.getParameter("pageNumber") != null){
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">강의평가 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">자유게시판</a></li>
				<li class = "active"><a href="chatroom.jsp">실시간채팅</a></li>
				<li><a href="evaluate.jsp">강의평가</a></li>
			</ul>
			<%
			if(userID == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>	
					</ul>
				</li>
			</ul>
			<%
			} else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>
				
			<% 
			}
			%>
		</div>
	</nav>
	<div class="container">

		<div class="row">
		<a data-toggle="modal" href="#chatModal" class="btn btn-primary pull-left">방만들기</a>
			<!-- 모달 창 -->
			<div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">방 만들기</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          
		        </button>
		      </div>
		        <form action="chatroom.jsp" method="post">
		      <div class="modal-body">
		        <!-- 방 만들기 폼 -->
			      <div class="form-group">
			         <label for="chatTitle">방 제목</label>
			         <input type="text" class="form-control" name="chatTitle" id="chatTitle" placeholder="방 제목을 입력하세요">
			      </div>
			   </div>
			   <div class="modal-footer">
			      <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			      <input type="submit" class="btn btn-primary" value="생성하기">
			   </div>
			</form>
		    </div>
		  </div>
		</div>
		
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="backgroundcolor: #eeeeee; text-align: center;">방번호</th>
						<th style="backgroundcolor: #eeeeee; text-align: center;">채팅방목록</th>
						<th style="backgroundcolor: #eeeeee; text-align: center;"></th>
					</tr>
				</thead>
				<tbody>
				<%
					chatDAO chatdao = new chatDAO();
					ArrayList<Chat> list = chatdao.getList(pageNumber);
					
					if(request.getMethod().equalsIgnoreCase("POST")) {
				        // POST 요청이 왔을 때만 실행
				        String chatTitle = request.getParameter("chatTitle");
				        chatdao.write(chatTitle); // 채팅방을 생성하는 메소드를 호출하고 데이터베이스에 새로운 채팅방 정보를 추가하는 것으로 가정
				        list = chatdao.getList(pageNumber); // 새로운 목록을 가져옴
				    }
					for(int i = 0; i< list.size(); i++){
				%>
					 <tr>
						<td><%= list.get(i).getChatroomID()%></td>
						<td><%= list.get(i).getChattitle()%></td>	
						<td><a href="Chat.jsp?roomnumber=<%=list.get(i).getChatroomID()%>&chattitle=<%= list.get(i).getChattitle()%>" class="btn btn-primary pull-right">입장하기</a></td>
					</tr> 
				<%		
					}
				%>
				</tbody>
			</table>
			<%
				if(pageNumber !=1){
			%>	
					<a href="chatroom.jsp?pageNumber=<%=pageNumber - 1%>" class="btn btn-success btn-arrow-left">이전페이지</a>	
			<%		
				}if(chatdao.nextPage(pageNumber + 1)){
			%>
				<a href="chatroom.jsp?pageNumber=<%=pageNumber + 1%>" class="btn btn-success btn-arrow-left">다음페이지</a>
			<%
				}
			%>
			
			<div class="modal fade" id="chatModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<!--��Ʈ��Ʈ�� CSS �߰��ϱ�-->
	<link rel="stylesheet" href="./css/bootstrapeval.min.css?ver=1">
	<!--Ŀ����CSS �߰��ϱ�-->
	<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="main.jsp">������ �� ����Ʈ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="main.jsp">����</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="bbs.jsp">�����Խ���</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="Chat.jsp">�ǽð�ä��</a>
				</li>
				<li class="nav-item active">
					<a class="nav-link" href="evaluate.jsp">������</a>
				</li>
				</ul>
					
					<%
					String userID = null;
					if(session.getAttribute("userID") == null){
					%>
				<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
						�����ϱ�
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<a class="dropdown-item" href="login.jsp">�α���</a>
						<a class="dropdown-item" href="join.jsp">ȸ������</a>
					</div>
				</li>
			</ul>
					<%
					}else {
					%>
					<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
						ȸ������
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
					<a class="dropdown-item" href="logoutAction.jsp">�α׾ƿ�</a>
					</div>
				</li>
			</ul>

					<%	
					}
					%> 
			<!-- �˻����<form  action="evaluate.jsp" method="get" class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="������ �Է��ϼ���" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">�˻�</button>
			</form> -->
		</div>
	</nav>
	<section class="container">
		<form method="get" action="./evaluate.jsp" class="form-inline mt-3">
			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="��ü">��ü</option>
				<option value="����">����</option>
				<option value="����">����</option>
				<option value="��Ÿ">��Ÿ</option>
			</select>
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="������ �Է��ϼ���">
			<button type="submit" class="btn btn-primary mx-1 mt-2">�˻�</button>
			<a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">����ϱ�</a>
			<a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">�Ű�</a>
			
		</form>
	</section>
	<section>
	<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">��ǻ�Ͱ���&nbsp; <small>�Ѹ�</small></div>
				<div class="col-4 text-right">
					���� <span style="color: red;">A</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				���� ���� ���ǿ���.&nbsp;<small>(2023�� �����б�)</small>
			</h5>
			<p class="card-text">������ �߳��Ϳ�</p>
			<div class="row">
				<div class="col-9 text-left">
					���� <span style="color:red;">A</span>
					���̵� <span style="color:red;">A</span>
					���� <span style="color:red;">B</span>
					<span style="color:green;">(��õ: 15)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('��õ�Ͻðڽ��ϱ�?')" href="./likeAction.jsp?evaluationID=">��õ</a>
					<a onclick="return confirm('�����Ͻðڽ��ϱ�?')" href="./deleteAction.jsp?evaluationID=">����</a>
				</div>
			</div>
		</div>
	</div>
	<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">�����ͺ��̽�&nbsp; <small>��ġ</small></div>
				<div class="col-4 text-right">
					���� <span style="color: red;">C</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				������. &nbsp;<small>(2022�� �����б�)</small>
			</h5>
			<p class="card-text">������ �ȳ��Ϳ�</p>
			<div class="row">
				<div class="col-9 text-left">
					���� <span style="color:red;">C</span>
					���̵� <span style="color:red;">C</span>
					���� <span style="color:red;">B</span>
					<span style="color:green;">(��õ: 2)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('��õ�Ͻðڽ��ϱ�?')" href="./likeAction.jsp?evaluationID=">��õ</a>
					<a onclick="return confirm('�����Ͻðڽ��ϱ�?')" href="./deleteAction.jsp?evaluationID=">����</a>
				</div>
			</div>
		</div>
	</div>
	<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left">����������&nbsp; <small>��</small></div>
				<div class="col-4 text-right">
					���� <span style="color: red;">B</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				�׳ɱ׷�&nbsp;<small>(2021�� 2�б�)</small>
			</h5>
			<p class="card-text">�����׷�</p>
			<div class="row">
				<div class="col-9 text-left">
					���� <span style="color:red;">B</span>
					���̵� <span style="color:red;">B</span>
					���� <span style="color:red;">B</span>
					<span style="color:green;">(��õ: 7)</span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('��õ�Ͻðڽ��ϱ�?')" href="./likeAction.jsp?evaluationID=">��õ</a>
					<a onclick="return confirm('�����Ͻðڽ��ϱ�?')" href="./deleteAction.jsp?evaluationID=">����</a>
				</div>
			</div>
		</div>
	</div>
	</section>
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">�� ���</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./evaluationRegisterAction.jsp" method="post">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>���Ǹ�</label>
								<input type="text" name="lectureName" class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>������</label>
								<input type="text" name="professorName" class="form-control" maxlength="20">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-4">
							<label>��������</label>
							<select name="lectureYear" class="form-control">
								<option value="2018">2018</option>
								<option value="2019">2019</option>
								<option value="2020">2020</option>
								<option value="2021">2021</option>
								<option value="2022">2022</option>
								<option value="2023" selected>2023</option>
								<option value="2024">2024</option>
								<option value="2025">2025</option>
								<option value="2026">2026</option>
								<option value="2027">2027</option>
								<option value="2028">2028</option>
								<option value="2029">2029</option>
								<option value="2030">2030</option>
							</select>
						</div>
						<div class="form-group col-sm-4">
							<label>�����б�</label>
							<select name="semesterDivide" class="form-control">
								<option value="1�б�" selected>1�б�</option>
								<option value="�����б�">�����б�</option>
								<option value="2�б�">2�б�</option>
								<option value="�ܿ��б�">�ܿ��б�</option>
								</select>
							</div>
						<div class="form-group col-sm-4">
							<label>���Ǳ���</label>
							<select name="lectureDivide" class="form-control">
								<option value="����" selected>����</option>
								<option value="����">����</option>
								<option value="��Ÿ">��Ÿ</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label>����</label>
							<input type="text" name="evaluationTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>����</label>
							<textarea name="evaluationContent" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-3">
								<label>����</label>
								<select name="totalScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>����</label>
								<select name="creditScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>���̵�</label>
								<select name="comfortableScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>����</label>
								<select name="lectureScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">���</button>
							<button type="submit" class="btn btn-primary">����ϱ�</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">�Ű��ϱ�</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./reportAction.jsp" method="post">
					
						<div class="form-group">
							<label>�Ű�����</label>
							<input type="text" name="reportTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>�Ű�����</label>
							<textarea name="reportContent" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">���</button>
							<button type="submit" class="btn btn-danger">�Ű��ϱ�</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- <footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 2023 ������ All Rights Reserved.
	</footer> -->
	<!--�������� �ڹٽ�ũ��Ʈ �߰��ϱ�  -->
	<script src="./js/jquery.min.js"></script>
	<!--���� �ڹٽ�ũ��Ʈ �߰��ϱ�  -->
	<script src="./js/popper.min.js"></script>
	<!--��Ʈ��Ʈ�� �ڹٽ�ũ��Ʈ �߰��ϱ�  -->
	<script src="./js/bootstrapeval.min.js"></script>
	

</body>
</html>
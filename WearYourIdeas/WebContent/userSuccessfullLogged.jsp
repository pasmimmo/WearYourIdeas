<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CSSimport.jsp"%>
</head>
<body>
	<div><%@ include file="menu.jsp"%></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<img alt="Logo" src="media/glass-sheep.png" class="img-responsive">
				<h1>Bee-ee Your Self!!</h1>
			</div>
			<div class="col-md-9 blog">
				<h1>Pannello amministrativo</h1>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<%
							UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));
						%>
						Welcome
						<%=currentUser.getNome() + " " + currentUser.getCognome()%>

						<script>
							setTimeout("location.href ='index.jsp';", 1500);
						</script>
					</div>
					<div class="col-md-4"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div><%@ include file="footer.jsp"%></div>
</body>
</html>
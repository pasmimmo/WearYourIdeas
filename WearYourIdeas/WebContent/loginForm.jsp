<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ include file="CSSimport.jsp"%>
</head>
<body>
	<%@ include file="menu.jsp"%>
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
					<form name="login" action="LoginServlet">
						Nome Utente <br>
						<input type="text" name="un" class="form-control"><br> Password <br>
						<input type="password" name="pw" class="form-control"><br> <input type="submit"
							value="Invia" class="btn btn-success">
						<button type="button"
							onclick="location.href ='registerUserField.jsp';" class="btn btn-warning">Registrati</button>
					</form>
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
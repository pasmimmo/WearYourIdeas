<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ include file="CSSimport.jsp"%>
</head>
<body>
<%
	UserBean user = null;
	try {
		user = (UserBean) session.getAttribute("currentSessionUser");
	} catch (NullPointerException n) {
	}
	if (user != null) {
%>
	<%@ include file="menu.jsp"%>
	<div class="container">
	<div class="row">
		<div class="col-md-3">
			<img alt="Logo" src="media/glass-sheep.png" class="img-responsive">
			<h1>Bee-ee Your Self!!</h1>
		</div>
		<div class="col-md-9 blog">
			<h1>Inserisci un nuovo utente:</h1>
			<div class="row">
				<form action="registerServlet">
					<div id="error"
						style="border-style: solid; border-color: red; display: none" class="alert alert-danger"></div>
					<div class="col-md-4">
						Username:<br> <input type="text" name="usname" value=""
							required class="form-control"><br> 
							Nome:<br> <input type="text"
							name="nome" value="" required onblur="validateForm(this.value, this.name)" class="form-control"><br>
					</div>
					<div class="col-md-4">
						Password:<br> <input type="password" name="psw" value=""
							required  class="form-control"><br> Cognome:<br> <input type="text"
							name="cognome" value="" required
							onblur="validateForm(this.value)" class="form-control"><br> Codice
						Fiscale:<br> <input type="text" name="codf" value=""
							maxlength="16" required class="form-control"><br> <br>
							<input type="submit" value="ok" class="btn btn-success"> <input type="reset" class="btn btn-warning">
					</div>
					<div class="col-md-4">
						Indirizzo eMail:<br> <input type="email" name="mail" value=""
							required onblur="" class="form-control"><br>
						Indirizzo:<br> <input type="text" name="indirizzo" value=""
							required class="form-control"><br>
					</div>
				</form>
			</div>
		</div>
		</div>
	</div>
	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div><%@ include file="footer.jsp"%></div>
	<%
		} else {
	%>
	<script>
		alert("Non Sei Autorizzato ad accedere a questa pagina!\n Sarai rediretto alla HomePage");
		setTimeout("location.href ='index.jsp';", 0);
	</script>
	<%
		}
	%>
</body>
</html>
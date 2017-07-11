<%@page import="login.UserBean"%>
<%@page import="utils.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
	String username = null;
	try {
		username = ((UserBean) session.getAttribute("currentSessionUser")).getUsername();
	} catch (NullPointerException n) {
		//n.printStackTrace();
	}
	ArrayList<MenuItem> urlMenu = new ArrayList<MenuItem>();
	urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("Home"), "index.jsp"));
	urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("Week-Shirt"), "week.jsp"));
	urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("Make Yours"), "PaginaMagliette"));
	urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("About"), "about.jsp"));
	if (username != null) {
		urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("Gestione"), "GestioneProdotti.jsp"));
		urlMenu.add(urlMenu.size(),
				new MenuItem(StrUtil.capitalize("Registra Utente"), "registerUserField.jsp"));
		urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("LogOUT"), "userSucessfullUnlogged.jsp"));
	} else {
		urlMenu.add(urlMenu.size(), new MenuItem(StrUtil.capitalize("Login"), "loginForm.jsp"));
	}
%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<!-- Responsive Menu icon -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- <a class="navbar-brand" href="#"> <img src="media/glass-sheep.png" alt="band" width="35px">
		</a>-->
			<a href="index.jsp" class="btn" style="float: left; margin: 5px"><img
				alt="Logo" src="media/mini-logo.png" width="65px"></a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<%
					for (int i = 0; i < urlMenu.size(); i++) {
				%>
				<li><a title='<%=urlMenu.get(i).getDescription()%>'
					href='<%=urlMenu.get(i).getUrl()%>'> <%=urlMenu.get(i).getDescription()%></a></li>
				<%
					}
					if (username != null) {
						out.print(
								"<span class='glyphicon glyphicon-user' style='color:Green'><span style='color:Green;text-transform:capitalize'> Ciao, "
										+ username + "</span></span>");
					}
				%>
			</ul>
			<button type="button" class="btn btn-default"
				style="float: right; margin: 5px">
				<span class="glyphicon glyphicon-shopping-cart"
					onclick="location.href='PaginaOrdine'"></span>
			</button>
		</div>
	</nav>
</div>
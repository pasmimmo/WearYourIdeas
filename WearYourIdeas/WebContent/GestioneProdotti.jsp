<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	BeanProdotto product = (BeanProdotto) request.getAttribute("product");
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*,db.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="CSSimport.jsp"%>
<title>Amministrazione - Gestione Prodotti</title>
</head>
<%
	UserBean user = null;
	try {
		user = (UserBean) session.getAttribute("currentSessionUser");
	} catch (NullPointerException n) {
	}
	if (user != null) {
%>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="row blog">
			<h1>Elenco Prodotti:</h1>
			<a href="product"><span
				class="glyphicon glyphicon-open-file btn btn-primary"
				title="Carica Archivio"></span></a>
			<table class="table table-striped table-bordered">
				<tr class="info">
					<th>Id <a href="product?sort=idprodotti"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Tipo <a href="product?sort=tipo"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Nome <a href="product?sort=nome"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Colore <a href="product?sort=colore"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Taglia <a href="product?sort=taglia"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Giacenza <a href="product?sort=quantita"><span
							class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
					<th>Operazioni</th>
				</tr>
				<%
					if (products != null && products.size() != 0) {
							Iterator<?> it = products.iterator();
							while (it.hasNext()) {
								BeanProdotto bean = (BeanProdotto) it.next();
				%>
				<tr>
					<td>#<%=bean.getIdprod()%></td>
					<td><%=bean.getTipo()%></td>
					<td><%=bean.getNome()%></td>
					<td><%=bean.getColore()%></td>
					<td><%=bean.getTaglia()%></td>
					<td><%=bean.getQuantita()%></td>
					<td><span class="glyphicon glyphicon-info-sign"
						aria-hidden="true"></span><a
						href="product?action=read&id=<%=bean.getIdprod()%>"> Dettagli</a><br>
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span><a
						href="product?action=delete&id=<%=bean.getIdprod()%>">
							Cancella</a></td>

				</tr>
				<%
					}
						} else {
				%>
				<tr>
					<td colspan="6">Nessun Prodotto caricato!</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
		<div class="col-md-12">
			<div class="col-md-6">
				<h2 style="text-align: center">Dettagli:</h2>
				<%
					if (product != null) {
				%>
				<table class="table table-hover">
					<tr class="info">
						<th>Codice</th>
						<th>Nome</th>
						<th>Descrizione</th>
						<th>Quantita</th>
						<th>Prezzo</th>
					</tr>
					<tr>
						<td>#<%=product.getIdprod()%></td>
						<td><%=product.getNome()%></td>
						<td><%=product.getDescrizione()%></td>
						<td><%=product.getQuantita()%></td>
						<td><%=product.getPrezzo()%></td>
					</tr>
				</table>
				<%
					}
				%>
			</div>
			<div class="col-md-6">
				<h2 style="text-align: center">Inserisci un articolo:</h2>
				<form action="product" method="post" id="form-id">
					<input type="hidden" name="action" value="insert"> <br>
					<div class="col-md-12">

						<div class="col-md-4">
							<div class="form-group">
								<label for="name">Tipo:</label> <input name="type" type="text"
									maxlength="20" required placeholder="tipo prodotto"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="color">Colore:</label> <input name="color"
									type="text" maxlength="20" required
									placeholder="colore prodotto" class="form-control">
							</div>
							<div class="form-group">
								<label for="quantity">Quantita:</label> <input name="quantity"
									type="number" min="1" value="1" required class="form-control">
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label for="name">Nome:</label> <input name="name" type="text"
									maxlength="20" required placeholder="nome prodotto"
									class="form-control">
							</div>
							<div class="form-group">
								<label for="price">Prezzo:</label> <input name="price"
									type="number" step="0.01" required class="form-control">
							</div>
							<div class="form-group">
								<label for="size">Taglia:</label> <input name="size" type="text"
									maxlength="20" required placeholder="taglia"
									class="form-control">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="id">ID Prodotto:</label> <input name="id"
									type="number" min="0" value="0" required class="form-control">
							</div>
							<div class="form-group">
								<label for="description">Descrizione:</label>
								<textarea name="description" maxlength="100" rows="3" required
									placeholder="Scrivi una descrizione qui (max 100 carateri)"
									class="form-control"></textarea>
							</div>
						</div>
					</div>
					<p style="margin-left: 35%; display: block;">
						<input type="submit" value="Inserisci" class="btn btn-success">
						<input type="reset" value="Azzera campi" class="btn btn-warning">
				</form>
			</div>
		</div>
	</div>
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
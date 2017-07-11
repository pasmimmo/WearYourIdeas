<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap Starter Template</title>
<!-- Fogli di stile -->
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/stili-custom.css" rel="stylesheet" media="screen">
<!-- Modernizr -->
<script src="js/modernizr.custom.js"></script>
<!-- respond.js per IE8 -->
<!--[if lt IE 9]>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<div><%@ include file="menu.jsp"%></div>
	<div class="col-md-4">
		<p>
			<img
				src="https://pbs.twimg.com/profile_images/499659576501755904/jfcCSs-9.png"
				width="250px"> Bee Different
		</p>
	</div>
	<div class="col-md-6">
		<h1>Percentuale di progetto svolto</h1>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active"
				role="progressbar" aria-valuenow="25" aria-valuemin="0"
				aria-valuemax="100" style="width: 25%">
				<span class="sr-only"></span> 25%
			</div>
		</div>
	</div>


	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<div><%@ include file="footer.jsp"%></div>
</body>
</html>
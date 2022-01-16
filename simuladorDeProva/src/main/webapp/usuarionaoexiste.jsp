<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*,br.com.simuladorDeProva.entity.*,br.com.simuladorDeProva.controller.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal Faculdade SP</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="bg-dark p-5 text-white text-center">
		<h1>Portal Faculdade SP</h1>
	</div>
	<div class="container">
		<h2 class="text-center pt-5">Ops...</h2>

		<div class="row mt-5">
			<h3>${invalido}</h3>
			<br>
			<div class="col-md-3 mt-4">
				<a href="index.jsp"><button type="submit" class="btn btn-danger float-right">Voltar para o início</button></a>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>

</html>
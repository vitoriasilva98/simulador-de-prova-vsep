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
		<h3 class="text-center pt-5">Boa Prova!</h3>

		<div class="row mt-5">
			<form method="post" action="GabaritoController">
				<div class="col-md-6 container">
					<div class="card">
						<div class="card-body">

							<h4 class="card-title text-center">Prova Trimestral</h4>

								<input type="hidden" name="idAluno" value="${idAluno}"> 
								
								<input type="hidden" name="idProva" value="${idProva}">
								
							<div class="col-md-16 mt-4 container">
								<%
								List<Questao> listaquestao = (List<Questao>) session.getAttribute("listaquestao");
								%>

								<%
								for (int i = 0; i < listaquestao.size(); i++) {
									out.print("<h5> " + (i + 1) + ". " + listaquestao.get(i).getPergunta() + "</h5><br>");

									out.print("<div class='form-check'>" + "<input class='form-check-input' type='radio' name='alternativa" + i + "'"
									+ "id='alternativaA' value='A' required> <label" + "class='form-check-label' for='alternativaA'> A. "
									+ listaquestao.get(i).getAlternativaA() + "</label>" + "</div>");

									out.print("<div class='form-check'>" + "<input class='form-check-input' type='radio' name='alternativa" + i + "'"
									+ "id='alternativaB' value='B' required> <label" + "class='form-check-label' for='alternativaB'> B. "
									+ listaquestao.get(i).getAlternativaB() + "</label>" + "</div>");

									out.print("<div class='form-check'>" + "<input class='form-check-input' type='radio' name='alternativa" + i + "'"
									+ "id='alternativaC' value='C' required> <label" + "class='form-check-label' for='alternativaC'> C. "
									+ listaquestao.get(i).getAlternativaC() + "</label>" + "</div>");

									out.print("<div class='form-check'>" + "<input class='form-check-input' type='radio' name='alternativa" + i + "'"
									+ "id='alternativaD' value='D' required> <label" + "class='form-check-label' for='alternativaD'> D. "
									+ listaquestao.get(i).getAlternativaD() + "</label>" + "</div><br>");

								}
								%>
								
							</div>
							<div class="col-md-3 mt-4">
								<button type="submit" class="btn btn-danger" value="Enviar">Finalizar
									Prova</button>
							</div>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>

</html>
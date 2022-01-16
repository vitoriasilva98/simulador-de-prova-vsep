<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.simuladorDeProva.persistence.*"%>
<%@ page import="br.com.simuladorDeProva.controller.*"%>
<%@ page import="br.com.simuladorDeProva.entity.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal Faculdade SP</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
.input-group-text {
	height: 40px;
}

input {
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="bg-dark p-5 text-white text-center">
		<h1>Portal Faculdade SP</h1>
	</div>
	<div class="container">
		<h3 class="text-center pt-5">Resultado</h3>

		<div class="row mt-5">
			<div class="col-md-5 container">
				<div class="card">
					<div class="card-body">

						<div class="input-group form-group pt-3">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></i></span>
							</div>
							<input type="text" name="nomeAluno" value="${nomeAluno}"
								class="form-control" disabled>
						</div>

						<div class="input-group form-group pt-3">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="fas fa-book-open"></i></span>
							</div>
							<input type="text" name="disciplina" value="${disciplina}"
								class="form-control text-primary" disabled>
						</div>

						<div class="input-group form-group pt-3">
							<div class="input-group-prepend">
								<span class="input-group-text"><i
									class="far fa-clipboard"></i></span>
							</div>
							<input type="text" name="notaObtida" value="Nota: ${nota}"
								class="form-control" disabled>
						</div>

						<div class="input-group form-group pt-3">
							<input type="text" name="notaObtida" value="${result}"
								class="form-control" disabled>
						</div>

					</div>
				</div>
			</div>

		</div>

		<div class="container mt-5">
			<table class="table table-bordered table-striped table-hover">
				<thead class="text-center bg-dark text-white">
					<tr>
						<th>Questão</th>
						<th>Pontuação</th>
						<th>Alternativa Escolhida</th>
						<th>Alternativa Correta</th>
					</tr>
				</thead>
				<tbody class="text-center">

					<%
					List<AlunoProvaQuestao> gabarito = (List<AlunoProvaQuestao>) session.getAttribute("gabarito");
					List<Questao> alternativaCorreta = (List<Questao>) session.getAttribute("alternativaCorreta");

					for (Integer i = 0; i < gabarito.size(); i++) {
					%>
					<tr>
						<td>
							<%
							out.print(i + 1);
							%>
						</td>
						<td>
							<%
							out.print(gabarito.get(i).getAcerto());
							%>
						</td>
						<td>
							<%
							out.print(gabarito.get(i).getAlternativaEscolhida());
							%>
						</td>
						<td>
							<%
							out.print(alternativaCorreta.get(i).getAlternativaCorreta());
							%>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

		<div class="col-md-3 mt-4 mb-4">
			<a href="index.jsp"><button type="submit"
					class="btn btn-warning float-right">Voltar para o início</button></a>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>

</html>
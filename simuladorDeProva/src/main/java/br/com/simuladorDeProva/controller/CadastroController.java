package br.com.simuladorDeProva.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.simuladorDeProva.dto.request.ProvaRequest;
import br.com.simuladorDeProva.entity.Aluno;
import br.com.simuladorDeProva.persistence.AlunoDao;

@WebServlet("/CadastroController")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String email = request.getParameter("email");
			Aluno existe = new AlunoDao().findByAluno(email);

			if (existe == null) {
				ProvaRequest requestobj = new ProvaRequest();
				requestobj.oAluno(request.getParameter("nomeAluno"), request.getParameter("email"));

				AlunoDao aludao = new AlunoDao();
				aludao.createAluno(requestobj);

				request.setAttribute("obj", requestobj);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "Usuário já existente! Email já cadastrado no sistema.");
				request.getRequestDispatcher("saidaerro.jsp").forward(request, response);
			}

		} catch (Exception ex) {

			request.setAttribute("msg", "Erro interno da Aplicação");
			request.getRequestDispatcher("saidaerro.jsp").forward(request, response);
		}
	}

}

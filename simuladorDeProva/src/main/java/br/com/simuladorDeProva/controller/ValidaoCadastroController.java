package br.com.simuladorDeProva.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.simuladorDeProva.entity.Aluno;
import br.com.simuladorDeProva.entity.Prova;
import br.com.simuladorDeProva.persistence.AlunoDao;
import br.com.simuladorDeProva.persistence.ProvaDao;

@WebServlet("/ValidaoCadastroController")
public class ValidaoCadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidaoCadastroController() {
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

			HttpSession session = request.getSession(true);

			if (existe != null) {
				List<Prova> listaprova = new ProvaDao().findSelectAllProva();
				session.setAttribute("listaprova", listaprova);
				response.sendRedirect("selecaoprova.jsp");
			} else {
				session.setAttribute("invalido", "Usuário inválido, nome ou email incorretos");
				response.sendRedirect("usuarionaoexiste.jsp");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

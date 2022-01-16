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
import br.com.simuladorDeProva.entity.AlunoProva;
import br.com.simuladorDeProva.entity.AlunoProvaQuestao;
import br.com.simuladorDeProva.entity.Prova;
import br.com.simuladorDeProva.entity.Questao;
import br.com.simuladorDeProva.persistence.AlunoDao;
import br.com.simuladorDeProva.persistence.AlunoProvaDao;
import br.com.simuladorDeProva.persistence.AlunoProvaQuestaoDao;
import br.com.simuladorDeProva.persistence.ProvaDao;
import br.com.simuladorDeProva.persistence.QuestaoDao;

@WebServlet("/GabaritoController")
public class GabaritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GabaritoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String alternativaEscolhida;

		Integer idAluno = Integer.valueOf(request.getParameter("idAluno"));
		Integer idProva = Integer.valueOf(request.getParameter("idProva"));

		try {
			QuestaoDao quedao = new QuestaoDao();
			Integer buscaNumeroDeQuestoes = quedao.findQuantidadeQuestoes(idProva);
			Integer comparacaoquestao;

			if (idProva.equals(15)) {
				comparacaoquestao = 1;
			} else {
				comparacaoquestao = 6;
			}

			for (int i = 0; i < buscaNumeroDeQuestoes; i++) {
				alternativaEscolhida = request.getParameter("alternativa" + i);

				if (alternativaEscolhida == "checked") {
					request.getParameter("A");
				} else if (alternativaEscolhida == "checked") {
					request.getParameter("B");
				} else if (alternativaEscolhida == "checked") {
					request.getParameter("C");
				} else if (alternativaEscolhida == "checked") {
					request.getParameter("D");
				}

				String buscaAlternativaCorreta = quedao.findAlternativaCorreta(idProva, comparacaoquestao);

				Integer acerto = 0;
				if (buscaAlternativaCorreta.equals(alternativaEscolhida)) {
					acerto = 1;
				}

				AlunoProvaQuestaoDao aluproquedao = new AlunoProvaQuestaoDao();
				Boolean registroGabaritoAluno = aluproquedao.createGabaritoAluno(idAluno, idProva, comparacaoquestao,
						acerto, alternativaEscolhida);

				acerto = 0;
				comparacaoquestao++;

			}

			AlunoProvaQuestaoDao aluproquedao = new AlunoProvaQuestaoDao();
			Integer pontuacao = aluproquedao.atualizarPontuacao(idAluno, idProva);
			Integer notaObtida = pontuacao * 2;

			AlunoProvaDao aluprodao = new AlunoProvaDao();
			aluprodao.updateNotaObtida(idAluno, idProva, notaObtida);

			telaGabarito(idAluno, idProva, request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void telaGabarito(Integer idAluno, Integer idProva, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<AlunoProvaQuestao> gabarito = new AlunoProvaQuestaoDao().mostrandoGabarito(idAluno, idProva);
			List<Questao> alternativaCorreta = new QuestaoDao().mostrandoAlternativaCorreta(idProva);

			Aluno nomeAluno = new AlunoDao().findNomeAluno(idAluno);
			Prova disciplina = new ProvaDao().findProva(idProva);
			AlunoProva nota = new AlunoProvaDao().findNota(idAluno, idProva);

			HttpSession session = request.getSession(true);
			session.setAttribute("nomeAluno", nomeAluno);
			session.setAttribute("disciplina", disciplina);
			session.setAttribute("nota", nota);

			String notaProva = String.valueOf(nota);
			Double notaP = Double.valueOf(notaProva);

			String result = null;

			if (notaP >= 6) {
				result = "Parabéns! Você está acima da média!";
			} else {
				result = "Precisa estudar mais! Você está abaixo da média!";
			}

			session.setAttribute("result", result);
			session.setAttribute("gabarito", gabarito);
			session.setAttribute("alternativaCorreta", alternativaCorreta);
			response.sendRedirect("resultado.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

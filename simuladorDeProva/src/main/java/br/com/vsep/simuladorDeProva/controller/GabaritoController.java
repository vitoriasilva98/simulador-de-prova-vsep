package br.com.vsep.simuladorDeProva.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.entity.AlunoProva;
import br.com.vsep.simuladorDeProva.entity.AlunoProvaQuestao;
import br.com.vsep.simuladorDeProva.entity.Prova;
import br.com.vsep.simuladorDeProva.entity.Questao;
import br.com.vsep.simuladorDeProva.persistence.AlunoDao;
import br.com.vsep.simuladorDeProva.persistence.AlunoProvaDao;
import br.com.vsep.simuladorDeProva.persistence.AlunoProvaQuestaoDao;
import br.com.vsep.simuladorDeProva.persistence.ProvaDao;
import br.com.vsep.simuladorDeProva.persistence.QuestaoDao;

@Controller
public class GabaritoController {

	@PostMapping("GabaritoController")
	public ModelAndView gabarito(@RequestParam(value = "idAluno", required = false) Integer idAluno,
			@RequestParam(value = "idProva", required = false) Integer idProva, Model model,
			HttpServletRequest request) throws ServletException, IOException {

		String alternativaEscolhida;

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

				String buscaAlternativaCorreta = quedao.findAlternativaCorreta(idProva, comparacaoquestao);

				Integer acerto = 0;
				if (buscaAlternativaCorreta.equals(alternativaEscolhida)) {
					acerto = 1;
				}

				AlunoProvaQuestaoDao aluproquedao = new AlunoProvaQuestaoDao();
				aluproquedao.createGabaritoAluno(idAluno, idProva, comparacaoquestao, acerto, alternativaEscolhida);

				acerto = 0;
				comparacaoquestao++;

			}

			AlunoProvaQuestaoDao aluproquedao = new AlunoProvaQuestaoDao();
			Integer pontuacao = aluproquedao.atualizarPontuacao(idAluno, idProva);
			Integer notaObtida = pontuacao * 2;

			AlunoProvaDao aluprodao = new AlunoProvaDao();
			aluprodao.updateNotaObtida(idAluno, idProva, notaObtida);
			
			telaGabarito(idAluno, idProva, model);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return new ModelAndView("resultado");
	}

	public void telaGabarito(Integer idAluno, Integer idProva, Model model) {

		try {
			List<AlunoProvaQuestao> gabarito = new AlunoProvaQuestaoDao().mostrandoGabarito(idAluno, idProva);

			Aluno nomeAluno = new AlunoDao().findNomeAluno(idAluno);
			Prova disciplina = new ProvaDao().findProva(idProva);
			AlunoProva nota = new AlunoProvaDao().findNota(idAluno, idProva);

			model.addAttribute("nomeAluno", nomeAluno);
			model.addAttribute("disciplina", disciplina);
			model.addAttribute("nota", nota);

			String notaProva = String.valueOf(nota);
			Double notaP = Double.valueOf(notaProva);

			String result = null;

			if (notaP >= 6) {
				result = "Parabéns! Você está acima da média!";
			} else {
				result = "Precisa estudar mais! Você está abaixo da média!";
			}

			model.addAttribute("result", result);
			model.addAttribute("gabarito", gabarito);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

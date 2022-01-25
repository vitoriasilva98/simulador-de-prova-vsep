package br.com.vsep.simuladorDeProva.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.entity.Questao;
import br.com.vsep.simuladorDeProva.persistence.AlunoDao;
import br.com.vsep.simuladorDeProva.persistence.AlunoProvaDao;
import br.com.vsep.simuladorDeProva.persistence.QuestaoDao;

@Controller
public class ProvaController {

	@PostMapping("ProvaController")
	public ModelAndView selecaoDaProva(@RequestParam(value = "email", required = false) String emailAluno,
			@RequestParam(value = "idProva", required = false) Integer idProva, Model model) {

		String paginaDirecionada = "";

		try {

			AlunoDao aludao = new AlunoDao();
			Aluno busaId = aludao.findIdAluno(emailAluno);
			AlunoProvaDao aluprodao = new AlunoProvaDao();

			if (busaId != null) {

				Integer idAluno = busaId.getIdAluno();

				if (idProva != null) {

					Boolean alunoNaoFezAhProva = aluprodao.consultaDeAvaliacaoDeAluno(idAluno, idProva);

					if (alunoNaoFezAhProva == true) {

						aluprodao.createAlunoProvaDao(idAluno, idProva);
						List<Questao> listaquestao = new QuestaoDao().findSelectAllQuestao(idProva);

						model.addAttribute("idAluno", idAluno);
						model.addAttribute("idProva", idProva);
						model.addAttribute("listaquestao", listaquestao);
						paginaDirecionada = "prova";
					} else {

						GabaritoController gc = new GabaritoController();
						gc.telaGabarito(idAluno, idProva, model);
						paginaDirecionada = "resultado";
					}

				} else {
					model.addAttribute("msg", "Prova inexistente");
					paginaDirecionada = "saidaerro";
				}

			} else {
				model.addAttribute("msg", "Usuário inválido, email incorreto");
				paginaDirecionada = "saidaerro";
			}

		} catch (Exception ex) {

			model.addAttribute("msg", "Erro interno da Aplicação");
			paginaDirecionada = "saidaerro";
		}

		return new ModelAndView(paginaDirecionada);
	}

}

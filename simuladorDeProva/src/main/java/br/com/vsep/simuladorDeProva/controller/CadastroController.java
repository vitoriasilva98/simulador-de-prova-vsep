package br.com.vsep.simuladorDeProva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vsep.simuladorDeProva.dto.request.ProvaRequest;
import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.persistence.AlunoDao;

@Controller
public class CadastroController {

	@PostMapping("CadastroController")
	public ModelAndView criandoCadastro(@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "nomeAluno", required = false) String nomeAluno, Model model) {

		String paginaDirecionada = "";

		try {

			Aluno existe = new AlunoDao().findByAluno(email);

			if (existe == null) {
				ProvaRequest requestobj = new ProvaRequest();
				requestobj.oAluno(nomeAluno, email);

				AlunoDao aludao = new AlunoDao();
				aludao.createAluno(requestobj);

				model.addAttribute("obj", requestobj);
				paginaDirecionada = "index";
			} else {
				model.addAttribute("msg", "Usuário já existente! Email já cadastrado no sistema.");
				paginaDirecionada = "saidaerro";
			}

		} catch (Exception ex) {

			model.addAttribute("msg", "Erro interno da Aplicação");
			paginaDirecionada = "saidaerro";
		}

		return new ModelAndView(paginaDirecionada);
	}

}

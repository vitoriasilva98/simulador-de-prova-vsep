package br.com.vsep.simuladorDeProva.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.entity.Prova;
import br.com.vsep.simuladorDeProva.persistence.AlunoDao;
import br.com.vsep.simuladorDeProva.persistence.ProvaDao;

@Controller
public class ValidacaoCadastroController {

	@PostMapping("ValidacaoCadastroController")
	public ModelAndView validacaoDeCadastro(@RequestParam(value = "email", required = false) String email,
			Model model) {

		String paginaDirecionada = "";

		try {
			Aluno existe = new AlunoDao().findByAluno(email);

			if (existe != null) {
				List<Prova> listaprova = new ProvaDao().findSelectAllProva();
				model.addAttribute("listaprova", listaprova);
				paginaDirecionada = "selecaoprova";
			} else {
				model.addAttribute("msg", "Usuário inválido, nome ou email incorretos");
				paginaDirecionada = "saidaerro";
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ModelAndView(paginaDirecionada);
	}

}

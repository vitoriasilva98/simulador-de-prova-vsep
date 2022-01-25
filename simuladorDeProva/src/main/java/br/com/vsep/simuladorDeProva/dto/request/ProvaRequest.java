package br.com.vsep.simuladorDeProva.dto.request;

import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.entity.Prova;
import br.com.vsep.simuladorDeProva.entity.Questao;

public class ProvaRequest {

	private Aluno aluno;
	private Prova prova;
	private Questao questao;

	public ProvaRequest() {
		this.aluno = new Aluno();
		this.prova = new Prova();
		this.questao = new Questao();
	}

	@Override
	public String toString() {
		return "ProvaRequest [aluno=" + aluno + ", prova=" + prova + ", questao=" + questao + "]";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public void oAluno(String nomeAluno, String email) {
		aluno.setNomeAluno(nomeAluno);
		aluno.setEmail(email);
	}

	public void aAlunoProva(Integer idProva, String email) {
		prova.setIdProva(idProva);
		aluno.setEmail(email);
	}

}

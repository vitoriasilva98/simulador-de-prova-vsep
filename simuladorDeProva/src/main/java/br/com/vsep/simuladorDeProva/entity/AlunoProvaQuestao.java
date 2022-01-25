package br.com.vsep.simuladorDeProva.entity;

import java.io.Serializable;
import java.util.List;

public class AlunoProvaQuestao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private Prova prova;
	private Questao questao;
	private Integer acerto;
	private String alternativaEscolhida;
	private String alternativaCorreta;

	private List<Aluno> alunos;
	private List<Prova> provas;
	private List<Questao> questoes;

	public AlunoProvaQuestao() {

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

	public Integer getAcerto() {
		return acerto;
	}

	public void setAcerto(Integer acerto) {
		this.acerto = acerto;
	}

	public String getAlternativaEscolhida() {
		return alternativaEscolhida;
	}

	public void setAlternativaEscolhida(String alternativaEscolhida) {
		this.alternativaEscolhida = alternativaEscolhida;
	}

	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

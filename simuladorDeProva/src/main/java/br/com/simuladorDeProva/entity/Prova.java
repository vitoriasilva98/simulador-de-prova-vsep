package br.com.simuladorDeProva.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prova implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProva;
	private String disciplina;
	private Double notaObtida;

	private List<Questao> questoes;

	public Prova() {

	}

	public Prova(Integer idProva) {
		this.idProva = idProva;
	}

	public Prova(Integer idProva, String disciplina) {
		super();
		this.idProva = idProva;
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Prova: " + disciplina;
	}

	public Integer getIdProva() {
		return idProva;
	}

	public void setIdProva(Integer idProva) {
		this.idProva = idProva;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(Double notaObtida) {
		this.notaObtida = notaObtida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public void add(Questao questao) {
		if (this.questoes == null) {
			this.questoes = new ArrayList<Questao>();
		}
		this.questoes.add(questao);
	}

}

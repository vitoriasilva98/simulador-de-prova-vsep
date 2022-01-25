package br.com.vsep.simuladorDeProva.entity;

public class ProvaQuestao {

	private Prova prova;
	private Questao questao;

	public ProvaQuestao() {

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

}

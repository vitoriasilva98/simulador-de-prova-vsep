package br.com.vsep.simuladorDeProva.entity;

import java.io.Serializable;
import java.util.List;

public class Questao implements Serializable, Comparable<Questao> {

	private static final long serialVersionUID = 1L;
	private Integer idQuestao;
	private String pergunta;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private String alternativaCorreta;
	private String acerto;

	private List<Prova> provas;

	public Questao() {

	}

	public Questao(Integer idQuestao) {
		super();
		this.idQuestao = idQuestao;
	}

	public Questao(Integer idQuestao, String pergunta, String alternativaA, String alternativaB, String alternativaC,
			String alternativaD, String alternativaCorreta, String acerto) {
		super();
		this.idQuestao = idQuestao;
		this.pergunta = pergunta;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaCorreta = alternativaCorreta;
		this.acerto = acerto;
	}

	public Questao(Integer idQuestao, String pergunta, String alternativaA, String alternativaB, String alternativaC,
			String alternativaD, String alternativaCorreta, String acerto, List<Prova> provas) {
		super();
		this.idQuestao = idQuestao;
		this.pergunta = pergunta;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaCorreta = alternativaCorreta;
		this.acerto = acerto;
		this.provas = provas;
	}

	public Integer getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public String getAcerto() {
		return acerto;
	}

	public void setAcerto(String acerto) {
		this.acerto = acerto;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(Questao q) {

		return this.getIdQuestao().compareTo(q.getIdQuestao());
	}

}

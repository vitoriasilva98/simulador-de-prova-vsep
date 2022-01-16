package br.com.simuladorDeProva.entity;

public class Aluno {

	private Integer idAluno;
	private String nomeAluno;
	private String email;
	private Prova prova;

	public Aluno() {

	}

	public Aluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Aluno(Integer idAluno, String nomeAluno, String email, Prova prova) {
		super();
		this.idAluno = idAluno;
		this.nomeAluno = nomeAluno;
		this.email = email;
		this.prova = prova;
	}

	@Override
	public String toString() {
		return "Aluno: " + nomeAluno;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

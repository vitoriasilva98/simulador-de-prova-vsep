package br.com.simuladorDeProva.entity;

public class AlunoProva {

	private Aluno aluno;
	private Prova prova;
	private double notaObtida;

	public AlunoProva() {

	}

	@Override
	public String toString() {
		return "" + notaObtida;
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

	public double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(double notaObtida) {
		this.notaObtida = notaObtida;
	}

}

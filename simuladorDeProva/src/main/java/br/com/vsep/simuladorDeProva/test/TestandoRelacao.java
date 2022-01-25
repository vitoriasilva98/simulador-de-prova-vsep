package br.com.vsep.simuladorDeProva.test;

import br.com.vsep.simuladorDeProva.entity.Aluno;
import br.com.vsep.simuladorDeProva.entity.Prova;
import br.com.vsep.simuladorDeProva.entity.Questao;

public class TestandoRelacao {

	public static void main(String[] args) {
		

		Prova p1 = new Prova(2, "Matem�tica: Matem�tica B�sica");
		Prova p2 = new Prova(3, "Portugu�s: Literatura");

		Questao q1 = new Questao(1, "Quanto � 8 vezes 9 divido por 3 mais 1?",
								"25", "23", "17", "29","A", "0" );
		Questao q2 = new Questao(2, "Qual � potencia��o de: base 5 e expoente 5?",
				"3100", "2575", "3025", "3125", "D", "1");
		
		Questao q3 = new Questao(3, "Quem escreveu o livro Moreninha?",
				"Jos� de Alencar", "Joaquim Manuel de Macedo", 
				"�lvares de Azevedo", "Castro Alves", "1", "B");
		
		
		Aluno a1 = new Aluno(22, "Jos� Lucas", "joselucas@gmail.com", p2);
		Aluno a2 = new Aluno(23, "Jurema Araujo", "juremaaraujo@gmail.com", p1);
		
		p1.add(q1);
		p1.add(q2);
		p2.add(q3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("\n" + p1.getQuestoes());
		System.out.println(p2.getQuestoes());
		System.out.println(a1);
		System.out.println("\n" + a1.getProva());
		System.out.println(a2);
		System.out.println("\n" + a2.getProva());
	
	
	}
}

package br.com.simuladorDeProva.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.simuladorDeProva.entity.Questao;

public class QuestaoDao extends Dao {

	public List<Questao> findSelectAllQuestao(Integer idProva) throws Exception {
		open();
		stmt = con.prepareStatement("select idQuestao, pergunta,"
				+ "alternativaA, alternativaB, alternativaC, alternativaD" + " from Questao where fkProva=?;");
		stmt.setInt(1, idProva);
		rs = stmt.executeQuery();
		List<Questao> listaquestao = new ArrayList<>();
		while (rs.next()) {
			Questao q = new Questao();
			q.setIdQuestao(rs.getInt(1));
			q.setPergunta(rs.getString(2));
			q.setAlternativaA(rs.getString(3));
			q.setAlternativaB(rs.getString(4));
			q.setAlternativaC(rs.getString(5));
			q.setAlternativaD(rs.getString(6));
			listaquestao.add(q);
		}

		close();
		return listaquestao;
	}

	public Integer findQuantidadeQuestoes(Integer idProva) throws Exception {
		open();
		Integer numero = null;
		stmt = con.prepareStatement("select count(idQuestao) as quantidade from Questao " + "where fkProva=?;");
		stmt.setInt(1, idProva);
		rs = stmt.executeQuery();

		if (rs.next()) {
			numero = rs.getInt("quantidade");
		}
		close();
		return numero;
	}

	public String findAlternativaCorreta(Integer idProva, Integer comparacaoquestao) throws Exception {
		open();
		String alternativaCorreta = null;
		stmt = con.prepareStatement("select alternativaCorreta from Questao where fkProva=? and idQuestao=?;");
		stmt.setInt(1, idProva);
		stmt.setInt(2, comparacaoquestao);
		rs = stmt.executeQuery();

		if (rs.next()) {

			alternativaCorreta = rs.getString(1);
		}
		close();
		return alternativaCorreta;
	}

	public List<Questao> mostrandoAlternativaCorreta(Integer idProva) throws Exception {
		open();
		stmt = con.prepareStatement("select * from questao where fkProva=?;");
		stmt.setInt(1, idProva);
		rs = stmt.executeQuery();

		List<Questao> alternaticaCorreta = new ArrayList<>();
		while (rs.next()) {
			Questao ac = new Questao();
			ac.setAlternativaCorreta(rs.getString(8));
			alternaticaCorreta.add(ac);
		}
		close();
		return alternaticaCorreta;
	}
}

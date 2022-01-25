package br.com.vsep.simuladorDeProva.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.vsep.simuladorDeProva.entity.AlunoProvaQuestao;
import br.com.vsep.simuladorDeProva.entity.Questao;

public class AlunoProvaQuestaoDao extends Dao {

	public Boolean createGabaritoAluno(Integer idAluno, Integer idProva, Integer comparacaoquestao, Integer acerto,
			String alternativaEscolhida) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("insert into AlunoProvaQuestao (fkAluno, fkProva, fkQuestao, acerto, alternativaEscolhida) "
					+ "values(?, ?, ?, ?, ?);",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idAluno);
			stmt.setInt(2, idProva);
			stmt.setInt(3, comparacaoquestao);
			stmt.setInt(4, acerto);
			stmt.setString(5, alternativaEscolhida);
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
			return true;
		} catch (Exception ex) {
			con.rollback();
			return false;
		} finally {
			close();
		}
	}

	public Integer atualizarPontuacao(Integer idAluno, Integer idProva) throws Exception {
		open();
		Integer pontuacao = null;
		stmt = con.prepareStatement(
				"select sum(acerto) as pontuacao from alunoprovaquestao where fkAluno =? and fkProva =?;");
		stmt.setInt(1, idAluno);
		stmt.setInt(2, idProva);
		rs = stmt.executeQuery();

		if (rs.next()) {
			pontuacao = rs.getInt(1);
		}
		close();
		return pontuacao;
	}

	public List<AlunoProvaQuestao> mostrandoGabarito(Integer idAluno, Integer idProva) throws Exception {
		open();
		stmt = con.prepareStatement(
				"select apq.acerto, apq.alternativaEscolhida, q.alternativaCorreta"
				+ "	from alunoprovaquestao as apq inner join questao as q on q.idQuestao = apq.fkQuestao"
				+ "	where apq.fkAluno= ? and q.fkProva= ? ORDER BY fkQuestao ASC LIMIT 5;");
		stmt.setInt(1, idAluno);
		stmt.setInt(2, idProva);
		rs = stmt.executeQuery();

		List<AlunoProvaQuestao> gabarito = new ArrayList<AlunoProvaQuestao>();
		while (rs.next()) {
			AlunoProvaQuestao alq = new AlunoProvaQuestao();
			alq.setAcerto(rs.getInt(1));
			alq.setAlternativaEscolhida(rs.getString(2));
			alq.setAlternativaCorreta(rs.getString(3));
			gabarito.add(alq);
		}

		close();
		return gabarito;
	}
}

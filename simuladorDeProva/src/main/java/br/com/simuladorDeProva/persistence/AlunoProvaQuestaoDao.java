package br.com.simuladorDeProva.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.simuladorDeProva.entity.AlunoProvaQuestao;

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
				"select * from alunoprovaquestao where fkAluno= ? and fkProva= ? ORDER BY fkQuestao ASC LIMIT 5;");
		stmt.setInt(1, idAluno);
		stmt.setInt(2, idProva);
		rs = stmt.executeQuery();

		List<AlunoProvaQuestao> gabarito = new ArrayList<>();
		while (rs.next()) {
			AlunoProvaQuestao alq = new AlunoProvaQuestao();
			alq.setAcerto(rs.getInt(4));
			alq.setAlternativaEscolhida(rs.getString(5));
			gabarito.add(alq);
		}

		close();
		return gabarito;
	}
}

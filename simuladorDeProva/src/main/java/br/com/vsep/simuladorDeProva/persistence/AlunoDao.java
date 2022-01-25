package br.com.vsep.simuladorDeProva.persistence;

import br.com.vsep.simuladorDeProva.dto.request.ProvaRequest;
import br.com.vsep.simuladorDeProva.entity.Aluno;

public class AlunoDao extends Dao {

	public Aluno findByAluno(String email) throws Exception {

		open();
		stmt = con.prepareStatement("select * from Aluno where email=?;");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		Aluno aluno = null;
		if (rs.next()) {
			aluno = new Aluno();
			aluno.setIdAluno(rs.getInt(1));
			aluno.setNomeAluno(rs.getString(2));
			aluno.setEmail(rs.getString(3));
		}
		close();
		return aluno;
	}

	public void createAluno(ProvaRequest pr) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("insert into Aluno (nomeAluno, email) values(?, ?)");
			stmt.setString(1, pr.getAluno().getNomeAluno());
			stmt.setString(2, pr.getAluno().getEmail());
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
		} catch (Exception ex) {
			con.rollback();
		} finally {
			close();
		}
	}

	public void updateAlunoProva(Integer idProva, String email) throws Exception {
		open();
		con.setAutoCommit(false);
		try {
			stmt = con.prepareStatement("update Aluno set fkProva= ? where email= ?;");
			stmt.setInt(1, idProva);
			stmt.setString(2, email);
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
		} catch (Exception ex) {
			con.rollback();
		} finally {
			close();
		}
	}

	public Aluno findIdAluno(String email) throws Exception {
		open();
		stmt = con.prepareStatement("select idAluno from Aluno where email=?;");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		Aluno numeroaluno = null;
		if (rs.next()) {
			numeroaluno = new Aluno();
			numeroaluno.setIdAluno(rs.getInt(1));
		}
		close();
		return numeroaluno;
	}

	public Aluno findNomeAluno(Integer idAluno) throws Exception {

		open();
		stmt = con.prepareStatement("select nomeAluno from Aluno where idAluno=?;");
		stmt.setInt(1, idAluno);
		rs = stmt.executeQuery();
		Aluno aluno = null;
		if (rs.next()) {
			aluno = new Aluno();
			aluno.setNomeAluno(rs.getString(1));
		}
		close();
		return aluno;
	}

}

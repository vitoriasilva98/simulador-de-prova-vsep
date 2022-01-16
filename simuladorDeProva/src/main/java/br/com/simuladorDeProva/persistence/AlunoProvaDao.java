package br.com.simuladorDeProva.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.simuladorDeProva.entity.Aluno;
import br.com.simuladorDeProva.entity.AlunoProva;
import br.com.simuladorDeProva.entity.Prova;

public class AlunoProvaDao extends Dao {

	public Boolean createAlunoProvaDao(Integer idAluno, Integer idProva) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("insert into AlunoProva (fkAluno, fkProva) values(?, ?);",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idAluno);
			stmt.setInt(2, idProva);
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

	public void updateNotaObtida(Integer idAluno, Integer idProva, Integer notaObtida) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("update AlunoProva set notaObtida = ? where fkAluno =? and fkProva=?;");

			stmt.setInt(1, notaObtida);
			stmt.setInt(2, idAluno);
			stmt.setInt(3, idProva);
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
		} catch (Exception ex) {
			con.rollback();
		} finally {
			close();
		}
	}

	public AlunoProva findNota(Integer idAluno, Integer idProva) throws Exception {

		open();
		stmt = con.prepareStatement("select notaObtida from AlunoProva where fkAluno=? and fkProva=?;");
		stmt.setInt(1, idAluno);
		stmt.setInt(2, idProva);
		rs = stmt.executeQuery();
		AlunoProva ap = null;
		if (rs.next()) {
			ap = new AlunoProva();
			ap.setNotaObtida(rs.getDouble(1));
		}
		close();
		return ap;
	}

	public Boolean consultaDeAvaliacaoDeAluno(Integer idAluno, Integer idProva) throws Exception {

		Boolean retorno = null;
		
        try {
        	open();
            stmt = con.prepareStatement("select * from AlunoProva where fkAluno=? and fkProva=?;");
    		stmt.setInt(1, idAluno);
    		stmt.setInt(2, idProva);
    		rs = stmt.executeQuery();
    		List<AlunoProva> list = new ArrayList<AlunoProva>();
    		if (rs.next()) {
    			AlunoProva ap = new AlunoProva();
    			ap.setAluno(new Aluno(rs.getInt(1)));
    			ap.setProva(new Prova(rs.getInt(2)));
    			list.add(ap);
    		}
    		close();

    		retorno = list.isEmpty();
            
        }catch (Exception e) {
			e.printStackTrace();
		}
        
        return retorno;
    }
}

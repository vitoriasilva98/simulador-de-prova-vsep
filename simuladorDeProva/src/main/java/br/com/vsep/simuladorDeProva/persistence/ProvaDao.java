package br.com.vsep.simuladorDeProva.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.vsep.simuladorDeProva.entity.Prova;

public class ProvaDao extends Dao {

	public List<Prova> findSelectAllProva() throws Exception {
		open();
		stmt = con.prepareStatement("select idProva, disciplina from Prova;");
		rs = stmt.executeQuery();
		List<Prova> listaprova = new ArrayList<>();
		while (rs.next()) {
			Prova p = new Prova();
			p.setIdProva(rs.getInt(1));
			p.setDisciplina(rs.getString(2));
			listaprova.add(p);
		}

		close();
		return listaprova;
	}

	public Prova findProva(Integer idProva) throws Exception {

		open();
		stmt = con.prepareStatement("select disciplina from Prova where idProva=?;");
		stmt.setInt(1, idProva);
		rs = stmt.executeQuery();
		Prova prova = null;
		if (rs.next()) {
			prova = new Prova();
			prova.setDisciplina(rs.getString(1));
		}
		close();
		return prova;
	}
}

package br.com.simuladorDeProva.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {

	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
//	Conexão com MySQL
//	public void open() throws Exception{
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bsimuladordeprova",
//				"root", "senha");
//	}
	
//	Conexão com Postgres
	public void open() throws Exception{
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simuladordeprova", "postgres", "senha");
	}
	
	public void close() throws Exception {
		con.close();
	}
}

package br.com.vsep.simuladorDeProva.persistence;

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
	public void open() throws Exception {
		Class.forName("org.postgresql.Driver");
//		con = DriverManager.getConnection(
//		"jdbc:postgresql://ec2-3-216-113-109.compute-1.amazonaws.com:5432/ddo2218lf7a6ov?user=ujhtxvkkftzjcv&password=7e44792a0214f21bc56adb2085ff69b1def6a08f8a387e26686c7ee586d04078");
		
//		con = DriverManager.getConnection(
//				"jdbc:postgresql://ec2-3-95-130-249.compute-1.amazonaws.com:5432/d74ibod5guakhu?user=bdgqgglkhyrgjl&password=009cf0a97680e3937ef52599a364159144714bd3adcd35bce5514d4200dc13f4");

		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simuladordeprova", "postgres", "stefanini123");
	}

	public void close() throws Exception {
		con.close();
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static ConnectionDB instancia;
	private Connection con;
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=mercadopoo";
	private String user = "root";
	private String senha = "";
	
	private ConnectionDB() {		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver carregado");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static ConnectionDB getInstancia() {
		if(instancia == null) {
			instancia = new ConnectionDB();
		}
		return instancia;
	}
	
	public Connection conectar() throws SQLException{
		if(con == null || con.isClosed()) {
			con = DriverManager.getConnection(url, user, senha);
			System.out.println("Conectou");	
		}else {
			System.out.println("Uma conexão já aberta será utilizada");
		}
		return con;	}
	
	public void desconectar() throws SQLException{
		if(!con.isClosed()) {
			this.con.close();
		}else {
			System.out.println("Nenhuma conexão pendente");
		}
	}
}


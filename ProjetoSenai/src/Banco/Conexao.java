package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String ip = "127.0.0.1";// o seu ip
	private String porta = "3307";
	private String usuario = "root";
	private String senha = "root";
	private String nomeBanco = "alunos";
	
	public Connection getConexao() {
		 Connection conexao = null;
		String url = "jdbc:mysql://"+ip+":"+porta+"/"+nomeBanco;
		 try {
			conexao = DriverManager.getConnection(url,usuario,senha);
			
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao conectar-se ao banco de dados");
		}
		 return conexao;
	}
	


	}
	


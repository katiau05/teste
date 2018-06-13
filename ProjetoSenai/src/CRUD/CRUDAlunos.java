package CRUD;

import java.security.KeyStore.ProtectionParameter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.SchemaOutputResolver;

import Banco.Conexao;

public class CRUDAlunos {
	
	Conexao c = new Conexao();

		public boolean novoAluno(String n,int i,String s,String e,String f) {
			String sql = "INSERT INTO alunos (nome,idade,sexo,email,fone) VALUES(?,?,?,?,?)";
			try {
				PreparedStatement stmt = c.getConexao().prepareStatement(sql);
				stmt.setString(1, n);
				stmt.setInt(2, i);
				stmt.setString(3, s);
				stmt.setString(4, e);
				stmt.setString(4, e);
				stmt.setString(5, f);
				stmt.execute();
				stmt.close();
				
				return true;
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				
				return false;
			}
			
		}
		
		public boolean removeAluno(int id){
			String sql ="DELETE FROM alunos WHERE idaluno=?";
			try {
				PreparedStatement stmt = c.getConexao().prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.execute();
				stmt.close();
				return true;
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
			
		}
		
		public boolean alterarAluno(int i,String s,String e,String f,int id) {
			String sql = "UPDATE alunos "
					+"SET idade=?,sexo=?,email=?,fone=?"
					+"WHERE idAluno = ?";
			try {
				PreparedStatement stmt = c.getConexao().prepareStatement(sql);
				stmt.setInt(1, i);
				stmt.setString(2, s);
				stmt.setString(3, e);
				stmt.setString(4, f);
				stmt.setInt(5, id);
				stmt.execute();
				stmt.close();
				return true;
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			
		}
		
		public ResultSet selecionaAlunos() {
			ResultSet tabela = null;
			String sql = "SELECT * FROM alunos";
			try {
				PreparedStatement stmt = c.getConexao().prepareStatement(sql);
				tabela = stmt.executeQuery();
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Ocorreu um erro ao selecionar os dados");
				return tabela=null;
			}
			return tabela;
		}
		
		public ResultSet procuraNomeAluno(String n) {
			ResultSet tabela = null;
			String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
			try {
				PreparedStatement s = c.getConexao().prepareStatement(sql);
				s.setString(1, "%"+n+"%");
				tabela = s.executeQuery();
				s.execute();
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao selecionar dado!");
				tabela = null;
			}
			return tabela;
		}
		
	}



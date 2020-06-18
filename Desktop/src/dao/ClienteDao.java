package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.ClienteBeans;
import conexao.Conexao;
import padrao.PadraoCrud;
import padrao.PadraoFiltragem;

public class ClienteDao implements PadraoCrud, PadraoFiltragem{

	@Override
	public void filtrarCPF(String CPF) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtrarNome(String nome) {
		// TODO Auto-generated method stub
		
	}

	
	public void cadastrar(Object obj) {
		
		//Obter o objeto
		ClienteBeans cb = (ClienteBeans)obj;
		
		//SQL
		String sql = "INSERT INTO clientes VALUES (?,?,?)";
		
		// Tentativa
		try {
			Conexao.obterConexao();
			
			PreparedStatement pstmt = Conexao.con.prepareStatement(sql);
			pstmt.setString(1,cb.getCpf());
			pstmt.setString(2,cb.getNome());
			pstmt.setString(3,cb.getNascimento());
			
			pstmt.execute();
			
			System.out.println("Cadastro efetuado");
		}catch(Exception e){
			System.out.println("Falha: "+e.getMessage());
		}
		
	}

	@Override
	public void selecionar() {
		//SQL
		String sql = "SELECT * FROM clientes";
		
		// Tentativa
				try {
					Conexao.obterConexao();					
					Statement stmt = Conexao.con.createStatement();					
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getString(1)+" - "+rs.getString(2));
					}
					
				}catch(Exception e){
					System.out.println("Falha ao listar: "+e.getMessage());
				}
		
	}

	@Override
	public void alterar(Object obj) {
		
		//Obter o objeto
		ClienteBeans cb = (ClienteBeans)obj;
				
		//SQL
		String sql = "UPDATE clientes SET nome=?, nascimento=? WHERE cpf=?";
		
		// Tentativa
		try {
			Conexao.obterConexao();
					
			PreparedStatement pstmt = Conexao.con.prepareStatement(sql);
			pstmt.setString(1,cb.getNome());
			pstmt.setString(2,cb.getNascimento());
			pstmt.setString(3,cb.getCpf());
					
			pstmt.execute();
					
			System.out.println("Alteração efetuada");
		}catch(Exception e){
			System.out.println("Falha: "+e.getMessage());
		}
						
		
	}

	@Override
	public void deletar(String parametro) {
						
		//SQL
		String sql ="DELETE FROM clientes WHERE cpf=?";
		
		// Tentativa
		try {
			Conexao.obterConexao();
							
			PreparedStatement pstmt = Conexao.con.prepareStatement(sql);
			pstmt.setString(1, parametro);
							
			pstmt.execute();
							
			System.out.println("Exclusão efetuada");
		}catch(Exception e){
			System.out.println("Falha: "+e.getMessage());
		}
		
	}
	

}

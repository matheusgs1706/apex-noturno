package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	// Atributos
		private static final String usuario = "root";
		private static final String senha = "apex";
		private static final String base = "projeto_web";
		private static final String endereco = "jdbc:mysql://localhost/";
		
		public static Connection con = null;
		
		// Efetuar conex�o
		public static void obterConexao() {
			
			try {
				con = DriverManager.getConnection(endereco+base, usuario, senha);
				System.out.println("Conex�o ok");
			}catch(Exception erro) {
				System.out.println(erro.getMessage());
			}
			
		}
		
		// Remover conex�o
		public static void removerConexao() {
			
			try {
				con.close();
			}catch(Exception erro) {
				System.out.println("Falha ao remover a conex�o");
			}
			
		}

}

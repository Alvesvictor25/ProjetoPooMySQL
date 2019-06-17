package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean verificarRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		String query = "SELECT cpf FROM usuario WHERE cpf = '" + cpf + "'";

		try {

			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;

			}
		} catch (SQLException error) {
			System.out.println("Erro ao executar a Query que verifica a existência de um usuário por cpf.");
			System.out.println("Erro: " + error.getMessage());
			error.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "INSERT INTO usuario (nome,cpf,telefone,login,senha) VALUES ('" + usuarioVO.getNome() + "','"
				+ usuarioVO.getCpf() + "'," + "'" + usuarioVO.getTelefone() + "','" + usuarioVO.getLogin() + "', '"
				+ usuarioVO.getSenha() + "')";

		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica a existência de um usuário por cpf.");
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public boolean verificarRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		String query = "SELECT idusuario FROM usuario WHERE idusuario = " + idUsuario;

		try {

			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;

			}
		} catch (SQLException error) {
			System.out.println("Erro ao executar a Query que verifica a existência de um usuário por Id.");
			System.out.println("Erro: " + error.getMessage());
			error.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;

	}

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "DELETE FROM usuario WHERE idusuario = " + usuarioVO.getIdUsuario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica a exclusão de um usuário por IdUsuario.");
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;

		String query = "UPDATE usuario SET nome ='"
				+usuarioVO.getNome()+"', cpf = '"
				+usuarioVO.getCpf()+"', telefone = '"
				+usuarioVO.getTelefone()+"', login = '"
				+usuarioVO.getLogin()+"', senha ='"
				+usuarioVO.getSenha()+"' WHERE idusuario = "
				+usuarioVO.getIdUsuario();
				
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica a atualização de um usuário por IdUsuario.");
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		return null;
	}

	public UsuarioVO consultarTodosUsuariosDAO(UsuarioVO usuarioVO) {
		return null;
	}


}

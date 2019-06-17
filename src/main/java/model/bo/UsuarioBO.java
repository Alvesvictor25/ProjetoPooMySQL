package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nUsuário já está cadastrado.");

		} else {
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuário cadastrado com sucesso.");

			} else {
				System.out.println("\nNão foi possivel cadastrar o usuário.");
			}
		}
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuário excluido com sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o usuário.");
			}

		} else {
			System.out.println("\nUsuário não existe na base de dados.");

		}

	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if (resultado == 1) {
				System.out.println("\nUsuário atualizado com sucesso.");
			} else {
				System.out.println("\nNão foi possível atulizar o usuário.");
			}

		} else {
			System.out.println("\nUsuário não existe na base de dados.");

		}

	}

	public ArrayList<UsuarioVO> consultarUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if (listaUsuariosVO.isEmpty()) {
			System.out.println("\nA lista de Usuários está vazia.");

		}
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarTodosUsuariosDAO(usuarioVO);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado.");
		}
		return usuario;
	}

}

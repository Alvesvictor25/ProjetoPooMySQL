package controller;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import java.util.ArrayList;

public class ControladoraUsuario {

	// CADASTRAR USUARIO.
	public void cadastrarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.cadastrarUsuarioBO(usuarioVO);
	}

	// CONSULTAR USUARIO (TODOS).
	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarUsuariosBO();
	}

	// CONSULTAR USUARIO (UM).
	public UsuarioVO consultarUsuariosController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarUsuarioBO(usuarioVO);
	}

	// ATUALIZAR USUARIO.
	public void atualizarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBo = new UsuarioBO();
		usuarioBo.atualizarUsuarioBO(usuarioVO);
	}

	// EXCLUIR USUARIO
	public void excluirUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.excluirUsuarioBO(usuarioVO);
	}

}

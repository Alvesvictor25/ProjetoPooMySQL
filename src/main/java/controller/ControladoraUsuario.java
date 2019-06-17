package controller;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;
import java.util.ArrayList;

public class ControladoraUsuario {

	public void cadastrarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.cadastrarUsuarioBO(usuarioVO);

	}

	public void excluirUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.excluirUsuarioBO(usuarioVO);
	}

	public void atualizarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBo = new UsuarioBO();
		usuarioBo.atualizarUsuarioBO(usuarioVO);

	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarUsuariosBO();
	}

	public UsuarioVO consultarUsuariosController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarUsuarioBO(usuarioVO);
	}

}

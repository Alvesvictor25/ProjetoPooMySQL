package controller;

import java.util.ArrayList;

import model.bo.ReceitaBO;
import model.vo.ReceitaVO;

public class ControladoraReceita {

	// CADASTRAR RECEITA.
	public void cadastrarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.cadastrarReceitaBO(receitaVO);
	}

	// CONSULTAR RECEITA (TODAS). 
	public ArrayList<ReceitaVO> consultarTodasReceitasController() {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarReceitasBO();
	}

	// CONSULTAR RECEITA (APENAS UMA). 
	public ReceitaVO consultarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarReceitaBO(receitaVO);
	}

	// ATUALIZAR RECEITA. 
	public void atualizarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.atualizarReceitaBO(receitaVO);
	}

	// EXCLUIR RECEITA. 
	public void excluirReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.excluirReceitaBO(receitaVO);
	}

}

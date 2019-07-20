package controller;

import java.util.ArrayList;
import model.bo.DespesaBO;
import model.vo.DespesaVO;

public class ControladoraDespesa {

	// CADASTRAR DESPESA. 
	public void cadastrarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.cadastrarDespesaBO(despesaVO);
	}

	// CONSULTAR DESPESA (TODOS).
	public ArrayList<DespesaVO> consultarTodasDespesasController() {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarDespesaBO();
	}

	// CONSULTAR DESPESA (UM). 
	public DespesaVO consultarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarDespesaBO(despesaVO);
	}

	// ATUALIZAR DESPESA. 
	public void atualizarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.atualizarDespesaBO(despesaVO);
	}

	// EXCLUIR DESPESA.
	public void excluirDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.excluirDespesaBO(despesaVO);
	}

}

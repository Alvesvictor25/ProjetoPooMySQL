package model.vo;

import java.time.LocalDate;

public class ReceitaVO extends LancamentoVO{

	private LocalDate dataReceita;

	public ReceitaVO(int id, int idusuario, String descricao, double valor, LocalDate dataReceita) {
		super(id, idusuario, descricao, valor);
		this.dataReceita = dataReceita;
	}

	public ReceitaVO() {
		super();
	}

	public LocalDate getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}

	
	



	
	}
	
	


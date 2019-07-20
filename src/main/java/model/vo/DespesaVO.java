package model.vo;

import java.time.LocalDate;


public class DespesaVO extends LancamentoVO {

	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String categoria;

	public DespesaVO(LocalDate dataVencimento, LocalDate dataPagamento, String categoria) {
		super();
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.categoria = categoria;
	}

	public DespesaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void imprimir() {
		System.out.printf("%-10s %-10s %-20s %-20s %-16s %-15s %-10s \n", 
				this.getId(),
				this.getIdusuario(),
				this.getDescricao(),
				this.getValor(),
				this.getDataVencimento(),
				this.verificarResultadoNull(this.getDataPagamento()),
				this.getCategoria());
	}
	public String verificarResultadoNull (LocalDate dataPagamento) {
		String resultado = "";
		if(dataPagamento != null) {
			resultado = dataPagamento.toString();
		}
		return resultado;
	}

}

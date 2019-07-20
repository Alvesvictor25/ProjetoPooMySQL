package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraDespesa;
import model.vo.DespesaVO;

public class MenuDespesa {
	/* DateTimeFormatter formatadat = DateTimeFormatter.ofParttern("yyyy-MM-dd"); */

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_SAIR_DESPESA = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODAS_DESPESAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_SAIR = 3;

	public void apresentarMenuDespesa() {
		int opcao = this.apresentarOpcaoMenu();
		
		while (opcao != OPCAO_MENU_SAIR_DESPESA) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_DESPESA: {
					this.cadastrarDespesa();
					break;
				}
				case OPCAO_MENU_CONSULTAR_DESPESA: {
					this.consultarDespesa();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_DESPESA: {
					this.atualizarDespesa();
					break;
				}
				case OPCAO_MENU_EXCLUIR_DESPESA: {
					this.excluirDespesa();
					break;
				}
				case OPCAO_MENU_SAIR_DESPESA: {
					System.out.println("Sair");
					break;
				}
				default: {
					System.out.println("\nOpcão inválida!!!");
	
				}

			}
			opcao = this.apresentarOpcaoMenu();
		}

	}

	public int apresentarOpcaoMenu() {
		System.out.println("\nDr.Muquirana - Controle de Gastos \n -------- Menu Cadastro de Despesas ---------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastrar despesa.");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar despesa.");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar despesa.");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - Excluir despesa.");
		System.out.println(OPCAO_MENU_SAIR_DESPESA + " -  Voltar.");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	//-----------------------------------------------------------------------------------------
								// METODOS DO RECEITA.
	
	
	// CADASTRAR DESPESA.
	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();

		System.out.print("\nDigite ID do usuário para cadastrar despesa: ");
		despesaVO.setIdusuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite descrição: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.print("\nDigite valor: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite data do vencimento: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dateTime));
		System.out.print("\nDigite data do pagamento: ");
		despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), dateTime));
		System.out.print("\nDigite categoria: ");
		despesaVO.setCategoria(teclado.nextLine());

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);
	}

	// CONSULTAR DESPESA.
	private void consultarDespesa() {
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		int opcao = this.apresentarOpcoesConsulta();
		while (opcao != OPCAO_MENU_CONSULTAR_DESPESA_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODAS_DESPESAS: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					ArrayList<DespesaVO> listaDespesaVO = controladoraDespesa.consultarTodasDespesasController();
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %-3s %-10s %-20s %-20s %-15s %-15s %-15s \n", "IDDESPESA", "IDUSUARIO",
							"DESCRICAO", "VALOR", "DATAVENCIMENTO", "DATAPAGAMENTO", "CATEGORIA");
					for (int i = 0; i < listaDespesaVO.size(); i++) {
						listaDespesaVO.get(i).imprimir();
					}
				
					break;
				}
	
				case OPCAO_MENU_CONSULTAR_UMA_DESPESA: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					DespesaVO despesaVO = new DespesaVO();
					System.out.print("\nDigite o ID  despesa: ");
					despesaVO.setId(Integer.parseInt(teclado.nextLine()));
					DespesaVO despesa = controladoraDespesa.consultarDespesaController(despesaVO);
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %-3s %-10s %-20s %-20s %-15s %-15s %-15s \n", "IDDESPESA", "IDUSUARIO",
							"DESCRICAO", "VALOR", "DATAPAGAMENTO", "DATAVENCIMENTO", "CATEGORIA");
					despesa.imprimir();
	
					break;
				}
	
				default: {
					System.out.println("Opção inválida!");
					opcao = this.apresentarOpcoesConsulta();
	
				}

			}
		}
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada.");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_DESPESAS + " - Consultar todas as despesas.");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar uma despesa.");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_SAIR + " - Sair do menu consultar despesa.");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	// ATUALIZAR DESPESA.
	private void atualizarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		
		System.out.print("\nDigite ID da despesa: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite ID do usuário: ");
		despesaVO.setIdusuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite descrição: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.print("\nDigite valor: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite data do vencimento: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dateTime));
		System.out.print("\nDigite data do pagamento: ");
		despesaVO.setDataPagamento(LocalDate.parse(teclado.nextLine(), dateTime));
		System.out.print("\nDigite categoria: ");
		despesaVO.setCategoria(teclado.nextLine());
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.atualizarDespesaController(despesaVO);
	}

	// EXCLUIR DESPESA.
	private void excluirDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.print("\nDigite o ID despesa: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
	
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.excluirDespesaController(despesaVO);
	}

}

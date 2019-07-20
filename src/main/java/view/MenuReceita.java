package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraReceita;
import model.vo.ReceitaVO;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_SAIR_RECEITA = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_SAIR = 3;

	public void apresentarMenuReceita() {
		int opcao = this.apresentarOpcaoMenu();
		while (opcao != OPCAO_MENU_SAIR_RECEITA) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_RECEITA: {
					this.cadastrarReceita();
					break;
				}
				case OPCAO_MENU_CONSULTAR_RECEITA: {
					this.consultarReceita();
					break;
				}
	
				case OPCAO_MENU_ATUALIZAR_RECEITA: {
					this.atualizarReceita();
					break;
				}
	
				case OPCAO_MENU_EXCLUIR_RECEITA: {
					this.excluirReceita();
					break;
				}
	
				default: {
					System.out.println("\nOpção Inválida!");
				}

			}
			opcao = this.apresentarOpcaoMenu();
		}
	}

	public int apresentarOpcaoMenu() {
		System.out.println("\nDr.Muquirana - Controle de Gastos \n -------- Menu Cadastro de Receita ---------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastrar Receita.");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - Consultar Receita.");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita.");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - Excluir Receita.");
		System.out.println(OPCAO_MENU_SAIR_RECEITA + " -  Voltar.");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	//-----------------------------------------------------------------------------------------
								// METODOS DO RECEITA.
	
	// CADASTRAR RECEITA.
	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite ID do usuário para cadastrar receita: ");
		receitaVO.setIdusuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite descrição: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.print("\nDigite valor: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite data da receita: ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dateTime));

		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);
	}

	// CONSULTAR RECEITA.
	private void consultarReceita() {
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		int opcao = this.apresentarOpcoesConsulta();
		while (opcao != OPCAO_MENU_CONSULTAR_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODAS_RECEITA: {
					opcao = OPCAO_MENU_CONSULTAR_SAIR;
					ArrayList<ReceitaVO> receitasVO = controladoraReceita.consultarTodasReceitasController();
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %-12s %-17s %-20s %-12s %-38s \n", "IDRECEITA", "IDUSUARIO", "DESCRICAO", "VALOR",
							"DATARECEITA");
					for (int i = 0; i < receitasVO.size(); i++) {
						receitasVO.get(i).imprimir();
					}
	
					break;
	
				}
				case OPCAO_MENU_CONSULTAR_UMA_RECEITA: {
					opcao = OPCAO_MENU_CONSULTAR_SAIR;
					ReceitaVO receitaVO = new ReceitaVO();
					System.out.print("\nDigite o ID receita: ");
					receitaVO.setId(Integer.parseInt(teclado.nextLine()));
					ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %-12s %-17s %-20s %-12s %-38s \n", "IDRECEITA", "IDUSUARIO", "DESCRICAO", "VALOR",
							"DATARECEITA");
					receita.imprimir();
	
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
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITA + " - Consultar todas as receitas.");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma receita.");
		System.out.println(OPCAO_MENU_CONSULTAR_SAIR + " - Sair do menu consultar receita.");
		System.out.println("\nDigite opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	// ATUALIZAR RECEITA.
	private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite ID receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite ID usuario: ");
		receitaVO.setIdusuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite descrição: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.print("\nDigite valor: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("\nDigite data da receita: ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dateTime));

		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
	}

	// EXCLUIR RECEITA.
	private void excluirReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite o ID receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));

		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirReceitaController(receitaVO);
	}

}

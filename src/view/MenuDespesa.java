package view;

import java.util.Scanner;

public class MenuDespesa {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_SAIR_DESPESA = 5;

	public void apresentarMenuDespesa() {
		int opcao = this.apresentarOpcaoMenu();
		while (opcao != OPCAO_MENU_SAIR_DESPESA) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_DESPESA: {
				System.out.println("Entrei no cadastro do despesa");
				break;
			}
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				System.out.println("Entrei na consulta do despesa.");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_DESPESA: {
				System.out.println("Entrei na atualização do despesa.");
				break;
			}
			case OPCAO_MENU_EXCLUIR_DESPESA: {
				System.out.println("Entrei na exclusão do despesa.");
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
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastrar Despesa.");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar Despesa.");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar Despesa.");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - Excluir Despesa.");
		System.out.println(OPCAO_MENU_SAIR_DESPESA + " -  Voltar.");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}

package view;

import java.util.Scanner;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_SAIR_RECEITA = 5;

	public void apresentarMenuReceita() {
		int opcao = this.apresentarOpcaoMenu();
		while (opcao != OPCAO_MENU_SAIR_RECEITA) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_RECEITA: {
				break;
			}
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				break;
			}

			case OPCAO_MENU_ATUALIZAR_RECEITA: {
				break;
			}

			case OPCAO_MENU_EXCLUIR_RECEITA: {
				break;
			}

			case OPCAO_MENU_SAIR_RECEITA: {
				break;
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
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}

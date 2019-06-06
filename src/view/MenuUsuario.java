package view;

import java.util.Scanner;

public class MenuUsuario {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_SAIR_USUARIO = 5;

	public void apresentarMenuUsuario() {
		int opcao = this.apresentarOpcaoMenu();
		while (opcao != OPCAO_MENU_SAIR_USUARIO) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_USUARIO: {
				System.out.println("Entrei no cadastro do usuário");
				break;
			}
			case OPCAO_MENU_CONSULTAR_USUARIO: {
				System.out.println("Entrei na consulta do usuário.");
				break;
			}
			case OPCAO_MENU_ATUALIZAR_USUARIO: {
				System.out.println("Entrei na atualização do usuário.");
				break;
			}
			case OPCAO_MENU_EXCLUIR_USUARIO: {
				System.out.println("Entrei na exclusão do usuário.");
				break;
			}
			case OPCAO_MENU_SAIR_USUARIO: {
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
		System.out.println("\nDr.Muquirana - Controle de Gastos \n -------- Menu Cadastro de Usuários ---------");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - Cadastrar Usuário.");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Consultar Usuário.");
		System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - Atualizar Usuário.");
		System.out.println(OPCAO_MENU_EXCLUIR_USUARIO + " - Excluir Usuário");
		System.out.println(OPCAO_MENU_SAIR_USUARIO + " -  Voltar.");
		System.out.println("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());

	}

}

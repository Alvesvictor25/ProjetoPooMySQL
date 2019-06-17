package view;

import java.util.Scanner;

public class MenuCadastro {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRO_USUARIO = 1;
	private static final int OPCAO_MENU_CADASTRO_RECEITA = 2;
	private static final int OPCAO_MENU_CADASTRO_DESPESAS = 3;
	private static final int OPCAO_MENU_CADASTRO_SAIR = 4;

	public void apresentarMenuCadastro() {
		int opcao = this.apresentarOpcoesDeMenu();

		while (opcao != OPCAO_MENU_CADASTRO_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRO_USUARIO: {
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.apresentarMenuUsuario();
				break;
			}
			case OPCAO_MENU_CADASTRO_RECEITA: {
				System.out.println("Entrei no menu cadastro!");
				break;
			}
			case OPCAO_MENU_CADASTRO_DESPESAS: {
				System.out.println("Entrei no menu cadastro!");
				break;
			}
			}
		}
	}

	public int apresentarOpcoesDeMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos \n---------- Menu Cadastro ----------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRO_USUARIO + " - Cadastro de usuário.");
		System.out.println(OPCAO_MENU_CADASTRO_RECEITA + " - Cadastro de receita.");
		System.out.println(OPCAO_MENU_CADASTRO_DESPESAS + " - Cadastro de despesas.");
		System.out.println(OPCAO_MENU_CADASTRO_SAIR + " - Sair");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}

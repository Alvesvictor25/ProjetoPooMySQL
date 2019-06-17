package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

public class MenuUsuario {

	Scanner teclado = new Scanner(System.in);

	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_SAIR_USUARIO = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO_SAIR = 3;

	public void apresentarMenuUsuario() {
		int opcao = this.apresentarOpcaoMenu();
		while (opcao != OPCAO_MENU_SAIR_USUARIO) {
			switch (opcao) {
			case OPCAO_MENU_CADASTRAR_USUARIO: {
				this.cadastrarUsuario();
				break;
			}
			case OPCAO_MENU_CONSULTAR_USUARIO: {
				this.consultarUsuario();
				break;
			}
			case OPCAO_MENU_ATUALIZAR_USUARIO: {
				this.atualizarUsuario();
				;
				break;
			}
			case OPCAO_MENU_EXCLUIR_USUARIO: {
				this.excluirUsuario();
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

	private void cadastrarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.print("\nDigite o nome do usuário: ");
		usuarioVO.setNome(teclado.nextLine());

		System.out.println("\nDigite o cpf do usuário: ");
		usuarioVO.setCpf(teclado.nextLine());

		System.out.println("\nDigite o telefone do usuário: ");
		usuarioVO.setTelefone(teclado.nextLine());

		System.out.println("\nDigite o login do usuário: ");
		usuarioVO.setLogin(teclado.nextLine());

		System.out.println("\nDigite a senha do usuário: ");
		usuarioVO.setSenha(teclado.nextLine());

		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.cadastrarUsuarioController(usuarioVO);
	}

	private void consultarUsuario() {
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		int opcao = this.apresentarOpcoesConsulta();
		while (opcao != OPCAO_MENU_CONSULTAR_USUARIO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CONSULTAR_TODOS_USUARIOS: {
					opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
					ArrayList<UsuarioVO> listaUsuariosVO = controladoraUsuario.consultarTodosUsuariosController();
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "NOME", "CPF", "TELEFONE", "LOGIN");
					for(int i = 0; i < listaUsuariosVO.size(); i++) {
						listaUsuariosVO.get(i).imprimir();
							}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UM_USUARIO: {
					opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
					UsuarioVO usuarioVO = new UsuarioVO();
					System.out.println("\nDigite o codigo do Usuario: ");
					usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					
					UsuarioVO usuario = controladoraUsuario.consultarUsuariosController(usuarioVO);
					System.out.println("\n-------- Resultado da Consulta --------");
					System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "NOME", "CPF", "TELEFONE", "LOGIN");
					usuario.imprimir();
					
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
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIOS + " -  Consultar todos os Usuários.");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar um Usuário específico.");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO_SAIR + " - Sair do menu consultar Usuário.");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void excluirUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();
		System.out.print("\nDigite o código do usuário: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));

		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.excluirUsuarioController(usuarioVO);

	}

	private void atualizarUsuario() {
		UsuarioVO usuarioVO = new UsuarioVO();

		System.out.println("\nDigite o codigo do usuário: ");
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));

		System.out.print("\nDigite o nome do usuário: ");
		usuarioVO.setNome(teclado.nextLine());

		System.out.println("\nDigite o cpf do usuário: ");
		usuarioVO.setCpf(teclado.nextLine());

		System.out.println("\nDigite o telefone do usuário: ");
		usuarioVO.setTelefone(teclado.nextLine());

		System.out.println("\nDigite o login do usuário: ");
		usuarioVO.setLogin(teclado.nextLine());

		System.out.println("\nDigite a senha do usuário: ");
		usuarioVO.setSenha(teclado.nextLine());

		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.atualizarUsuarioController(usuarioVO);
	}

}

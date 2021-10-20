import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import Entidades.Administrador;
import Entidades.Aeroporto;
import Entidades.Aviao;
import Entidades.Cliente;
import Entidades.Posicao;
import Util.Arquivo;
import Util.Validacao;

public class Main {
	private static final String arqAdmin = "admin.txt";
	private static final String arqClientes = "clientes.txt";
	private static final String arqAvioes = "avioes.txt";

	private static final Scanner scan = new Scanner(System.in);
	private static Administrador administrador;
	private static Aeroporto aeroporto;
	private static ArrayList<Cliente> clientes;

	private static void preencherAeroporto() throws Exception {
		aeroporto = new Aeroporto();
		if (!Arquivo.existe(arqAvioes)) {
			return;
		}
		ArrayList<String> linhas = Arquivo.ler(arqAvioes);
		int i = 0;
		while (true) {
			if (i >= linhas.size()) {
				break;
			}
			String linha = linhas.get(i);
			String splitter[] = new String[6];
			splitter = linha.split(";");
			String id = splitter[0];
			String destino = splitter[1];
			String horario = splitter[2];
			String data = splitter[3];
			int altura = Integer.parseInt(splitter[4]);
			int largura = Integer.parseInt(splitter[5]);
			ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
			for (int a = 0; a < altura; a++) {
				String novaLinha = linhas.get(++i);
				StringTokenizer st2 = new StringTokenizer(novaLinha);
				for (int l = 0; l < largura; l++) {
					if (Boolean.parseBoolean(st2.nextToken()))
						posicoes.add(new Posicao(a, l));
				}
			}
			aeroporto.getAvioes().add(new Aviao(id, destino, data, horario, altura, largura, posicoes));
			i++;
		}
	}

	private static void preencherClientes() throws Exception {
		clientes = new ArrayList<Cliente>();
		if (!Arquivo.existe(arqClientes)) {
			return;
		}
		ArrayList<String> linhas = Arquivo.ler(arqClientes);
		for (String linha : linhas) {
			String splitter[] = new String[7];
			splitter = linha.split(";");
			String nome = splitter[0];
			String rg = splitter[1];
			String telefone = splitter[2];
			String cpf = splitter[3];
			String idAviao = splitter[4];
			int poltronaLinha = Integer.parseInt(splitter[5]);
			int poltronaColuna = Integer.parseInt(splitter[6]);
			clientes.add(new Cliente(nome, rg, telefone, cpf, idAviao, poltronaLinha, poltronaColuna));
		}
	}

	public static void main(String[] args) {
		try {
			if (!Arquivo.existe(arqAdmin)) {
				System.out.println("Percebemos que ˜ a primeira vez que executas o programa..");
				System.out.print("Informe (Sem espa˜os) o nome do Administrador: ");
				String admNome = scan.next();
				System.out.print("Informe uma senha: ");
				String admSenha = scan.next();
				administrador = new Administrador(admNome, admSenha);
				administrador.salvar(arqAdmin);
			} else {
				String[] dadosAdmin = Arquivo.ler(arqAdmin).get(0).split(";");
				administrador = new Administrador(dadosAdmin[0], dadosAdmin[1]);
				boolean logado = false;
				while (!logado) {
					System.out.print("Informe (Sem espa˜os)  o nome do Administrador: ");
					String admNome = scan.next();
					System.out.print("Informe uma senha: ");
					String admSenha = scan.next();
					if (!administrador.validarAcesso(admNome, admSenha)) {
						System.err.println("Acesso negado!");
					} else {
						logado = true;
					}
				}
			}
			preencherAeroporto();
			preencherClientes();
			areaAdministrador();
			System.out.println("Programa Finalizado!");
		} catch (Exception ex) {
			System.err.println("Ocorreu um erro inesperado, estamos finalizando a aplica˜˜o.");
			ex.printStackTrace();
		}
	}

	private static void areaAdministrador() throws IOException {
		boolean sair = false;
		do {
			System.out.println("==========================================");
			System.out.println("1. ˜rea do cliente");
			System.out.println("2. Cadastrar Avi˜o");
			System.out.println("3. Editar Avi˜o");
			System.out.println("4. Remover Avi˜o");
			System.out.println("5. Consultar Avi˜es cadastrados");
			System.out.println("6. Sair");
			System.out.println("==========================================");
			boolean tratamento = false;
			int opcao = 0;
			try {
				opcao = scan.nextInt();
				tratamento = true;
			} catch (Exception e) {
				System.err.println("Entrada Inv˜lida! ");
				scan.nextLine();
			}
			switch (opcao) {
			case 1:
				areaCliente();
				break;
			case 2:
				System.out.println("informe a quantidade de avi˜o que deseja cadastrar:");
				try {
					int qtd = scan.nextInt();
					for (int i = 0; i < qtd; i++) {
						scan.nextLine();
						System.out.print("Informe o idAviao do avi˜o: ");
						String idAviao = scan.nextLine();
						idAviao = idAviao.trim();
						System.out.print("Informe o destino do avi˜o: ");
						String destino = scan.nextLine();
						destino = destino.trim();
						System.out.print("Informe (hh:mm) o hor˜rio de partida: ");
						String horario = scan.next();
						if (!Validacao.horario(horario)) {
							System.out.println("Hor˜rio Inv˜lido");
							while (!Validacao.horario(horario)) {
								System.out.println("Informe um hor˜rio v˜lido! (hh:mm)");
								horario = scan.next();
							}
						}
						System.out.print("informe (dd/mm/aa) a data de partida: ");
						String data = scan.next();
						if (!Validacao.data(data)) {
							System.out.println("Data Inv˜lida");
							while (!Validacao.data(data)) {
								System.out.println("Informe uma data v˜lida!");
								data = scan.next();
							}
						}
						System.out.print("Informe a quantidade de linha e colunas: ");
						int l = scan.nextInt(), c = scan.nextInt();
						ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
						Posicao a = new Posicao(l, c);
						posicoes.add(a);
						aeroporto.getAvioes().add(new Aviao(idAviao, destino, data, horario, l, c, posicoes));
						Arquivo.escrever("avioes.txt",
								aeroporto.getAvioes().get(aeroporto.getAvioes().size() - 1).toString(), true);
						System.out.println("Avi˜o registrado");
					}
				} catch (Exception e) {
					System.err.println("Houve algum erro!");
					scan.nextLine();
				}
				break;
			case 3:
				if (aeroporto.getAvioes().isEmpty()) {
					System.err.println("N˜o h˜ avi˜es para editar");
				} else {
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br = new BufferedReader(isr);
					boolean sairId = false;
					String idEditado = "BOLSONARO_AGIOTA";
					int indiceEditado = -1;
					int cont = aeroporto.getAvioes().size();
					do {
						System.out.println("Informe o id do avi˜o: ");
						idEditado = br.readLine();
						for (int k = 0; k < aeroporto.getAvioes().size(); k++) {
							if (aeroporto.getAvioes().get(k).getIdAviao().equals(idEditado)) {
								indiceEditado = k;
								sairId = true;
								break;
							} else {
								cont--;
							}
						}
						if (cont == 0) {
							System.err.print("Avi˜o n˜o encontrado.\n\n");
							cont = aeroporto.getAvioes().size();
						}
					} while (!sairId);
					try {
						System.out.print("Informe o novo Id do avi˜o: ");
						idEditado = br.readLine();
						System.out.print("Informe o destino do avi˜o: ");
						String destino = br.readLine();
						System.out.print("Informe (hh:mm) o hor˜rio de partida: ");
						String horario = scan.next();
						if (!Validacao.horario(horario)) {
							System.err.println("Hor˜rio Inv˜lido");
							while (!Validacao.horario(horario)) {
								System.out.println("Informe um Hor˜rio v˜lido! (hh:mm)");
								horario = scan.next();
							}
						}
						System.out.print("informe (dd/mm/aa) a data de partida: ");
						String data = scan.next();
						if (!Validacao.data(data)) {
							System.out.println("Data Inv˜lida");
							while (!Validacao.data(data)) {
								System.out.println("Informe uma data v˜lida!");
								data = scan.next();
							}
						}
						System.out.print("Informe a quantidade de linha e colunas: ");
						int l = scan.nextInt(), c = scan.nextInt();
						ArrayList<Posicao> posicoes = new ArrayList<Posicao>();
						Posicao a = new Posicao(l, c);
						posicoes.add(a);
						aeroporto.getAvioes().set(indiceEditado,
								new Aviao(idEditado, destino, data, horario, l, c, posicoes));
						Arquivo.sobrescreverAviao(aeroporto.getAvioes());
						System.out.println("Avi˜o editado");
						sairId = true;
					} catch (Exception e) {
						System.out.print("Entrada Inv˜lida!");
						e.printStackTrace();
					}
				}
				break;
			case 4:
				if (aeroporto.getAvioes().isEmpty()) {
					System.err.println("N˜o h˜ avi˜es para remover!");
				} else {
					scan.nextLine();
					System.out.print("informe o id do aviao que desejas excluir: ");
					String idExcluido = scan.nextLine();
					boolean achou = false;
					try {
						for (int i = 0; i < aeroporto.getAvioes().size(); i++) {
							if (idExcluido.equals(aeroporto.getAvioes().get(i).getIdAviao())) {
								aeroporto.getAvioes().remove(i);
								achou = true;
							}
						}
						if (achou) {
							System.out.println("Avi˜o removido!");
							System.out.println("");
						} else {
							System.err.println("Id inexistente!");
						}

					} catch (Exception e) {
						System.err.println("Houve algum erro! ");
						e.printStackTrace();
					}

					Arquivo.sobrescreverAviao(aeroporto.getAvioes());

				}
				break;
			case 6:
				for (int i = 0; i < 100; i++) {
					System.out.println("");
				}
				System.out.println("=================================");
				System.out.println("Programa Finalizado!");
				System.out.println("=================================");
				sair = true;
				System.exit(0);
				break;
			case 5:
				Consultar();
				break;
			default:
				if (tratamento) {
					System.err.println("Opc˜o Inv˜lida!");
					System.out.println("");
				}
				break;
			}
		} while (!sair);
	}

	private static void areaCliente() throws IOException {
		int op = 0;
		while (op != 69) {
			System.out.println("====================================");
			System.out.println("1. Reservar");
			System.out.println("2. Consultar");
			System.out.println("3. Retirar reserva");
			System.out.println("====================================");
			boolean tratamento = false;
			try {
				op = scan.nextInt();
				tratamento = true;
			} catch (Exception e) {
				System.err.println("Entrada Inv˜lida! ");
				scan.nextLine();
			}
			switch (op) {
			case 1:
				if (aeroporto.getAvioes().isEmpty()) {
					System.err.println("Nao h˜ avi˜es, chame o administrador");
				} else {
					Reservar();
				}
				break;
			case 2:
				if (aeroporto.getAvioes().isEmpty()) {
					System.err.println("Nao h˜ avi˜es, chame o administrador");
				} else {
					Consultar();
				}
				break;
			case 3:
				if (clientes.isEmpty()) {
					System.err.println("N˜o h˜ avi˜es para remover!");
				} else {
					scan.nextLine();
					System.out.print("informe o nome usado na reserva que desejas excluir: ");
					String idExcluido = scan.nextLine();
					boolean achou = false, validado = false;
					try {
						for (int i = 0; i < clientes.size(); i++) {
							if (idExcluido.equals(clientes.get(i).getNome())) {
								achou = true;
								System.out.print("Insira o Cpf usado: ");
								String cpfUsado = scan.nextLine();
								if (cpfUsado.equals(clientes.get(i).getCpf())) {
									System.out.print("Insira o rg usado: ");
									String rgUsado = scan.nextLine();
									if (rgUsado.equals(clientes.get(i).getRg())) {
										validado = true;
										for (int j = 0; j < aeroporto.getAvioes().size(); j++) {
											if (aeroporto.getAvioes().get(j).getIdAviao().equals(clientes.get(i).getIdAviao())) {
												aeroporto.getAvioes().get(j).desocuparPoltrona(new Posicao(clientes.get(i).getPoltronaLinha(), clientes.get(i).getPoltronaColuna()));
											}
										}
										
										clientes.remove(i);
										
									}
								}
							}
						}
						if (achou && validado) {
							System.out.println("Reserva retirada");
							System.out.println("");
						} else {
							System.err.println("Reserva inexistente ou retirada nao validada!");
						}
					} catch (Exception e) {
						System.err.println("Houve algum erro! ");
						e.printStackTrace();
					}
					Arquivo.sobrescreverAviao(aeroporto.getAvioes());
					Arquivo.sobrescreverClientes(clientes);
				}
				break;
			case 69:
				scan.nextLine();
				System.out.print("Informe (Sem espa˜os) o nome do Administrador: ");
				String admNome = scan.nextLine();
				System.out.print("Informe uma senha: ");
				String admSenha = scan.nextLine();
				if (!administrador.validarAcesso(admNome, admSenha)) {
					System.err.println("Acesso Negado!");
					System.out.println();
					areaCliente();
				} else if (administrador.validarAcesso(admNome, admSenha)) {
					System.out.println("Acesso Permitido!");
					areaAdministrador();
				}
				break;
			default:
				if (tratamento) {
					System.err.println("Op˜˜o Inv˜lida!");
				}
				break;
			}
		}

	}
	public static void Reservar() {
		boolean tratamento = false;
		try {
			boolean sair = false;
			tratamento = true;
			do {
				scan.nextLine();
				System.out.print("Informe seu nome:");
				String nome = scan.nextLine();
				nome = nome.trim();
				System.out.print("Informe seu Rg:");
				String rg = scan.nextLine();
				rg = rg.trim();
				System.out.print("Informe seu telefone:");
				String tel = scan.nextLine();
				tel = tel.trim();
				System.out.print("Informe o cpf:");
				String auxcpf = scan.nextLine();
				String cpf = "";
				auxcpf = auxcpf.trim();
				// validacao CPF
				if (auxcpf.length() != 11) {
					while (true) {
						System.out.println("CPF inv˜lido. Informe um v˜lido!");
						auxcpf = scan.nextLine();
						if (auxcpf.length() == 11) {
							break;
						}
					}
				}
				if (!Validacao.CPF(auxcpf)) {
					try {
						while (!Validacao.CPF(auxcpf)) {
							System.err.println("Cpf inv˜lido!");
							System.out.print("informe um cpf v˜lido");
							auxcpf = scan.nextLine();
							cpf = (auxcpf);
						}
					} catch (Exception e) {
						System.out.println();
						e.printStackTrace();
					}

				} else {
					cpf = (auxcpf);
				}
				// mostra avioes disponiveis e valida a entrada do id Aviao
				int indice = -1;
				for (int k = 0; k < aeroporto.getAvioes().size(); k++) {
					Aviao.mostrarAviaoSemMatriz(aeroporto.getAvioes().get(k));
				}
				boolean sairId = false;
				String idAviao = "BOLSONARO_AGIOTA";
				do {
					int cont = aeroporto.getAvioes().size();
					System.out.print("Informe o id do avi˜o: ");
					idAviao = scan.nextLine();
					for (int k = 0; k < aeroporto.getAvioes().size(); k++) {
						if (aeroporto.getAvioes().get(k).getIdAviao().equals(idAviao)) {
							indice = k;
							sairId = true;
							if (aeroporto.getAvioes().get(indice).getDisponiveis() == 0) {
								System.err.println("N˜o h˜ cadeiras dispon˜veis");
								sairId = false;
							}
							break;
						} else {
							cont--;
						}
					}
					if (cont == 0) {
						System.err.println("Avi˜o n˜o encontrado.");
					}

				} while (!sairId);
				// validacao da poltrona
				boolean sairPoltrona = false;
				String l = "", c = "";
				while (!sairPoltrona) {
					System.out.println("Informe a poltrona: ");
					Aviao.mostrarAviao(aeroporto.getAvioes().get(indice));
					l = scan.next();
					c = scan.next();
					try {
						if (Integer.parseInt(l) > aeroporto.getAvioes().get(indice).getAltura()
								|| Integer.parseInt(c) > aeroporto.getAvioes().get(indice).getLargura()
								|| aeroporto.getAvioes().get(indice).getPoltronas()[Integer.parseInt(l)][Integer
										.parseInt(c)] == true) {
							sairPoltrona = false;
							System.err.println("Poltrona Inv˜lida!");
						} else {
							Posicao posicao = new Posicao(Integer.parseInt(l), Integer.parseInt(c));
							clientes.add(
									new Cliente(nome, rg, tel, cpf, idAviao, Integer.parseInt(l), Integer.parseInt(c)));
							aeroporto.getAvioes().get(indice).ocuparPoltrona(posicao);
							Arquivo.escrever("clientes.txt", clientes.get(clientes.size() - 1).toString(), true);
							Arquivo.sobrescreverAviao(aeroporto.getAvioes());
							System.out.println("Cliente adicionado!");
							sairPoltrona = true;
							sair = true;
						}
					} catch (Exception e) {
						sairPoltrona = false;
						System.out.println();
						System.err.println("Poltrona Inv˜lida!");
					}
				}
			} while (!sair);
		} catch (Exception e) {
			if (tratamento) {
				System.err.println("Entrada Inv˜lida!");
			}
		}
	}

	public static void Consultar() {
		System.out.println("=====================================");
		System.out.println("1. Consultar por destino");
		System.out.println("2. Consultar por data de partida");
		System.out.println("3. Mostrar todos");
		System.out.println("=====================================");
		boolean tratamento = false;
		try {
			int op = scan.nextInt();
			tratamento = true;
			switch (op) {
			case 1:
				scan.nextLine();
				System.out.print("Informe um destino: ");
				String des = scan.nextLine();
				int cont = aeroporto.getAvioes().size();
				for (int i = 0; i < aeroporto.getAvioes().size(); i++) {
					if (aeroporto.getAvioes().get(i).getDestino().equalsIgnoreCase(des)) {
						Aviao.mostrarAviao(aeroporto.getAvioes().get(i));
					} else {
						cont--;
					}
				}
				if (cont == 0) {
					System.err.println("N˜o tem avi˜o com esse destino!");
				}
				break;
			case 2:
				scan.nextLine();
				System.out.print("informe (dd/mm/aa) a data de partida: ");
				String data = scan.next();
				if (!Validacao.data(data)) {
					System.out.println("Data Inv˜lida");
					while (!Validacao.data(data)) {
						System.out.println("Informe uma data v˜lida!");
						data = scan.next();
					}
				}

				break;
			case 3:
				for (int i = 0; i < aeroporto.getAvioes().size(); i++) {
					Aviao.mostrarAviao(aeroporto.getAvioes().get(i));
				}
				break;
			default:
				if (tratamento) {
					System.err.println("Op˜˜o Inv˜lida! ");
				}
				break;
			}
		} catch (Exception e) {
			if (tratamento) {
				System.err.println("Entrada Inv˜lida!");
			}
		}
	}
}

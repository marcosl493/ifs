package etapa3_prova;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	static ArrayList<Carga> carrosdecarga = new ArrayList<>();
	static ArrayList<Passeio> carrosdepasseio = new ArrayList<>();

	public static void main(String[] args) {
		String placa;
		String marca;
		String modelo;
		short ano;
		int opc;
		double kminicial;
		Scanner scan = new Scanner(System.in);
		int op;
		do {
			System.out.println("1.Adicionar veículos\n2.Reservar\n3.Devolver carro\n4.Sair");
			op = scan.nextInt();
			switch (op) {
			case 1:

				System.out.println("1.Veículo de carga\n2.Veículo de passeio");
				opc = scan.nextInt();
				if (opc == 1) {

					System.out.println("Informe a placa:");
					placa = scan.next();
					System.out.println("Informe a marca:");
					marca = scan.next();
					System.out.println("Informe modelo:");
					modelo = scan.next();
					System.out.println("Informe o ano:");
					ano = scan.nextShort();
					System.out.println("Informe kminicial:");
					kminicial = scan.nextDouble();
					System.out.println("informe a capacidade do carro em toneladas");
					double capacidade = scan.nextDouble();
					carrosdecarga.add(new Carga(placa, marca, modelo, ano, kminicial, capacidade));

				} else if (opc == 2) {

					System.out.println("Informe a placa:");
					placa = scan.next();
					System.out.println("Informe a marca:");
					marca = scan.next();
					System.out.println("Informe modelo:");
					modelo = scan.next();
					System.out.println("Informe o ano:");
					ano = scan.nextShort();
					System.out.println("Informe kminicial:");
					kminicial = scan.nextDouble();
					System.out.println("1. tem ar condicionado\n2. não tem arcondicionado");
					int arc = scan.nextInt();
					while (arc != 1 && arc != 2) {
						System.out.println("1. tem ar condicionado\n2. não tem arcondicionado");
						arc = scan.nextInt();
					}
					boolean isarc;
					if (arc == 1) {
						isarc = true;
					} else {
						isarc = false;
					}

					System.out.println("1. 2 portas\n2. 4 portas");
					int por = scan.nextInt();
					while (por != 1 && por != 2) {
						System.out.println("1. 2 portas\n2. 4 portas");
						por = scan.nextInt();
					}
					boolean isport2;
					if (por == 1) {
						isport2 = true;
					} else {
						isport2 = false;
					}
					carrosdepasseio.add(new Passeio(placa, marca, modelo, ano, kminicial, isarc, isport2));

				}
				break;
			case 2:

				System.out.println("1.carro de passeio\n2.carro de carga");
				opc = scan.nextInt();

				switch (opc) {
				case 1:
					MostrarListaPasseio();
					System.out.print("Escolha uma opção digitando o número da linha do carro escolhido: ");
					opc = scan.nextInt();
					if (carrosdepasseio.size() > opc && !carrosdepasseio.get(opc).isAlugado()) {
						carrosdepasseio.get(opc).setAlugado(true);
						System.out.println("Alugado com sucesso!");
					} else {
						System.err.println("Opção Inválida ou carro já alugado!");
					}
					break;
				case 2:
					MostrarListaCarga();
					System.out.print("Escolha uma opção digitando o número da linha do carro escolhido: ");
					opc = scan.nextInt();
					if (opc < carrosdecarga.size() && !carrosdecarga.get(opc).isAlugado()) {
						carrosdecarga.get(opc).setAlugado(true);
					} else {
						System.err.println("Opção Inválida ou carro já alugado!");
					}

					break;
				default:
					System.err.println("Opção inválida");
					break;
				}

				break;
			case 3:
				System.out.println("Informe a placa do carro a ser devolvido:");
				String placaa = scan.next();
				boolean achou = false;
				int indicie = -1;
				String tipo = "";
				for (int i = 0; i < carrosdecarga.size(); i++) {
					if (carrosdecarga.get(i).getPlaca().equalsIgnoreCase(placaa) && carrosdecarga.get(i).isAlugado()) {
						achou = true;
						indicie = i;
						tipo = "carga";
					}
				}
				if (!achou) {
					for (int i = 0; i < carrosdepasseio.size(); i++) {
						if (carrosdepasseio.get(i).getPlaca().equals(placaa) && carrosdepasseio.get(i).isAlugado()) {
							achou = true;
							indicie = i;
							tipo = "passeio";
						}
					}
				}
				if (!achou) {
					System.err.println("Placa Inválida!");
				} else {
					if (tipo.equals("carga")) {

						for (int i = 0; i <= 10; i++) {
							System.out.print("=");
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println();
						System.out.println("Placa de carro de Carga");
						for (int i = 0; i <= 10; i++) {
							System.out.print("=");
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println();
						System.out.println("Informe o km atual:");
						double km = scan.nextDouble();
						System.out.println("Informe o valor do km:");
						double valorr = scan.nextDouble();
						System.out.println(carrosdecarga.get(indicie).valor(km, valorr));
						System.out.println("1.Finalizar devolução\n" + "2.Sair");
						opc = scan.nextInt();
						if (opc == 1) {
							carrosdecarga.get(indicie).setAlugado(false);
							carrosdecarga.get(indicie).setKminicial(km);
							System.out.println("Devolução finalizada!");
						} else {
							System.out.println("Devolução não finalizada!");
						}

					}
					if (tipo.equals("passeio")) {
						System.out.println();
						System.out.println("Placa de carro de passeio");
						System.out.println();
						System.out.println("Informe o km atual:");
						double km = scan.nextDouble();
						System.out.println("Informe o valor do km:");
						double valorr = scan.nextDouble();
						System.out.println(carrosdepasseio.get(indicie).valor(km, valorr));
						System.out.println("1.Finalizar devolução\n" + "2.Sair");
						opc = scan.nextInt();
						if (opc == 1) {
							carrosdepasseio.get(indicie).setAlugado(false);
							carrosdepasseio.get(indicie).setKminicial(km);
							System.out.println("Devolução finalizada!");
						} else {
							System.out.println("Devolução não finalizada!");
						}
					}
				}
				break;
			case 4:
				op = 0;
				break;
			default:
				System.err.println("Opção Inválida!");
				break;
			}
		} while (op != 0);
		scan.close();

	}

	public static void MostrarListaCarga() {
		for (int i = 0; i < carrosdecarga.size(); i++) {

			System.out.print(i + ": ");

			for (int j = 0; j < carrosdecarga.size(); j++) {

				System.out.println(carrosdecarga.get(j).getMarca() + ";" + carrosdecarga.get(j).getModelo() + ";"
						+ carrosdecarga.get(j).getCapacidade() + " toneladas");
				System.out.println();

			}
		}
	}

	public static void MostrarListaPasseio() {
		String ar = "";
		for (int i = 0; i < carrosdepasseio.size(); i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < carrosdepasseio.size(); j++) {

				if (carrosdepasseio.get(j).isArcondicionado() == true) {
					ar = "Tem ar-condicionado";
				} else {
					ar = "Não tem ar-condicionado";
				}
				String qtdport;
				if (carrosdepasseio.get(j).isPortas2()) {
					qtdport = "2 portas";
				} else {
					qtdport = "4 portas";
				}
				System.out.println(carrosdepasseio.get(j).getMarca() + ";" + carrosdepasseio.get(j).getModelo() + ";"
						+ ar + ";" + qtdport + ";" + carrosdepasseio.get(j).getAno() + ";");
				System.out.println();

			}
		}
	}

}

package examples;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Conta> contas = new ArrayList<Conta>();
	static String ag;
	static String bank;
	static String numc;
	static String tipo;
	static double valor;
	final static Scanner scan = new Scanner(System.in);
	public static String ConverterTipoConta(String tipo) {
		if(tipo.equalsIgnoreCase("1")) {
			return "Poupança";
		}else if(tipo.equalsIgnoreCase("2")) {
			return "Corrente";
		}
		return null;
		
	}
	public static int indice(String ag, String bank, String numc, String tipo) {
		for (int i = 0; i < contas.size(); i++) {
			if (ag.equals(contas.get(i).getAgencia()) && bank.equalsIgnoreCase(contas.get(i).getBanco())
					&& numc.equals(contas.get(i).getNum_conta()) && tipo.equalsIgnoreCase(contas.get(i).getTipoConta())) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conta conta;

		int op = 5;

		while (op != 0) {

			System.out.println("1. Depositar");
			System.out.println("2. Sacar");
			System.out.println("3. Consultar");
			System.out.println("4. Criar conta");
			System.out.println("0. Sair");
			op = scan.nextInt();
			switch (op) {
			case 1:
				System.out.println("Informe a agência:");
				ag = scan.next();
				System.out.println("Informe Banco:");
				bank = scan.next();
				System.out.println("Número de conta:");
				numc = scan.next();
				System.out.println("informe o tipo de conta desejada:\n1: Poupança\n2:Corrente");
				tipo = scan.next();
				tipo = ConverterTipoConta(tipo);
				if (indice(ag, bank, numc, tipo) == -1) {
					System.out.println("Não existe");
				} else {
					System.out.println("Informe o valor a depositar:");
					valor = scan.nextDouble();
					contas.get(indice(ag, bank, numc, tipo)).depositar(valor);
					System.out.println("Depósito efetuado.");
				}

				break;
			case 2:
				System.out.println("Informe a agência:");
				ag = scan.next();
				System.out.println("Informe Banco:");
				bank = scan.next();
				System.out.println("Número de conta:");
				numc = scan.next();
				System.out.println("informe o tipo de conta desejada:\n1: Poupança\n2: Corrente");
				tipo = scan.next();
				tipo = ConverterTipoConta(tipo);
				if (indice(ag, bank, numc, tipo) == -1) {
					System.out.println("Não existe");
				} else {
					System.out.println("Informe o valor a sacar:");
					valor = scan.nextDouble();
					int retorno = contas.get(indice(ag, bank, numc, tipo)).sacar(valor);
					if( retorno == 1) {
					
					System.out.println("Saque efetuado.");
				}else if(retorno == 0){
					System.out.println("Saque efetuado usando limite emergencial!");
				}
				else if (retorno == -1){
					System.out.println("Saldo insufisciente.");
				}
					}

				// conta.sacar(valor);
				break;
			case 3:
				System.out.println("Informe a agência:");
				ag = scan.next();
				System.out.println("Informe Banco:");
				bank = scan.next();
				System.out.println("Número de conta:");
				numc = scan.next();
				System.out.println("informe o tipo de conta desejada\n1: Poupança\n2: Corrente");
				tipo = scan.next();
				tipo = ConverterTipoConta(tipo);
				if (indice(ag, bank, numc, tipo) == -1) {
					System.out.println("Não existe");
				} else {
					System.out.printf("Saldo: R$%.2f\n", contas.get(indice(ag, bank, numc, tipo)).getSaldo());
					if(tipo.equalsIgnoreCase("Corrente")) {
						System.out.printf("Limite de conta: %.2f\n",
								contas.get(indice(ag, bank, numc, tipo)).getLimitedeconta());
						System.out.printf("Limite de conta atual: %.2f\n",
								contas.get(indice(ag, bank, numc, tipo)).getLimiteatual());
					}
					
				}
				break;
			case 4:

				System.out.println("Informe Agência:");
				ag = scan.next();
				System.out.println("Informe Banco:");
				bank = scan.next();
				System.out.println("Número de conta:");
				numc = scan.next();
				System.out.println("informe o tipo de conta desejada:\n1: Poupança\n2: Corrente");
				tipo = scan.next();
				tipo = ConverterTipoConta(tipo);
				Double limiteConta = 0.0;
				if (tipo.equalsIgnoreCase("corrente")) {
					System.out.println("Informe o valor de limite da conta: ");
					limiteConta = scan.nextDouble();
					conta = new Conta(numc, bank, tipo, ag, limiteConta, limiteConta);
					contas.add(conta);
				}else {
					conta = new Conta(numc, bank, tipo, ag);
					contas.add(conta);
				}
				
				
				System.out.println("Conta criada com sucesso!");
				break;
			case 0:
				System.out.println("Prgorama Finalizado!");
				break;

			default:
				System.err.println("Opção Inválida!");
				break;
			}

		}

	}

}

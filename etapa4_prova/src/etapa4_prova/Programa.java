package etapa4_prova;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe um modelo, cor e Placa para o seu novo Carro:");

		Automovel carro = new Automovel(scan.next(), scan.next(), scan.next());
		short op = 0;
		short qtd = -1;
		System.out.println("Obs. Lembre-se que seu Carro possui Câmbio automático\n");
		do {
			if (carro.isLigado()) {
				System.out.println("1. Desligar Carro\n2. Acelerar\n3. frear\n4. Situação Atual\n5. Marcha Atual\n6. Velocidade atual");
				op = scan.nextShort();
				switch (op) {
				case 1:
					System.out.println(carro.desligar()+"\n");
					break;
				case 2:
					System.out.println("Informe quanto deseja acelerar:");
					qtd = scan.nextShort();
					carro.acelerar(qtd);
					System.out.println("Velocidade Atual: " + carro.getAtualVelocidade());
					System.out.println("Marcha Atual: " + carro.marchaAtual() + "\n");
					break;
				case 3:
					System.out.println("Informe quanto deseja frear:");
					qtd = scan.nextShort();
					carro.frear(qtd);
					System.out.println("Velocidade Atual: " + carro.getAtualVelocidade() + "\n");
					System.out.println("Marcha Atual: " + carro.marchaAtual() + "\n");
					break;
				case 4:
					System.out.println(carro.SituacaoParado() ? "O carro está parado\n" : "O carro está em Movimento\n");
					break;
				case 5:
					System.out.println("Marcha Atual: " + carro.marchaAtual()+"\n");
					break;
				case 6:
					System.out.println("Velocidade Atual: " + carro.getAtualVelocidade() + "\n");
					break;
				
				default:
					System.err.println("Opção Inválida!");
					break;
				}
			} else {
				System.out.println("0. Sair do simulador\n1. Ligar Carro\n2. Mostrar especificações do Automóvel");
				op = scan.nextShort();
				if (op == 1) {
					System.out.println(carro.ligar()+"\n");
				}else if(op == 2) {
					System.out.println(carro);
				}
				else if(op == 0) {
					System.out.println("\nPrograma Finalizado!\n");
				}
			}
			
			

		} while (op != 0);
		scan.close();

	}

}

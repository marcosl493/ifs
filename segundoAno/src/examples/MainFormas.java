package examples;

import java.util.Scanner;

public class MainFormas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op;
		do {
			System.out.println("1. Quadrado\n2.Retângulo\n3.Círculo\n4.Sair");
			op=scan.nextInt();
		} while (op!=4);
	scan.close();}

}

package examples;

import java.util.Scanner;

public class MainFormas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int op;
		do {
			System.out.println("1. Quadrado\n2.Ret�ngulo\n3.C�rculo\n4.Sair");
			op=scan.nextInt();
		} while (op!=4);
	scan.close();}

}

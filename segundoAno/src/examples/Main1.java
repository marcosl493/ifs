package examples;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
	static ArrayList<Pessoa> pessoas = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// TODO Auto-generated method stub
		String nome;
		String endereco;
		String data_nascimento;
		
		int op = 0;
		Aluno aluno;
		Funcionario funcionario;
		do {
			System.out.println("1.Adicionar funcionário\n2.Adicionar Aluno\n3.Consultar");
			op = scan.nextInt();
			switch (op) {
			case 1:
				System.out.println("Informe nome:");
				nome = scan.next();
				System.out.println("Informe endereço:");
				endereco = scan.next();
				System.out.println("Informe data de nascimento:");
				data_nascimento = scan.next();
				System.out.println("Informe salário:");
				double salario = scan.nextDouble();
				System.out.println("Informe o cargo");
				String cargo = scan.next();
				funcionario = new Funcionario(nome, endereco, data_nascimento, salario, cargo);
				pessoas.add(funcionario);
				break;
			case 2:
				System.out.println("Informe nome:");
				nome = scan.next();
				System.out.println("Informe endereço:");
				endereco = scan.next();
				System.out.println("Informe data de nascimento:");
				data_nascimento = scan.next();
				System.out.println("Informe curso:");
				String curso = scan.next();
				System.out.println("Informe semestre:");
				short semestre = scan.nextShort();
				aluno = new Aluno(nome, endereco, data_nascimento, curso, semestre);
				pessoas.add(aluno);
				break;
			case 3:
				for (int i = 0; i < pessoas.size(); i++) {
					System.out.print(pessoas.get(i).getNome());
					System.out.print(pessoas.get(i).getData_nascimento());
					System.out.println(pessoas.get(i).getEndereco());
				}
				
				break;
			case 0:
				op = 0;
				break;
			default:
				break;
			}

		} while (op != 0);
		scan.close();
	}

	
}

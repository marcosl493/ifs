package Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Entidades.Aviao;
import Entidades.Cliente;
public abstract class Arquivo {

	public static boolean existe(String diretorio) throws Exception {
		File file = new File(diretorio);
		return file.exists();
	}
	public static ArrayList<String> ler(String diretorio) throws Exception {
		ArrayList<String> linhas = new ArrayList<String>();
		FileReader fileReader = new FileReader(diretorio);
		BufferedReader buffer = new BufferedReader(fileReader);
		String linha;
		do {
			linha = buffer.readLine();
			if (linha != null)
				linhas.add(linha);
		} while (linha != null);
		buffer.close();
		return linhas;
	}

	public static void escrever(String diretorio, String conteudo, boolean append) throws Exception {
		FileWriter fileWriter = new FileWriter(diretorio, append);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(conteudo);
		printWriter.flush();
		printWriter.close();
	}

	public static void sobrescreverAviao(ArrayList<Aviao> array) {
		try {
			FileWriter avioes = new FileWriter("avioes.txt", false);
			PrintWriter wavioes = new PrintWriter(avioes);
			for (int i = 0; i < array.size(); i++) {
				wavioes.print(array.get(i).toString());
			}
			wavioes.flush();
			wavioes.close();
		} catch (IOException e) {
			System.out.print("Não foi possivel escrever os avioes: ");
			e.printStackTrace();
		}
	}
	public static void sobrescreverClientes(ArrayList<Cliente> array) {
		try {
			FileWriter avioes = new FileWriter("clientes.txt", false);
			PrintWriter wavioes = new PrintWriter(avioes);
			for (int i = 0; i < array.size(); i++) {
				wavioes.print(array.get(i).toString());
			}
			wavioes.flush();
			wavioes.close();
		} catch (IOException e) {
			System.out.print("Não foi possivel escrever os clientes: " );
			e.printStackTrace();
		}
	}
	
}

package uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questao {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linha;
		int N;
		while ((linha = br.readLine()) != null) {
			N = Integer.parseInt(linha);
			System.out.println(N - 1);
		}
	}

}

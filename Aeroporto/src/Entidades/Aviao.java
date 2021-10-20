package Entidades;

import java.util.ArrayList;

public class Aviao {
	private String idAviao;
	private String destino;
	private String data;
	private String horario;
	private int altura;

	private int largura;
	private boolean[][] poltronas;
	private int disponiveis;
	

	public Aviao(String id, String destino,String data, String horario,int altura, int largura,
			ArrayList<Posicao> posicoes) {
		this.idAviao = id;
		this.destino = destino;
		this.data = data;
		this.horario = horario;
		this.altura = altura;
		this.largura = largura;
		poltronas = new boolean[altura][largura];
		//metodo para setar atributos do avião;
		for(int i = 0; i < this.altura; i++) {
			for (int j = 0; j < this.largura; j++) {
				for(Posicao pos : posicoes) {
					if (pos.getPosLinha() == i &&
							pos.getPosColuna() == j)
						poltronas[i][j] = true;
				}
			}
		}
		int contPoltronas =largura*altura;
		for (int j = 0; j <altura; j++) {
			for (int j2 = 0; j2 < largura; j2++) {
				if ( poltronas[j][j2]==true) {
					contPoltronas--;
				}
			}
		}
	this.disponiveis=contPoltronas;
	}
	
	public String getDestino() {
		return destino;
	}
	public String getHorario() {
		return horario;
	}
	public String getData() {
		return data;
	}
	public String getIdAviao() {
		return idAviao;
	}
	public int getAltura() {
		return altura;
	}
	public int getLargura() {
		return largura;
	}
	public boolean[][] getPoltronas() {
		return poltronas;
	}
	public int getDisponiveis() {
		return disponiveis;
	}
	public void setDisponiveis(int disponiveis) {
		this.disponiveis = disponiveis;
	}
	public void ocuparPoltrona(Posicao pos) {
		poltronas[pos.getPosLinha()][pos.getPosColuna()] = true;
		disponiveis--;
	}
	public void desocuparPoltrona(Posicao pos) {
		poltronas[pos.getPosLinha()][pos.getPosColuna()] =false;
		disponiveis++;
	}
	public static void mostrarAviao(Aviao object) {
		System.out.println("Id do Aviao: " + object.getIdAviao());
		System.out.println(object.getHorario() + " " + object.getData());
		System.out.println("Cadeiras Disponiveis: "+object.getDisponiveis());
		System.out.println("=====================================================================================================================================================================================================================");
		for (int j = 0; j < object.getLargura(); j++) {
			System.out.print("\t" + j + ":" + "\t");
		}
		System.out.println("");
		// laco for para mostra as letras seguidas de poltronas
		for (int k = 0; k < object.getAltura(); k++) {
			System.out.print(k +":"+ "\t");
			for (int j = 0; j < object.getLargura(); j++) {
				if (object.getPoltronas()[k][j] == true) {
					System.out.print("Ocupado "+"\t");
				}
				if (!object.getPoltronas()[k][j] == true) {
					System.out.print("Disponível "+"\t");
				}
			}
			System.out.println("");
		}System.out.println("======================================================================================================================================================================================================================================================");
	}

	
	@Override
	public String toString() {
		String retorno = "";
		retorno += idAviao + ";";
		retorno +=  destino + ";";
		retorno += data + ";";
		retorno += horario + ";";
		retorno += altura + ";";
		retorno += largura + "\n";
		for(int i=0; i < altura; i++) {
			for (int j=0; j < largura; j++) {
				retorno += (poltronas[i][j]) + " "; 
			}
			retorno += "\n";
		}//método para gravar no txt;
		return retorno;
	}
	public static void mostrarAviaoSemMatriz(Aviao object) {
		System.out.println("=====================================================================================================================================================================================================================");
		System.out.println("Id do Aviao: " + object.getIdAviao());
		System.out.println(object.getHorario() + " " + object.getData());
		System.out.println("Cadeiras Disponiveis: "+object.getDisponiveis());
		System.out.println("======================================================================================================================================================================================================================================================");
	}
}
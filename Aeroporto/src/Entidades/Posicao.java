package Entidades;

public class Posicao {
	private int posLinha;
	private int posColuna;
	
	public Posicao(int l, int c) {
		this.posLinha = l;
		this.posColuna = c;
	}
	
	public int getPosLinha() {
		return posLinha;
	}

	public void setPosLinha(int posLinha) {
		this.posLinha = posLinha;
	}

	public int getPosColuna() {
		return posColuna;
	}

	public void setPosColuna(int posColuna) {
		this.posColuna = posColuna;
	}
}

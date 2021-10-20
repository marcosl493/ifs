package Entidades;

import java.util.ArrayList;

public class Aeroporto {
	private ArrayList<Aviao> avioes;
	
	public Aeroporto() {
		avioes = new ArrayList<Aviao>();
	}
	
	public ArrayList<Aviao> getAvioes() {
		return this.avioes;
	}
	
	@Override
	public String toString() {
		String retorno =  "";
		
		for(Aviao aviao : avioes) {
			retorno += aviao.toString() + "\n\n";
		}
		return retorno;
	}
}

package examples;

public class Computador {
	private String processador;
	private int qtdmemoriar;
	private String modelplacamae;
	private boolean hasdvd;
	private double preco;
	

	public Computador(String processador, int qtdmemoriar, String modelplacamae, boolean hasdvd, double preco) {
		this.processador = processador;
		this.qtdmemoriar = qtdmemoriar;
		this.modelplacamae = modelplacamae;
		this.hasdvd = hasdvd;
		this.preco = preco;
	}
	public Computador(String processador, int qtdmemoriar, String modelplacamae, double preco) {
		this.processador = processador;
		this.qtdmemoriar = qtdmemoriar;
		this.modelplacamae = modelplacamae;
		this.preco = preco;
	}
	public Computador() {
		
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public int getQtdmemoriar() {
		return qtdmemoriar;
	}

	public void setQtdmemoriar(int qtdmemoriar) {
		this.qtdmemoriar = qtdmemoriar;
	}

	public String getModelplacamae() {
		return modelplacamae;
	}

	public void setModelplacamae(String modelplacamae) {
		this.modelplacamae = modelplacamae;
	}

	public boolean isHasdvd() {
		return hasdvd;
	}

	public void setHasdvd(boolean hasdvd) {
		this.hasdvd = hasdvd;
	}

	public Computador(String a) {
		this.processador = a;
	}
}

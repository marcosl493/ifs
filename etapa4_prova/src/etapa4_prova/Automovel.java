package etapa4_prova;

public class Automovel {
	private String modelo;
	private String cor;
	private short atualVelocidade;
	private String placa;
	private boolean ligado;

	public Automovel(String modelo, String cor, String placa) {
		this.modelo = modelo;
		this.cor = cor;
		this.atualVelocidade = 0;
		this.placa = placa;
		this.ligado = false;
	}
	public Automovel() {
		
	}
	public boolean SituacaoParado() {
		return 0 == this.atualVelocidade;
	}

	public short marchaAtual() {
		if (this.atualVelocidade <= 40) {
			return 1;
		} else if (this.atualVelocidade <= 60) {
			return 2;
		} else if (this.atualVelocidade <= 80) {
			return 3;
		} else if (this.atualVelocidade <= 100) {
			return 4;
		} else if (this.atualVelocidade > 100) {
			return 5;
		}
		return -1;
	}

	public String getModelo() {
		return modelo;
	}


	public String getCor() {
		return cor;
	}

	public short getAtualVelocidade() {
		return atualVelocidade;
	}

	public String getPlaca() {
		return placa;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void acelerar(short qtd) {
		this.atualVelocidade += qtd;
	}

	public void frear(short qtd) {
		if(this.atualVelocidade - qtd < 0) {
			this.atualVelocidade = 0;
		} else {
			this.atualVelocidade -= qtd;
		}
			
		
	}

	public String ligar() {
		if (this.ligado) {
			return "Já está ligado!";
		} else {
			this.ligado = true;
			return "O Automóvel foi ligado";
		}
	}

	public String desligar() {
		if (!this.ligado) {
			return "O automóvel já está desligado";
		} else if (this.ligado && SituacaoParado()) {
			this.ligado = false;
			return "O automóvel foi desligado";
		} else
			return "O automóvel não está parado, não foi possível desligar! ;-;";
	}
	public String toString() {
		return "Modelo: "+this.getModelo()+" | Cor: "+this.getCor()+" | Placa: "+this.getPlaca()+"\n";
	}
}

package etapa3_prova;

public abstract class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private short ano;
	private double kmrodados;
	private double kminicial;
	private double kmfinal;
	private boolean alugado;
	public boolean isAlugado() {
		return alugado;
	}
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	public Veiculo(String placa, String marca, String modelo, short ano, double kminicial) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.kminicial = kminicial;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public short getAno() {
		return ano;
	}
	public void setAno(short ano) {
		this.ano = ano;
	}
	public double getKmrodados() {
		return kmrodados;
	}
	public void setKmrodados(double kmrodados) {
		this.kmrodados = kmrodados;
	}
	public double getKminicial() {
		return kminicial;
	}
	public void setKminicial(double kminicial) {
		this.kminicial = kminicial;
	}
	public double getKmfinal() {
		return kmfinal;
	}
	public void setKmfinal(double kmfinal) {
		this.kmfinal = kmfinal;
	}
	public abstract double valor(double kmatuall, double valorkm);
}

package etapa3_prova;

public class Passeio extends Veiculo{
	private boolean arcondicionado;
	private boolean portas2;
	public Passeio(String placa, String marca, String modelo, short ano,
			double kminicial, boolean arcondicionado, boolean portas2) {
		super(placa, marca, modelo, ano, kminicial);
		this.arcondicionado = arcondicionado;
		this.portas2 = portas2;
		// TODO Auto-generated constructor stub
	}
	public boolean isArcondicionado() {
		return arcondicionado;
	}
	public void setArcondicionado(boolean arcondicionado) {
		this.arcondicionado = arcondicionado;
	}
	public boolean isPortas2() {
		return portas2;
	}
	public void setPortas2(boolean portas2) {
		this.portas2 = portas2;
	}
	public double valor(double kmatuall, double valorkm) {
		double kmrodados = Math.abs(kmatuall-this.getKminicial());
		double valortotal=(kmrodados*valorkm);
		return valortotal;
	}


}

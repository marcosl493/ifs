package etapa3_prova;

public class Carga extends Veiculo {
	private double capacidade;

	public Carga(String placa, String marca, String modelo, short ano, double kminicial, double capacidade) {
		super(placa, marca, modelo, ano, kminicial);
		// TODO Auto-generated constructor stub
		this.capacidade = capacidade;
	}

	public double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
	@Override
	public double valor(double kmatuall, double valorkm) {
		double kmrodados = Math.abs(kmatuall - this.getKminicial());
		double valortotal = ((kmrodados * valorkm) * 10 / 100) + (kmrodados * valorkm);
		return valortotal;
	}
}

package examples;

public class Quadrado extends FormaGeometrica {
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double area() {

		return this.getLado() * 2;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return this.getLado() * 4;
	}

}

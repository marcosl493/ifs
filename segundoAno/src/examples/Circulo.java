package examples;

public class Circulo extends FormaGeometrica{
	public final double pi=3.14;
	private double raio;
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	@Override
	public double area() {
		
		return this.getRaio()*pi;

	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return this.getRaio()*(2*pi);
	}
}

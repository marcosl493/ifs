package examples;

public class Retangulo extends FormaGeometrica {
	private double base;
	private double altura;
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	@Override
	public double area() {
		return this.getAltura()*this.getBase();

	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (this.getAltura()+this.getBase())*2;
	}
}

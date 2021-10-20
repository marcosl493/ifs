package examples;

public class Funcionario extends Pessoa{
public Funcionario(String nome, String endereco, String data_nascimento, double salario, String cargo) {
		super(nome, endereco, data_nascimento);
		// TODO Auto-generated constructor stub
		this.salario = salario;
		this.cargo = cargo;
	}
private double salario;
private String cargo;
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
}

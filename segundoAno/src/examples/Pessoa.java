package examples;

public class Pessoa {
private String nome;
private String endereco;
private String data_nascimento;
public Pessoa(String nome,String endereco, String data_nascimento ) {
	this.nome = nome;
	this.endereco = endereco;
	this.data_nascimento = data_nascimento;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getData_nascimento() {
	return data_nascimento;
}
public void setData_nascimento(String data_nascimento) {
	this.data_nascimento = data_nascimento;
}

}

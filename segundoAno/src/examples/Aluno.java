package examples;

public class Aluno extends Pessoa {
public Aluno(String nome, String endereco, String data_nascimento, String curso, short semestre) {
		super(nome, endereco, data_nascimento);
		// TODO Auto-generated constructor stub
		this.curso = curso;
		this.semestre = semestre;
	}
private String curso;
private short semestre;
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}
public short getSemestre() {
	return semestre;
}
public void setSemestre(short semestre) {
	this.semestre = semestre;
}


	

}

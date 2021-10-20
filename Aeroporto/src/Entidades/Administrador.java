package Entidades;

import Util.Arquivo;

public class Administrador {
	private String nome;
	private String senha;
	
	public Administrador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	
	public void salvar(String diretorio) throws Exception {
		Arquivo.escrever(diretorio, nome + ";" + senha, false);
	}
	
	public boolean validarAcesso(String nome, String senha) {
		return this.nome.equals(nome) && this.senha.equals(senha);
	}
}

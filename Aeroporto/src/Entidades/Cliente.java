package Entidades;

public class Cliente {
	private String nome;
	private String rg;
	private String telefone;
	private String cpf;
	private int poltronaLinha;
	private int poltronaColuna;
	private String idAviao;
	
	public Cliente(String nome, String rg, String tel, String cpf, 
			String idAviao,int poltronaLinha, int poltronaColuna) {
		this.nome = nome;
		this.rg = rg;
		this.telefone = tel;
		this.cpf = cpf;
		this.idAviao = idAviao;
		this.poltronaLinha = poltronaLinha;
		this.poltronaColuna = poltronaColuna;
		
	}
	
	public String getNome() {
		return nome;
	}

	public String getRg() {
		return rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public int getPoltronaLinha() {
		return poltronaLinha;
	}

	public int getPoltronaColuna() {
		return poltronaColuna;
	}

	public String getIdAviao() {
		return idAviao;
	}

	@Override
	public String toString() {
		String retorno = "";
		retorno +=  nome + ";";
		retorno += rg + ";";
		retorno += telefone + ";";
		retorno += cpf + ";";
		retorno +=idAviao + ";";
		retorno += poltronaLinha + ";";
		retorno += poltronaColuna + "\n";
		
		return retorno;
	}
}

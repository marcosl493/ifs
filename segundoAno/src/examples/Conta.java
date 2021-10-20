package examples;

public class Conta {

	private double saldo;
	private String num_conta;
	private String banco;
	private String tipoConta;
	private String agencia;
	private double limiteatual;
	private double limitedeconta;

	public Conta(String num_conta, String banco, String tipoConta, String agencia, double limiteatual,
			double limitedeconta) {
		this.num_conta = num_conta;
		this.banco = banco;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
		this.limiteatual = limiteatual;
		this.limitedeconta = limitedeconta;
	}

	public Conta(String num_conta, String banco, String tipoConta, String agencia) {
		this.num_conta = num_conta;
		this.banco = banco;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
	}

	public double getLimiteatual() {
		return limiteatual;
	}

	public void setLimiteatual(double limiteatual) {
		this.limiteatual = limiteatual;
	}

	public double getLimitedeconta() {
		return limitedeconta;
	}

	public void setLimitedeconta(double limitedeconta) {
		this.limitedeconta = limitedeconta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNum_conta() {
		return num_conta;
	}

	public void setNum_conta(String num_conta) {
		this.num_conta = num_conta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void depositar(double valor) {
		if (this.limiteatual == this.limitedeconta) {
			this.saldo += valor;
		} else if (this.limitedeconta - this.limiteatual >= valor) {
			this.limiteatual += valor;
		} else if (this.limitedeconta - this.limiteatual < valor) {
			valor -= this.limitedeconta - this.limiteatual;
			this.limiteatual += this.limitedeconta - this.limiteatual;

			this.saldo += valor;
		}

	}

	public int sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return 1;
		} else if (saldo < valor && valor <= limiteatual && this.tipoConta.equalsIgnoreCase("Corrente")) {
			valor -= this.saldo;
			this.saldo = 0;
			this.limiteatual -= valor;
			return 0;
		}
		return -1;

	}
}

package amdantas.aula02.exercicio4;

public class ContaBancaria {

	
	private String agencia;
	
	private String conta;
	
	private Double saldo;
	
	private boolean contaValida;

	public ContaBancaria(String ag, String cc) {
		agencia = ag;
		conta = cc;
	}

	public void exibirSaldo() {
		System.out.println("Saldo: " + getSaldo());
		System.out.println("============================");
	}
	
	public void realizarSaque(Double valor) {
		if (validarSaque(valor)) {
			saldo -= valor;
		} else {
			System.out.println("Conta sem saldo");
		}
		exibirSaldo();
	}
	
	private boolean validarSaque(Double valor) {
		return saldo != null && saldo > 0.0;
	}

	public void depositar(Double valor) {
		saldo+=valor;
		exibirSaldo();
	}
	
	public boolean entrar ( ) {
		if ("1234-X".equals(agencia) && ("23455".equals(conta) || "7865746".equals(conta) || "651321".equals(conta))) {
			saldo = 0.0;
			return true;
		}
		return false;
	}
	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public boolean isContaValida() {
		return contaValida;
	}

	public void setContaValida(boolean contaValida) {
		this.contaValida = contaValida;
	}
	
	
	
}

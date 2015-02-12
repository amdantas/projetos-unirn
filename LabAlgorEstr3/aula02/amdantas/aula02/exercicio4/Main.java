package amdantas.aula02.exercicio4;

public class Main {

	public static void main(String[] args) {
		
		String agencia = "1234-X";
		String cc = "7865746";
		
		ContaBancaria contaBancaria = new ContaBancaria(agencia, cc);
		
		boolean entradaValida = contaBancaria.entrar();
		if (entradaValida) {
			contaBancaria.exibirSaldo();
			contaBancaria.depositar(100.0);
			contaBancaria.realizarSaque(55.0);
			contaBancaria.realizarSaque(55.0);
			contaBancaria.realizarSaque(1.0);
			contaBancaria.depositar(33.0);
		} else {
			System.err.println("Conta inválida");
		}
		
		
	}
}

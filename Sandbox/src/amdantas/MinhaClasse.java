package amdantas;

public class MinhaClasse implements ComportamentoPadraoInt {

	
	public void novaOperacao() {
		System.out.println("Executando novaOperacao em MinhaClasse");
	}
	
	@Override
	public void operacao1() {
		System.out.println("Executando operacao1 em MinhaClasse");
	}

	@Override
	public void operacao2(String p1, String p2) {
		System.out.print("Executando operacao2 em MinhaClasse; ");
		System.out.println("Valores dos parâmetros: " + p1 + ", "+p2);
	}

	@Override
	public void operacao3(int i) {
		System.out.print("Executando operacao3 em MinhaClasse; ");
		System.out.println("Valores do parâmetro: " + i);
	}

}

package amdantas;

public class MinhaClasse implements ComportamentoPadraoInt {

	@Override
	public void operacao1() {
		System.out.println("Executando operacao1 em MinhaClasse");
	}

	@Override
	public void operacao2(String p1, String p2) {
		System.out.print("Executando operacao2 em MinhaClasse; ");
		System.out.println("Valores dos par�metros: " + p1 + ", "+p2);
	}

	@Override
	public void operacao3(int i) {
		System.out.print("Executando operacao3 em MinhaClasse; ");
		System.out.println("Valores do par�metro: " + i);
	}

}

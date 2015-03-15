package amdantas;

public class OutraClasse implements ComportamentoPadraoInt {

	@Override
	public void operacao1() {
		System.out.println("Executando operacao1 em OutraClasse");
	}

	@Override
	public void operacao2(String p1, String p2) {
		System.out.print("Executando operacao2 em OutraClasse; ");
		System.out.println("Valores dos parâmetros: " + p1 + ", "+p2);
	}

	@Override
	public void operacao3(int i) {
		System.out.print("Executando operacao3 em OutraClasse; ");
		System.out.println("Valores do parâmetro: " + i);
	}

}

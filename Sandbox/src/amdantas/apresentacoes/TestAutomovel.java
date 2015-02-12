package amdantas.apresentacoes;

public class TestAutomovel {

	public static void main(String[] args) {
		
		Automovel fusca = new Automovel();

		Automovel palio1 = new Automovel("ASD-1234", "Branca", "gasolina", 750);
		Automovel palio2 = new Automovel("ASD-1234", "Branca", "gasolina", 750);
		
		System.out.println(palio1.equals(palio2));
		
		System.out.println(palio1.toString());
		System.out.println(palio2.toString());
		
		
		
//		
//		palio.setCombustivel(null);
//		
//		System.out.println(Automovel.formatoPlaca);
//
//		System.out.println(fusca.formatoPlaca);
//		
//		fusca.setCor("amarelo");
//		fusca.setCombustivel("gasolina");
//		fusca.setPlaca("MVT-2332");
//		fusca.setPotenciaMotor(25);
//		
//		String corDoFusca = fusca.getCor();
//		
//		
//		
//		System.out.println(corDoFusca);
	}
	
}

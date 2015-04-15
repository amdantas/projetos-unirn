package amdantas;


public class Main {

	private static int QTD_ANIMAIS = 3;
	
	public static void main(String[] args) {
		
		
		 
//		for (int i = 0; i < animais.length; i++) {
//			boolean ehCachorro = animais[i] instanceof Cachorro;
//			if (ehCachorro) {
//				Cachorro c = (Cachorro) animais[i];
//				c.late();
//			} else {
//				Gato g = (Gato) animais[i];
//				g.mia();
//			}
//		}
		
		Animal[] animais = new Animal[3];
		for (int i = 0; i < animais.length; i++) {
			Animal a = animais[i];
			a.emitirSom();
		}
		
		ComportamentoAnimalInt[] criaturas = new ComportamentoAnimalInt[3];
		criaturas[0] = new Cachorro();
		criaturas[0] = new Gato();
		criaturas[0] = new Pessoa();
		
		for (int i = 0; i < criaturas.length; i++) {
			ComportamentoAnimalInt c = criaturas[i];
			c.emitirSom();
			c.comer();
			c.caminhar();
		}
		
		
		 
		
	}
	
}

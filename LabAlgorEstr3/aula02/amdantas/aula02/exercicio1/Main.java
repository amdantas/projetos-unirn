package amdantas.aula02.exercicio1;

import static amdantas.util.Util.exibirMsg;
import static amdantas.util.Util.lerEntrada;

public class Main {

	private static int QTD_ANIMAIS = 3;
	
	public static void main(String[] args) {
		
		
		for (int i = 0; i < QTD_ANIMAIS; i++) {
			
			boolean entradaValida = false;
			int tipo = 0;
			do {
				String entrada = lerEntrada("Qual o tipo de animal? (1 - Cachorro, 2 - Gato)");
				try {
					tipo = Integer.parseInt(entrada);
					if (tipo >= 1 && tipo <= 2)
						entradaValida = true;
				} catch (NumberFormatException e) {
					entradaValida = false;
				}
			} while (!entradaValida);
			
			Animal animal = null;
			if (tipo == 1)
				animal = new Cachorro();
			else 
				animal = new Gato();
			
			animal.setNomeAnimal(lerEntrada("Nome do animal?"));
			animal.setNomeDono(lerEntrada("Nome do dono?"));
//			animais[i] = animal;
		}
		StringBuilder msg = new StringBuilder("Resultado:\r\n");
		Animal[] animais = new Animal[QTD_ANIMAIS];
		for (int i = 0; i < animais.length; i++) {
			if (animais[i] instanceof Cachorro) {
				Cachorro c = (Cachorro) animais[i];
				c.late();
			} else if (animais[i] instanceof Gato) {
				Gato g = (Gato) animais[i];
				g.mia();
			}
		}
		
		exibirMsg(msg.toString());
		
	}
	
}

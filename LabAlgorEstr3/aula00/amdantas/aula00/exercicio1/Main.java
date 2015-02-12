package amdantas.aula00.exercicio1;

import static amdantas.util.Util.exibirMsg;
import static amdantas.util.Util.lerEntrada;



public class Main {

	
	public static void main(String[] args) {
		
		Object[] vetor = new Object[4];
		
		for (int i=0; i<4;i++) {
			String entrada = lerEntrada("Digite uma entrada ("+i+"/"+vetor.length+")");
			try {
				Integer inteiro = Integer.parseInt(entrada);
				vetor[i] =  inteiro;
			}catch (NumberFormatException ne) {
				vetor[i] = entrada;
			}
		}
		
		int numInteiros = 0;
		int numString = 0;

		for (Object elem : vetor) {
			if (elem instanceof Integer)
				numInteiros++;
			if (elem instanceof String)
				numString++;
		}
		
		exibirMsg("Número de elementos inteiros: " + numInteiros +"\r\n"+
				"Número de elementos String: "+ numString);
				
		
	}
}

package amdantas.aula01.exercicio3;

import static amdantas.util.Util.exibirMsg;

public class Main {

	
	public static void main(String[] args) {
		
		String[] string1 = {"B","R","A","S","I","L"};
		String[] string2 = {"U","N","I","-","R","N"};

		int tamanho = string1.length;
		
		String letrasAchadas = "";
		for (int i = 0; i < tamanho; i++) {
			String letra = string1[i];
			for (int j = 0; j < tamanho; j++) {
				if (letra.equals(string2[j]) && !letrasAchadas.contains(string2[j])) 
					letrasAchadas += string2[j] + ",";
			}
		}
		
		if (letrasAchadas.isEmpty())
			exibirMsg("Nenhuma letra igual");
		else
			exibirMsg("Letras iguais: " + letrasAchadas);
		
	}
}

package amdantas.aula01.exercicio2;

import static amdantas.util.Util.exibirMsg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Integer[] vetor = new Integer[4];
		
		for (int i = 0; i < vetor.length; i++) {
			boolean entradaValida = true;
			do {
				String msg = "Digite um n�mero inteiro:";
				if (!entradaValida) {
					msg = "Entrada inv�lida!\r\n" + msg;
				}
				entradaValida = true;
				System.out.println(msg);
				try {
//					String entrada = scan.next();
					vetor[i] = scan.nextInt();
				} catch (Exception e) {
					entradaValida = false;
					scan.nextLine();
				}
			} while (!entradaValida);
		}
		
		
		int maior = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] > maior) 
				maior = vetor[i];
		}
		
		exibirVetor(vetor);
		
		exibirMsg("O maior n�mero �: " +  maior);
		
	}

	private static void exibirVetor(Integer[] vetor) {
		String msg = "";
		for (int i = 0; i < vetor.length; i++) {
			msg += vetor[i] + ",";
		}
		exibirMsg(msg);
	}
	
}

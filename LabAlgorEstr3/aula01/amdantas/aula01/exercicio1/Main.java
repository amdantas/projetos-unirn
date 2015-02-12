package amdantas.aula01.exercicio1;

public class Main {

	public static void main(String[] args) {

		int[] vetor = new int[] { 2, 4, 6, 8, 10, 12 };
		for (int i = 0; i <= 12; i++) {
			try {
				System.out.println(vetor[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Vetor terminou, não precisa percorre-lo mais");
				break;
			}
		}

	}

}

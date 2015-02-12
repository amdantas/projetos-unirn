package amdantas.aula00.exercicio2;

public class Main {

	public static void main(String[] args) {
		
		// vetor de vetores
		int[][] vetoresOriginais = {
				{ 1, 2, 3, 4, 5},
				{ 6, 7, 8, 9, 10},
				{ 11, 12, 13, 14, 15}
		};
		
		int[][] vetoresResultantes = new int[5][3];
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				vetoresResultantes[i][j] = vetoresOriginais[j][i];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(vetoresResultantes[i][j] + ",");
			}
			System.out.println("");
		}
		
	}
	
}

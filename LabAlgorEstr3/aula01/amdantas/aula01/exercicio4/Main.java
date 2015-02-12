package amdantas.aula01.exercicio4;

public class Main {

	
	public static void main(String[] args) {
		
		Double[] vetor = {23.3, 54.0, 65.4, 23.5, 54.9, 23.0, 11.0, 24.0, 65.433};
		
		Integer[] inteiros = new Integer[vetor.length];
		
		for (int i = 0; i < vetor.length; i++) {
			Double d = vetor[i];
			Integer inteiro =  d.intValue();
			if (!inteiroPresente(inteiros, inteiro)) {
				inteiros[i] = inteiro;
			}
		}
		String msg= "";
		for (Integer i : inteiros) {
			if (i != null) 
				msg += i + ",";
		}
		
		System.out.println(msg);
		
	}

	private static boolean inteiroPresente(Integer[] inteiros, Integer inteiro) {
		for (Integer i : inteiros) {
			if (inteiro.equals(i))
				return true;
		}
		return false;
	}
}

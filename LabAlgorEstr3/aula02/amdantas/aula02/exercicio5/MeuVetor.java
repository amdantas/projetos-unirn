package amdantas.aula02.exercicio5;

public class MeuVetor {

	
	private int[] v;
	
	public MeuVetor(int tamanho) {
		v = new int[tamanho];
	}
	
	public void adicionarElemento(int posicao, int elemento) {
		v[posicao] = elemento;
	}
	
	public void exibirElementos() {
		for (int i = 0; i < v.length; i++) {
			System.out.println("Posição " + i + ": " + v[i]);
		}
	}
}

package amdantas.apresentacoes;

public class TesteElemento {

	public static void main(String[] args) {
		
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona(new Elemento("elemento 1"));
		lista.adiciona(new Elemento("elemento 2"));
		
		lista.exibirLista();
		
		
		int[] vetor =  {4, 6, 8, 9};
		
	}
	
}

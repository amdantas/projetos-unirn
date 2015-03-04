package amdantas.aula03.exercicio02;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona(new Elemento("elemento 1"));
		lista.adiciona(new Elemento("elemento 2"));
		lista.adiciona(new Elemento("elemento 3"));
		lista.adiciona(new Elemento("elemento 4"));
		lista.adiciona(new Elemento("elemento 5"));
		
		lista.exibirLista();
		lista.exibirListaComRecursividade();
		
	}
}

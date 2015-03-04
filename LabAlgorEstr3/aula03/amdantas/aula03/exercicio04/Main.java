package amdantas.aula03.exercicio04;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		
		ListaEncadeada lista = new ListaEncadeada();
		
		lista.adiciona(new Elemento("Andr�"));
		lista.adiciona(new Elemento("Jo�o"));
		lista.adiciona(new Elemento("Marco"));
		lista.adiciona(new Elemento("Maria"));
		
		lista.exibirLista();
		
		ListaEncadeada listaInvertida = inverterLista(lista);
		listaInvertida.exibirLista();
		
	}

	private static ListaEncadeada inverterLista(ListaEncadeada lista) {
		ListaEncadeada invertida = new ListaEncadeada();
		Elemento elem = lista.getUltimo();
		invertida.adiciona(elem);
		Elemento apontado = lista.quemAponta(elem);
		while (apontado !=null) {
			invertida.adiciona(apontado);
			apontado = lista.quemAponta(apontado);
		}
		return invertida;
	}

}

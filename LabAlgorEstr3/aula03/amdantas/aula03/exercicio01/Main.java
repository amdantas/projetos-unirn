package amdantas.aula03.exercicio01;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		Elemento e1 = new Elemento();
		e1.setInfo("elemento 1");
		lista.adiciona(e1);

		Elemento e2 = new Elemento();
		e1.setInfo("elemento 2");
		lista.adiciona(e2);
		
		Elemento e3 = new Elemento();
		e1.setInfo("elemento 3");
		lista.adiciona(e3);
		
		lista.adiciona(new Elemento("elemento 1"));
		lista.adiciona(new Elemento("elemento 2"));
		lista.adiciona(new Elemento("elemento 3"));
		lista.adiciona(new Elemento("elemento 4"));
		lista.adiciona(new Elemento("elemento 5"));
		
		lista.exibirLista();
		lista.exibirListaComRecursividade();
		System.out.println(lista.busca(0));
		System.out.println(lista.busca(3).getInfo());
		System.out.println(lista.busca(6));
		Elemento obj = lista.busca("elemento 5");
		System.out.println(obj.getInfo());
		System.out.println(lista.contem(new Elemento("elemento 5")));
		System.out.println(lista.contem(new Elemento("elemento 05")));
		
		
		System.out.println(lista.remover(new Elemento("elemento 2")));
		lista.exibirLista();
		System.out.println(lista.remover(new Elemento("elemento 1")));
		lista.exibirLista();
		System.out.println(lista.remover(new Elemento("elemento 5")));
		lista.exibirLista();
		lista.adiciona(new Elemento("elemento 88"));
		lista.exibirLista();
		
		
	}
}

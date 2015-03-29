package amdantas.aula05.exercicio02;

import amdantas.estruturas.ElementoDuplo;
import amdantas.estruturas.ListaDupla;

public class Main {
	public static void main(String[] args) {
		ListaDupla l = new ListaDupla();
		l.adicionar(new ElementoDuplo(23));
		l.adicionar(new ElementoDuplo(1));
		l.adicionar(new ElementoDuplo(21));
		l.adicionar(new ElementoDuplo(43));
		l.adicionar(new ElementoDuplo(20));
		l.exibir();
		
		ListaDupla ordenada = new ListaDupla();
		ElementoDuplo e = l.getElementoPrincipal();
		while (e != null) {
			ordenada.adicionaOrdenadoSimples(new ElementoDuplo(e.getInfo()));
			e = e.getProximo();
		}
		ordenada.exibir();
	}
}

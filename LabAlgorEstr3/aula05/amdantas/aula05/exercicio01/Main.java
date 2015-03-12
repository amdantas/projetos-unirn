package amdantas.aula05.exercicio01;

import amdantas.estruturas.ElementoDuplo;
import amdantas.estruturas.ListaDupla;

public class Main {

	public static void main(String[] args) {
		ListaDupla l = new ListaDupla();
		l.adicionaOrdenado(new ElementoDuplo(20));
		l.adicionaOrdenado(new ElementoDuplo(3));
		l.adicionaOrdenado(new ElementoDuplo(7));
		l.exibir();
		l.adicionaOrdenado(new ElementoDuplo(5));
		l.exibir();
	}	
}

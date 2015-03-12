package amdantas.aula02.exercicio6;

import amdantas.estruturas.FilaEstatica;

public class Main {

	
	public static void main(String[] args) {
		
		FilaEstatica fila = new FilaEstatica(3);
		
		System.out.println(fila);
		fila.inserir("teste1");
		fila.inserir("teste2");
		fila.inserir("teste3");
		System.out.println(fila);
		fila.remover();
		fila.inserir("teste4");
		System.out.println(fila);
		fila.remover();
		fila.remover();
		System.out.println(fila);
		
		
	}
}

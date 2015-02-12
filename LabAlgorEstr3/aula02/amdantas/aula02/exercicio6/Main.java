package amdantas.aula02.exercicio6;

import amdantas.estruturas.Fila;

public class Main {

	
	public static void main(String[] args) {
		
		Fila fila = new Fila(3);
		
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

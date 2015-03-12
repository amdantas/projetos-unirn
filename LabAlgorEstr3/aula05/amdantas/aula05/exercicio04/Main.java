package amdantas.aula05.exercicio04;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.Fila;

public class Main {

	public static void main(String[] args) {
		Fila f = new Fila();
		f.enfileirar(new Elemento("Primeiro") );
		f.enfileirar(new Elemento("Segundo") );
		f.enfileirar(new Elemento("Terceiro") );
		System.out.println(f);
		f.desenfileirar();
		System.out.println(f);
	}
	
}

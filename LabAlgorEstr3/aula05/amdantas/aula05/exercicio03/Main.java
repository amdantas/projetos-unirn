package amdantas.aula05.exercicio03;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.Pilha;

public class Main {
	public static void main(String[] args) {
		Pilha p = new Pilha();
		p.push(new Elemento("1"));
		p.push(new Elemento("2"));
		p.push(new Elemento("4"));
		System.out.println(p);
		p.pop();
		System.out.println(p);
		p.push(new Elemento("9"));
		System.out.println(p);
	}
}

package amdantas.aula05.exercicio03;

import amdantas.estruturas.Elemento;
import amdantas.estruturas.Pilha;

public class Main {
	public static void main(String[] args) {
		Pilha p = new Pilha();
		Elemento e1 = new Elemento();
		e1.setInfo("1");
		System.out.println(e1);
		p.push(e1 );
		
		p.push(new Elemento("2"));
		p.push(new Elemento("4"));
		
		System.out.println(p);
		Elemento eRetirado = p.pop();
		System.out.println(p);
		p.push(new Elemento("9"));
		System.out.println(p);
		
		String s = p + "3";
	}
}

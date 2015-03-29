package amdantas.prova01.exercicio03;

import amdantas.prova01.exercicio02.Elemento;

public class Pilha {

	private Elemento prim;
	
	public void push(Elemento e) {
		e.setProximo(prim);
		prim = e;
		
	}
	public Elemento pop() {
		Elemento e = prim;
		if (e != null)
			prim = e.getProximo();
		return e;
	}
	
	@Override
	public String toString() {
		String s = "";
		Elemento e = prim;
		while (e != null) {
			s += "[" + e.getInfo() + "] ";
			e = e.getProximo();
		}
		return s;
	}
	public void exibirComRecursividade() {
		System.out.println(toString());
	}	
}

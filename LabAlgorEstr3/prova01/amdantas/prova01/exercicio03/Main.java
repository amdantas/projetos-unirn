package amdantas.prova01.exercicio03;

import amdantas.prova01.exercicio02.Elemento;

public class Main {

public static void main(String[] args) {
	Pilha pilha = new Pilha();
	pilha.push(new Elemento(23));
	pilha.push(new Elemento(12));
	pilha.exibirComRecursividade();
	Elemento e = pilha.pop();
	System.out.println("Retirado: " + e.getInfo());
	pilha.exibirComRecursividade();
}
	
}

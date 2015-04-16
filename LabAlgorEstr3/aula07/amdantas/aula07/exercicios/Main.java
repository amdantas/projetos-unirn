package amdantas.aula07.exercicios;

import amdantas.estruturas.ArvoreBinaria;

public class Main {

	public static void main(String[] args) {
		
		ArvoreBinaria a = new ArvoreBinaria();
		a.inserirNo(6);
		a.inserirNo(10);
		a.inserirNo(13);
		a.inserirNo(3);
		a.inserirNo(5);
		System.out.println("Pos ordem");
		a.exibirPosOrdem();
		System.out.println();
		System.out.println("Pre ordem");
		a.exibirPreOrdem();
		System.out.println();
		System.out.println("Em ordem");
		a.exibirEmOrdem();
		System.out.println();
		System.out.println(a.buscar(3).getInfo());
		System.out.println(a.buscar(13).getInfo());
		System.out.println(a.buscar(333));
		System.out.println("soma: " + a.somaTodos());
		a.remover(10);
		System.out.println("Em ordem");
		a.exibirEmOrdem();
		
	}
	
}

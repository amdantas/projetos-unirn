package amdantas.aula03.exercicio02;

import amdantas.estruturas.ElementoInteiro;
import amdantas.estruturas.ListaEncadeadaInteiro;

public class Main {

	public static void main(String[] args) {
		int[] vetor =  {4, 6, 8, 9};
		
		ListaEncadeadaInteiro lista = transformarEmLista(vetor);
		lista.exibirLista();
	}

	private static ListaEncadeadaInteiro transformarEmLista(int[] vetor) {
		ListaEncadeadaInteiro lista = new ListaEncadeadaInteiro();
		for (int i : vetor) {
			lista.adiciona(new ElementoInteiro(i));
		}
		return lista;
	}
	
}

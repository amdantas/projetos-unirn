package amdantas.aula08.exercicios;

import amdantas.estruturas.ArvoreAVL;

public class Main {

	public static void main(String[] args) {
		
		ArvoreAVL a = new ArvoreAVL();
		a.inserirBalanceado(50);
		a.exibirEmOrdem();
		a.inserirBalanceado(40);
		a.exibirEmOrdem();
		a.inserirBalanceado(30);
		a.exibirEmOrdem();
		a.inserirBalanceado(45);
		a.exibirEmOrdem();
		a.inserirBalanceado(47);
		a.exibirEmOrdem();
		a.inserirBalanceado(55);
		a.exibirEmOrdem();
		a.inserirBalanceado(56);
		a.exibirEmOrdem();
		a.inserirBalanceado(1);
		a.exibirEmOrdem();
		a.inserirBalanceado(2);
		a.exibirEmOrdem();
		a.inserirBalanceado(3);
		a.exibirEmOrdem();
	}
	
}

package amdantas.aula04.exercicios01;
import amdantas.estruturas.ElementoDuplo;
import amdantas.estruturas.ListaDupla;

public class Main {

	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();

		lista.adicionar(new ElementoDuplo("André"));
		lista.adicionar(new ElementoDuplo("João"));
		lista.adicionar(new ElementoDuplo("Marco"));
		lista.adicionar(new ElementoDuplo("Maria"));

		lista.exibir();
		
		System.out.println(lista.getTamanho());

		lista.adicionar(1, new ElementoDuplo("Paulo"));
		lista.exibir();
		lista.adicionar(4, new ElementoDuplo("Rafael"));
		lista.exibir();
		lista.adicionar(lista.getTamanho(), new ElementoDuplo("ultimo"));
		lista.exibir();
		lista.removerUltimo();
		lista.exibir();
	}

}

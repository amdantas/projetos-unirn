package amdantas.prova01.exercicio02;

public class Main {

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.adicionarUltimo(new Elemento(33));
		lista.adicionarUltimo(new Elemento(2));
		Elemento ultimo = lista.getUltimo();
		System.out.println("Info do último elemento: " + ultimo.getInfo());
		boolean achou = lista.buscar(13) != null;
		System.out.println("Achado? " + achou);
		lista.exibir();
	}
}

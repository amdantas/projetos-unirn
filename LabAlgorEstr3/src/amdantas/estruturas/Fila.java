package amdantas.estruturas;

public class Fila {

	private String[] vetorInterno;
	
	public Fila(int tamanho) {
		vetorInterno = new String[tamanho];
	}
	
	public boolean inserir(String elemento) {
		if (cheia()) {
			System.err.println("\r\nFila cheia");
			return false;
		}
		int tamanho = vetorInterno.length;
		int ultimaPosicao = tamanho - 1;
		
		boolean sucesso = false;
		for (int i = ultimaPosicao; i > 0; i--) {
			if (vetorInterno[i] == null || vetorInterno[i].isEmpty()) {
				vetorInterno[i] = elemento;
				sucesso = true;
				break;
			}
		}
		if (!sucesso)
			vetorInterno[0] = elemento;
		
		return true;
	}
	
	public String remover() {
		if (vazia()) {
			System.err.println("\r\nFila vazia");
			return null;
		}
		int tamanho = vetorInterno.length;
		int ultimaPosicao = tamanho - 1;
		String e = vetorInterno[ultimaPosicao];
		
		for (int i = ultimaPosicao; i > 0; i--) {
			vetorInterno[i] = vetorInterno[i - 1];
		}
		vetorInterno[0] = null;
		
		return e;
	}
	
	public boolean vazia() {
		if ( vetorInterno == null || vetorInterno.length == 0) 
			return true;
		
		for (String e : vetorInterno) {
			if (e != null && !e.isEmpty())
				return false;
		}
		return true;
	}
	
	public boolean cheia() {
		if ( vetorInterno == null || vetorInterno.length == 0) 
			return false;
		for (String e : vetorInterno) {
			if (e == null || e.isEmpty())
				return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (String e : vetorInterno) {
			s.append("["+(e == null?" ":e)+"] ");
		}
		return s.toString();
	}
}

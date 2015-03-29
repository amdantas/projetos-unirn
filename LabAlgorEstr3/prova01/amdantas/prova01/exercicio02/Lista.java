package amdantas.prova01.exercicio02;

public class Lista {

	private Elemento primeiro;

	public void adicionarUltimo(Elemento novo) {
		novo.setProximo(null);
		if (primeiro == null) 
			this.primeiro = novo;
		else 
			getUltimo().setProximo(novo);
	}
	
	public Elemento getUltimo() {
		Elemento aux = primeiro;
		while (aux.getProximo() != null) {
			aux = aux.getProximo();
		}
		return aux;
	}
	
	public Elemento buscar(Integer info) {
		Elemento aux = primeiro;
		while (aux  != null) {
			if (aux.getInfo().equals(info))
				return aux;
			aux = aux.getProximo();
		}
		return null;
	}
	
	public void exibir() {
		Elemento aux = primeiro;
		while (aux  != null) {
			System.out.print("["+aux.getInfo() + "] ");
			aux = aux.getProximo();
		}
	}
	
}

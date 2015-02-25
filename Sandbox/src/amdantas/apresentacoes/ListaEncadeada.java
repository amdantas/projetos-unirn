package amdantas.apresentacoes;

public class ListaEncadeada {

	private Elemento primeiro;

	private Elemento ultimo;

	private int totalDeElementos;

	public Elemento getPrimeiro() {
		return primeiro;
	}

	public Elemento getUltimo() {
		return ultimo;
	}

	public void adiciona(Elemento e) {
		if (this.totalDeElementos == 0) {
			this.primeiro = e;
			this.ultimo = e;
		} else if (this.totalDeElementos == 1) {
			this.primeiro.setProximo(e);
			this.ultimo = e;
			e.setProximo(null);
		} else {
			this.ultimo.setProximo(e);
			e.setProximo(null);
			ultimo = e;
		}
		this.totalDeElementos++;
	}

	public void exibirLista() {
		String lista = "";
		Elemento elem = primeiro;
		do {
			lista += elem.getInfo() + " ";
			elem = elem.getProximo();
		} while (elem  != null);
		System.out.println(lista);
	}

}

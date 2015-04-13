package amdantas.estruturas;

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
		if (totalDeElementos == 0) {
			System.out.println("Lista vazia");
			return;
		}
		String lista = "";
		Elemento elem = primeiro;
		do {
			lista += "["+elem.getInfo() + "] ";
			elem = elem.getProximo();
		} while (elem  != null);
		System.out.println(lista);
	}
	
	public Elemento busca(int posicao) {
		Elemento e = null;
		if (totalDeElementos > 0 && posicao <= totalDeElementos) {
			int contador = 0;
			Elemento elem = primeiro;
			do {
				contador++;
				if (contador == posicao)
					return elem;
				elem = elem.getProximo();
			} while (elem  != null);
			
		}
		return e;
	}
	
	public Elemento busca(String s) {
		Elemento e = null;
		if (totalDeElementos > 0  && s != null) {
			Elemento elem = primeiro;
			do {
				if (s.equals(elem.getInfo()))
					return elem;
				elem = elem.getProximo();
			} while (elem  != null);
		}
		return e;
	}
	
	public boolean contem(Elemento e) {
		return busca(e.getInfo()) != null;
	}
	
	public boolean remover(Elemento e) {
		if (contem(e)) {
			Elemento elem = primeiro;
			Elemento anterior = primeiro;
			do {
				boolean achado = false;
				if (elem.getInfo().equals(e.getInfo())) {
					if (elem == primeiro) {
						primeiro = elem.getProximo();
					} else if (elem == ultimo) {
						ultimo = anterior;
						ultimo.setProximo(null);
						anterior.setProximo(null);
					} else {
						anterior.setProximo(elem.getProximo());
					}
					achado = true;
				}
				if (!achado)
					anterior = elem;
				elem = elem.getProximo();
			} while (elem  != null);
		} 
		return false;
	}

	public Elemento quemAponta(Elemento e) {
		Elemento elem = primeiro;
		do {
			if (elem.getProximo() == e)
				return elem;
			elem = elem.getProximo();
		} while (elem  != null);
		return null;
	}

	public void exibirListaComRecursividade() {
		if (totalDeElementos > 0)
			exibirElemento(primeiro);
		else
			System.out.println("Lista vazia");
	}

	private void exibirElemento(Elemento e) {
		if (e == null)
			return;
		System.out.print("["+ e.getInfo() + "] " );
		Elemento prox = e.getProximo();
		exibirElemento(prox );
	}
	
	

}

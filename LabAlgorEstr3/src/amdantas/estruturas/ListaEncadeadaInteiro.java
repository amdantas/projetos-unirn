package amdantas.estruturas;

public class ListaEncadeadaInteiro {

	private ElementoInteiro primeiro;

	private ElementoInteiro ultimo;

	private int totalDeElementos;

	public ElementoInteiro getPrimeiro() {
		return primeiro;
	}

	public ElementoInteiro getUltimo() {
		return ultimo;
	}

	public void adiciona(ElementoInteiro e) {
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
		ElementoInteiro elem = primeiro;
		do {
			lista += "["+elem.getInfo() + "] ";
			elem = elem.getProximo();
		} while (elem  != null);
		System.out.println(lista);
	}
	
	public ElementoInteiro busca(int posicao) {
		ElementoInteiro e = null;
		if (totalDeElementos > 0 && posicao <= totalDeElementos) {
			int contador = 0;
			ElementoInteiro elem = primeiro;
			do {
				contador++;
				if (contador == posicao)
					return elem;
				elem = elem.getProximo();
			} while (elem  != null);
			
		}
		return e;
	}
	
	public ElementoInteiro busca(Integer s) {
		ElementoInteiro e = null;
		if (totalDeElementos > 0  && s != null) {
			ElementoInteiro elem = primeiro;
			do {
				if (s.equals(elem.getInfo()))
					return elem;
				elem = elem.getProximo();
			} while (elem  != null);
		}
		return e;
	}
	
	public boolean contem(ElementoInteiro e) {
		return busca(e.getInfo()) != null;
	}
	
	public boolean remover(ElementoInteiro e) {
		if (contem(e)) {
			ElementoInteiro elem = primeiro;
			ElementoInteiro anterior = primeiro;
			do {
				if (elem.getInfo().equals(e.getInfo())) {
					if (elem == primeiro) {
						primeiro = elem.getProximo().getProximo();
					} else if (elem == ultimo) {
						ultimo = anterior;
						ultimo.setProximo(null);
					} else {
						anterior.setProximo(elem.getProximo());
					}
					return true;
				}
				anterior = elem;
				elem = elem.getProximo();
			} while (elem  != null);
		} 
		return false;
	}
	
	

}

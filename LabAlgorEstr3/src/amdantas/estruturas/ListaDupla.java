package amdantas.estruturas;

public class ListaDupla {

	private ElementoDuplo elementoPrincipal;
	
	
	public void adicionar (ElementoDuplo e) {
		if (isVazia()) {
			e.setProximo(null);
			e.setAnterior(null);
			elementoPrincipal = e;
		} else {
			ElementoDuplo ultimo = getUltimo();
			ultimo.setProximo(e);
			e.setProximo(null);
			e.setAnterior(ultimo);
		}
	}

	public int getTamanho() {
		int tamanho = 0;
		ElementoDuplo elem = elementoPrincipal;
		while (elem  != null) {
			tamanho++;
			elem = elem.getProximo();
		} 
		return tamanho;
	}
	
	public void adicionar(int posicao, ElementoDuplo e) {
		int tamanho = getTamanho();
		if (posicao <= 0 || posicao > tamanho + 1) {
			System.out.println("Posição inválida");
			return;
		}
		if (isVazia()) {
			e.setProximo(null);
			e.setAnterior(null);
			elementoPrincipal = e;
		} else if (posicao == tamanho + 1) {
			ElementoDuplo ultimo = getUltimo();
			ultimo.setProximo(e);
			e.setAnterior(ultimo);
			e.setProximo(null);
		} else {
			ElementoDuplo elementoDaPosicao = buscar(posicao);
			ElementoDuplo anteriorDaLista = elementoDaPosicao.getAnterior();
			elementoDaPosicao.setAnterior(e);
			e.setProximo(elementoDaPosicao);
			e.setAnterior(anteriorDaLista);
			if (anteriorDaLista != null) {
				anteriorDaLista.setProximo(e);
			}
			if (posicao == 1)
				elementoPrincipal = e;
		}
	}
	
	
	
	public boolean removerUltimo () {
		return remover(getUltimo());
	}
	
	
	
	public boolean remover (ElementoDuplo e) {
		if (isVazia())
			return false;
		
		
		ElementoDuplo elem = buscar(e.getInfo()+"");
		if (elem != null) {
			if (elementoPrincipal == elem ) {
				// está removendo o primeiro
				ElementoDuplo proximo = elem.getProximo();
				elementoPrincipal = proximo;
				elementoPrincipal.setAnterior(null);
			} else if (elem == getUltimo()) {
				// removendo o último
				ElementoDuplo anterior = elem.getAnterior();
				anterior.setProximo(null);
			} else {
				ElementoDuplo anterior = elem.getAnterior();
				ElementoDuplo proximo = elem.getProximo();
				anterior.setProximo(proximo);
				proximo.setAnterior(anterior);
			}
		}
		return false;
	}
	
	public ElementoDuplo buscar (String info) {
		
		ElementoDuplo elem = elementoPrincipal;
		do {
			if (elem.getInfo().equals(info))
				return elem;
			elem = elem.getProximo();
		} while (elem  != null);
		return null;
	}
	
	public ElementoDuplo buscar (int posicao) {
		int cont = 0;
		ElementoDuplo elem = elementoPrincipal;
		while (elem  != null) {
			cont ++;
			if (posicao == cont)
				return elem;
			elem = elem.getProximo();
		} 
		return null;
	}
	
	private ElementoDuplo getUltimo() {
		ElementoDuplo elem = elementoPrincipal;
		do {
			if (elem.getProximo() == null )
				return elem;
			elem = elem.getProximo();
		} while (elem  != null);
		return null;
	}

	public boolean isVazia() {
		return elementoPrincipal == null;
	}
	
	public void exibir() {
		if (isVazia()) {
			System.out.println("Lista vazia");
			return;
		}
		String lista = "";
		
		ElementoDuplo elem = elementoPrincipal;
		do {
			lista += "["+elem.getInfo() + "] ";
			elem = elem.getProximo();
		} while (elem  != null);
		
		System.out.println(lista);
	}

	public void adicionaOrdenado(ElementoDuplo e) {
		ElementoDuplo elem = elementoPrincipal;
		int posicao = 1;
		while (elem != null) {
			Comparable o = (Comparable) elem.getInfo();
			if (o.compareTo(e.getInfo()) >= 0 ) {
				break;
			}
			elem = elem.getProximo();
			posicao++;
		}
		adicionar(posicao, e);
		
	}

	public ElementoDuplo getElementoPrincipal() {
		return elementoPrincipal;
	}
}

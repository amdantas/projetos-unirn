package amdantas.estruturas;

public class ListaDupla implements EstruturaDeDados {

	private ElementoDuplo primeiro;
	
	
	public void adicionar(ElementoDuplo e) {
		if (isVazia()) {
			e.setProximo(null);
			e.setAnterior(null);
			primeiro = e;
		} else {
			ElementoDuplo ultimo = getUltimo();
			ultimo.setProximo(e);
			e.setProximo(null);
			e.setAnterior(ultimo);
		}
	}

	public int getTamanho() {
		int tamanho = 0;
		ElementoDuplo elem = primeiro;
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
			primeiro = e;
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
				primeiro = e;
		}
	}
	
	
	
	public boolean removerUltimo () {
		return remover(getUltimo());
	}
	
	
	
	public boolean remover (ElementoDuplo e) {
		if (isVazia())
			return false;
		
		ElementoDuplo elem = buscar(e.getInfo() );
		ElementoDuplo ultimoElemento = getUltimo();
		if (elem != null) {
			if (primeiro == elem ) {
				// está removendo o primeiro
				primeiro = elem.getProximo();
				primeiro.setAnterior(null);
			} else if (elem == ultimoElemento) {
				// removendo o último
				ElementoDuplo anterior = elem.getAnterior();
				anterior.setProximo(null);
			} else {
				ElementoDuplo anterior = elem.getAnterior();
				ElementoDuplo proximo = elem.getProximo();
				anterior.setProximo(proximo);
				proximo.setAnterior(anterior);
			}
			return true;
		}
		return false;
	}
	
	public ElementoDuplo buscar (int info) {
		ElementoDuplo elem = primeiro;
		do {
			if (elem.getInfo().equals(info))
				return elem;
			elem = elem.getProximo();
		} while (elem  != null);
		return null;
	}
	
	private ElementoDuplo getUltimo() {
		ElementoDuplo elem = primeiro;
		while (elem  != null) {
			if (elem.getProximo() == null )
				return elem;
			elem = elem.getProximo();
		} ;
		return null;
	}

	public boolean isVazia() {
		return primeiro == null;
	}
	
	public void exibir() {
		if (isVazia()) {
			System.out.println("Lista vazia");
			return;
		}
		String lista = "";
		
		ElementoDuplo elem = primeiro;
		do {
			lista += "["+elem.getInfo() + "] ";
			elem = elem.getProximo();
		} while (elem  != null);
		
		System.out.println(lista);
	}

	public void adicionaOrdenado(ElementoDuplo e) {
		ElementoDuplo elem = primeiro;
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

	public void adicionaOrdenadoSimples(ElementoDuplo novo) {
		ElementoDuplo aux = primeiro;
		while (aux != null) {
			Comparable o = (Comparable) aux.getInfo();
			if (o.compareTo(novo.getInfo()) >= 0 ) {
				novo.setProximo(aux);
				novo.setAnterior(aux.getAnterior());
				if (aux.getAnterior() != null)
					aux.getAnterior().setProximo(novo);
				aux.setAnterior(novo);
				if (aux == primeiro)
					primeiro = novo;
				return;
			}
			aux = aux.getProximo();
		}
		if (aux == null) {
			ElementoDuplo ultimo = getUltimo();
			novo.setProximo(null);
			novo.setAnterior(ultimo);
			if (ultimo != null)
				ultimo.setProximo(novo);
			else
				this.primeiro = novo;
		}
	}
	
	public ElementoDuplo getElementoPrincipal() {
		return primeiro;
	}

	@Override
	public void adicionar(int i) {
		adicionaOrdenado(new ElementoDuplo(i));
	}

	@Override
	public void remover(int i) {
		remover(new ElementoDuplo(i));
	}

	@Override
	public String getConteudo() {
		String lista = "";
		
		ElementoDuplo elem = primeiro;
		while (elem  != null) {
			lista += "["+elem.getInfo() + "] ";
			elem = elem.getProximo();
		}  
		
		return lista;
	}
}

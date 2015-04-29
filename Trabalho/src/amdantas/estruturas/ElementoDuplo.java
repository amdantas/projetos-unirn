package amdantas.estruturas;

public class ElementoDuplo extends NoGenerico  {

	private ElementoDuplo proximo;

	private ElementoDuplo anterior;

	public ElementoDuplo () {
	}
	public ElementoDuplo (int i) {
		super(i);
	}

	public ElementoDuplo getProximo() {
		return proximo;
	}

	public void setProximo(ElementoDuplo proximo) {
		this.proximo = proximo;
	}

	public ElementoDuplo getAnterior() {
		return anterior;
	}

	public void setAnterior(ElementoDuplo anterior) {
		this.anterior = anterior;
	}
}

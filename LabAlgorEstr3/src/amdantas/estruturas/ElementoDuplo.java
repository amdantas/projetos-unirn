package amdantas.estruturas;

public class ElementoDuplo   {

	private Object info;
	
	private ElementoDuplo proximo;

	private ElementoDuplo anterior;

	public ElementoDuplo () {
	}
	
	public ElementoDuplo (String s) {
		info = s;
	}
	
	public ElementoDuplo(int i) {
		info = new Integer(i);
	}

	public ElementoDuplo(Object o) {
		info = o;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
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

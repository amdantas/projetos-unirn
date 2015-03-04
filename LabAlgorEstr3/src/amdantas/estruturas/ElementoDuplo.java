package amdantas.estruturas;

public class ElementoDuplo   {

	private String info;
	
	private ElementoDuplo proximo;

	private ElementoDuplo anterior;

	public ElementoDuplo () {
	}
	
	public ElementoDuplo (String s) {
		info = s;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
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

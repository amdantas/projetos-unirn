package amdantas.estruturas;

public class ElementoInteiro {

	private Integer info;
	
	private ElementoInteiro proximo;

	public ElementoInteiro (Integer s) {
		info = s;
	}
	
	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	public ElementoInteiro getProximo() {
		return proximo;
	}

	public void setProximo(ElementoInteiro proximo) {
		this.proximo = proximo;
	}
}

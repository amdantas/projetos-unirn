package amdantas.estruturas;

public class Elemento {

	private String info;
	
	private Elemento proximo;

	public Elemento () {
	}
	
	public Elemento (String s) {
		info = s;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Elemento getProximo() {
		return proximo;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return "["+info+"]";
	}
}

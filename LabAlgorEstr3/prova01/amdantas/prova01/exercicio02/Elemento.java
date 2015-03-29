package amdantas.prova01.exercicio02;

public class Elemento {

	private Integer info;
	
	private Elemento proximo;

	public Elemento(Integer i) {
		info = i;
	}
	
	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

	public Elemento getProximo() {
		return proximo;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}
	
}

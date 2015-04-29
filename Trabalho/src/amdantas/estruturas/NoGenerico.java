package amdantas.estruturas;

public abstract class NoGenerico {

	private Integer info;

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
	
	public NoGenerico(int i) {
		setInfo(i);
	}
	
	public NoGenerico() {
	}
	
	
}

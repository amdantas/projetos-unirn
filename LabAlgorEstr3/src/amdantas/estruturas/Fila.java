package amdantas.estruturas;

public class Fila {

	private Elemento ini;
	
	private Elemento fim;
	
	public void enfileirar(Elemento e) {
		if (ini == null) {
			ini = e;
			fim = e;
		} else if (ini == fim) {
			ini.setProximo(e);
		} else {
			fim.setProximo(e);
		}

		fim = e;
		fim.setProximo(null);
	}
	
	public Elemento desenfileirar() {
		Elemento e = ini;
		ini = ini.getProximo();
		return e;
	}
	
	@Override
	public String toString() {
		String s = "";
		Elemento e = ini;
		while (e != null) {
			s += "["+e.getInfo()+"]";
			e = e.getProximo();
		}
		return s;
	}
	
}

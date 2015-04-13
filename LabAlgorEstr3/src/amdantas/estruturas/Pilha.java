package amdantas.estruturas;

public class Pilha {

	private Elemento prim;
	
	public void push(Elemento e) {
		e.setProximo(prim);
		prim = e;
		
	}
	public Elemento pop() {
		Elemento e = prim;
		if (e != null)
			prim = e.getProximo();
		return e;
	}
	
	public int soma(int i1, int i3) {
		int s  = i1 + i3;
		return s;
	}
	
	@Override
	public String toString() {
		String s = "";
		Elemento e = prim;
		while (e != null) {
			s += "[" + e.getInfo() + "] ";
			e = e.getProximo();
		}
		return s;
	}
	
}

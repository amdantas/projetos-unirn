package amdantas.estruturas;

public class NoArvore extends NoGenerico {
	
	private NoArvore direita;

	private NoArvore esquerda;
	
	private NoArvore noPai;
	
	public NoArvore(int info, NoArvore direita, NoArvore esquerda) {
		super(info);
		this.direita = direita;
		this.esquerda = esquerda;
	}
	
	public NoArvore() {
		super();
	}
	
	public NoArvore(int i) {
		super(i);
	}

	public NoArvore getDireita() {
		return direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}
	
	public void setDireita(NoArvore direita) {
		this.direita = direita;
		if (direita != null)
			direita.setNoPai(this);
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
		if (esquerda != null)
			esquerda.setNoPai(this);
	}

	public NoArvore getNoPai() {
		return noPai;
	}

	public void setNoPai(NoArvore noPai) {
		this.noPai = noPai;
	}

	public int getAltura() {
		if (esquerda == null && direita == null) {
			return 0;
		} else if (esquerda == null) {
			return 1 + direita.getAltura();
		} else if (direita == null) {
			return 1 + esquerda.getAltura();
		} else {
			return 1 + Math.max(esquerda.getAltura(), direita.getAltura());
		}
	}
 
	public boolean isSemFilho() {
		return esquerda == null && direita == null;
	}

	public NoArvore getSucessor() {
		if (direita != null) {
			return direita.getMaisProfundoEsquerdo();
		}
		return null;
	}
	
	public NoArvore getMaisProfundoEsquerdo() {
		NoArvore aux = esquerda;
		if (aux == null) {
			return this;
		} else {
			while (aux.getEsquerda() != null) {
				aux = aux.getEsquerda();
			}
			return aux;
		}
	}
	
	@Override
	public String toString() {
		String d = direita != null ? direita.getInfo()+"" :"-"; 
		String e = esquerda != null ? esquerda.getInfo()+"" :"-"; 
		return "["+getInfo()+"] ("+e+","+d+")";
	}
}

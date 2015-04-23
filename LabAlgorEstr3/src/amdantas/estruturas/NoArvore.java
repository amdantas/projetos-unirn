package amdantas.estruturas;

public class NoArvore {
	
	private int info;
	
	private NoArvore direita;

	private NoArvore esquerda;
	
	private NoArvore noPai;
	
	private int balanceamento;
	
	public NoArvore(int info, NoArvore direita, NoArvore esquerda) {
		super();
		this.info = info;
		this.direita = direita;
		this.esquerda = esquerda;
	}
	
	public NoArvore(int info ) {
		super();
		this.info = info;
	}
	
	public NoArvore() {
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}

	public NoArvore getNoPai() {
		return noPai;
	}

	public void setNoPai(NoArvore noPai) {
		this.noPai = noPai;
	}
	
	public void calcularBalanceamento() {
		int hDireita = 0;
		if (direita != null)
			hDireita = direita.getAltura();
		
		int hEsquerda = 0;
		if (esquerda != null)
			hEsquerda = esquerda.getAltura();
		
		this.balanceamento = hDireita - hEsquerda;
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

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int i) {
		balanceamento = i;
	}
	
}

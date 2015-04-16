package amdantas.estruturas;

public class NoArvore {
	
	private int info;
	
	private NoArvore direita;

	private NoArvore esquerda;
	
	private NoArvore noPai;

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
	
	
}

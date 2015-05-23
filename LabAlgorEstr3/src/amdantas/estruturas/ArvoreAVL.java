package amdantas.estruturas;

public class ArvoreAVL extends ArvoreBinaria  {

	public void inserirBalanceado(int novoInfo) {
		if (raiz == null) {
			raiz = new NoArvore(novoInfo);
		} else {
			inserirBalanceado(raiz, novoInfo);
		}
	}
	 
	
	private void inserirBalanceado(NoArvore no, int novoInfo) {
		if (novoInfo < no.getInfo()) {
			if (no.getEsquerda() == null) {
				NoArvore novo = new NoArvore(novoInfo);
				novo.setNoPai(no);
				no.setEsquerda(novo);
				balancearArvore(no);
			} else {
				inserirBalanceado(no.getEsquerda(), novoInfo);
			}
		} else if (novoInfo > no.getInfo()) {
			if (no.getDireita() == null) {
				NoArvore novo = new NoArvore(novoInfo);
				novo.setNoPai(no);
				no.setDireita(novo);
				balancearArvore(no);
			} else {
				inserirBalanceado(no.getDireita(), novoInfo);
			}
		}
	}
	
	private void balancearArvore(NoArvore no) {
		no.calcularBalanceamento();
		
		if (no.getBalanceamento() == -2) {
			
			if (no.getDireita() != null && no.getDireita().getBalanceamento() < 0) {
				no = rotacaoEsquerda(no);
 
			} else  if (no.getDireita() != null && no.getDireita().getBalanceamento() > 0) {
				no = rotacaoEsquerdaDupla(no);
			}
 
		} else if (no.getBalanceamento() == 2) {
			if (no.getEsquerda() != null && no.getEsquerda().getBalanceamento() < 0) {
				no = rotacaoDireitaDupla(no);
 
			} else  if (no.getEsquerda() != null && no.getEsquerda().getBalanceamento() > 0) {
				no = rotacaoDireita(no);
			}
		}
 
		if (no.getNoPai() != null) 
			balancearArvore(no.getNoPai());
	}
	
	private NoArvore rotacaoDireita(NoArvore no) {
		NoArvore noEsq = no.getEsquerda();
		no.setEsquerda(noEsq.getDireita());
		substituiFilhoNoPai(no, noEsq);
		noEsq.setDireita(no);

		no.setBalanceamento(0);
		return no;
	}

	private NoArvore rotacaoEsquerda(NoArvore no) {
		NoArvore noDir = no.getDireita();
		no.setDireita(noDir.getEsquerda());
		substituiFilhoNoPai(no, noDir);
		noDir.setEsquerda(no);
		
		no.setBalanceamento(0);
		return no;
	}
	
	
	private NoArvore rotacaoDireitaDupla(NoArvore no) {
		NoArvore saE = no.getEsquerda();
		NoArvore saD = saE.getDireita();
		
		saE.setDireita(saD.getEsquerda());
		saD.setEsquerda(saE);
		no.setEsquerda(saD.getDireita());
		substituiFilhoNoPai(no, saD);
		saD.setDireita(no);
		
		return no;
	}
	
	private NoArvore rotacaoEsquerdaDupla(NoArvore no) {
		NoArvore saD = no.getDireita();
		NoArvore saE = saD.getEsquerda();
		saD.setEsquerda(saE.getDireita());
		saE.setDireita(saD);
		no.setDireita(saE.getEsquerda());
		substituiFilhoNoPai(no, saE);
		saE.setEsquerda(no);
		
		return no;
	}

	private void substituiFilhoNoPai(NoArvore no, NoArvore outroNo) {
		NoArvore pai = no.getNoPai();
		if (pai != null) {
			if (pai.getEsquerda() == no) 
				pai.setEsquerda(outroNo);
			else 
				pai.setDireita(outroNo);
		} else {
			// o nó é a raiz
			raiz = outroNo;
			raiz.setNoPai(null);
		}
	}
	public void remover(int info) {
		NoArvore no = buscar(info);
		NoArvore pai = no.getNoPai();
		super.remover(info);
		balancearArvore(pai);
	}
	
}

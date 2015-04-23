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
			int hEsquerdaEsquerda = 0;
			if (no.getEsquerda() != null && no.getEsquerda().getEsquerda() != null)
				hEsquerdaEsquerda = no.getEsquerda().getEsquerda().getAltura();
			int hEsquerdaDireita = 0;
			if (no.getEsquerda() != null && no.getEsquerda().getDireita() != null)
				hEsquerdaDireita = no.getEsquerda().getDireita().getAltura();
			
			if (hEsquerdaEsquerda >= hEsquerdaDireita) {
				no = rotacaoDireita(no);
 
			} else {
				no = rotacaoEsquerdaDupla(no);
			}
 
		} else if (no.getBalanceamento() == 2) {
			int hDireitaDireita= 0;
			if (no.getDireita() != null && no.getDireita().getDireita() != null)
				hDireitaDireita = no.getDireita().getDireita().getAltura();
			int hDireitaEsquerda = 0;
			if (no.getDireita() != null && no.getDireita().getEsquerda() != null)
				hDireitaEsquerda = no.getDireita().getEsquerda().getAltura();
 
			if (hDireitaDireita >= hDireitaEsquerda) {
				no = rotacaoEsquerda(no);
			} else {
				no = rotacaoDireitaDupla(no);
			}
		}
 
		if (no.getNoPai() != null) 
			balancearArvore(no.getNoPai());
	}
	
	private NoArvore rotacaoDireita(NoArvore no) {
		NoArvore aux = no.getEsquerda();
		no.setEsquerda(aux.getDireita());
		aux.setDireita(no);
		no.setBalanceamento(0);
		no = aux;
		return no;
	}
	
	private NoArvore rotacaoEsquerda(NoArvore no) {
		NoArvore aux = no.getDireita();
		no.setDireita(aux.getEsquerda());
		aux.setEsquerda(no);
		no.setBalanceamento(0);
		no = aux;
		return no;
	}
	
	
	private NoArvore rotacaoDireitaDupla(NoArvore no) {
		NoArvore auxU = no.getEsquerda();
		NoArvore auxV = auxU.getDireita();
		auxU.setDireita(auxV.getEsquerda());
		auxV.setEsquerda(auxU);
		no.setEsquerda(auxV.getDireita());
		auxV.setDireita(no);
		if (auxV.getBalanceamento() == 1)
			no.setBalanceamento(-1);
		else
			no.setBalanceamento(0);
		if (auxV.getBalanceamento() == -1)
			auxU.setBalanceamento(1);
		else
			auxU.setBalanceamento(0);
		no = auxV;
		return no;
	}
	
	private NoArvore rotacaoEsquerdaDupla(NoArvore no) {
		NoArvore auxU = no.getDireita();
		NoArvore auxV = auxU.getEsquerda();
		auxU.setEsquerda(auxV.getDireita());
		auxV.setDireita(auxU);
		no.setDireita(auxV.getEsquerda());
		auxV.setEsquerda(no);
		if (auxV.getBalanceamento() == -1)
			no.setBalanceamento(1);
		else
			no.setBalanceamento(0);
		if (auxV.getBalanceamento() == 1)
			auxU.setBalanceamento(-1);
		else
			auxU.setBalanceamento(0);
		no = auxV;
		return no;
	}
	
	public void remover(int info) {
		NoArvore achado = buscar(info);
		if (achado != null)
			removerAVL(achado);
	}
 
	private void removerAVL(NoArvore no) {
		NoArvore aux;
 
		if (no.getEsquerda() == null || no.getDireita() == null) {
 
			if (no.getNoPai() == null) {
				this.raiz = null;
				no = null;
				return;
			}
			aux = no;
 
		} else {
			aux = getMaisProfundoEsquerdo(no);
			no.setInfo(aux.getInfo());
		}
 
		NoArvore p;
		if (aux.getEsquerda() != null) {
			p = aux.getEsquerda();
		} else {
			p = aux.getDireita();
		}
 
		if (p != null) {
			p.setNoPai(aux.getNoPai());
		}
 
		if (aux.getNoPai() == null) {
			this.raiz = p;
		} else {
			if (aux == aux.getNoPai().getEsquerda()) {
				aux.getNoPai().setEsquerda(p);
			} else {
				aux.getNoPai().setDireita(p);
			}
			balancearArvore(aux.getNoPai());
		}
		aux = null;
	}
	
	
}

package amdantas.estruturas;

public class ArvoreBinaria {

	protected NoArvore raiz;
	
	private int soma;
	
	public void exibirPreOrdem() {
		exibirPreOrdem(raiz);
	}
	
	public void exibirPosOrdem() {
		exibirPosOrdem(raiz);
	}
	
	private void exibirPreOrdem(NoArvore no) {
		if (no != null) {
			System.out.print("["+no.getInfo()+"]");
			exibirPreOrdem(no.getEsquerda());
			exibirPreOrdem(no.getDireita());
		}
	}
	
	private void exibirPosOrdem(NoArvore no) {
		if (no != null) {
			exibirPosOrdem(no.getEsquerda());
			exibirPosOrdem(no.getDireita());
			System.out.print("["+no.getInfo()+"]");
		}
	}
	
	private void exibirEmOrdem(NoArvore no) {
		if (no != null) {
			exibirEmOrdem(no.getEsquerda());
			System.out.print("["+no.getInfo()+"]");
			exibirEmOrdem(no.getDireita());
		}
	}
	
	public void exibirEmOrdem() {
		exibirEmOrdem(raiz);
		System.out.println();
	}
	
	public void inserirNo(int novoInfo) {
		if (raiz == null) {
			raiz = new NoArvore(novoInfo);
		} else {
			inserirNo(raiz, novoInfo);
		}
	}
	
	private void inserirNo(NoArvore no, int novoInfo) {
		if (novoInfo < no.getInfo()) {
			if (no.getEsquerda() == null) {
				NoArvore novo = new NoArvore(novoInfo);
				novo.setNoPai(no);
				no.setEsquerda(novo);
			} else {
				inserirNo(no.getEsquerda(), novoInfo);
			}
		} else if (novoInfo > no.getInfo()) {
			if (no.getDireita() == null) {
				NoArvore novo = new NoArvore(novoInfo);
				novo.setNoPai(no);
				no.setDireita(novo);
			} else {
				inserirNo(no.getDireita(), novoInfo);
			}
		}
	}
	
	public void remover(int info) {
		NoArvore no = buscar(info);
		if (no.getEsquerda() == null && no.getDireita() == null) {
			//Nó possui duas sub-árvores vazias
			NoArvore noPai = no.getNoPai();
			if (noPai.getEsquerda() == no)
				noPai.setEsquerda(null);
			else
				noPai.setDireita(null);
		} else if (no.getEsquerda() != null && no.getDireita() != null) {
			//Nó possui duas sub-árvores cheias
			NoArvore sucessor = getMaisProfundoEsquerdo(no.getDireita());
			no.setInfo(sucessor.getInfo());
			NoArvore paiSucessor = sucessor.getNoPai();
			if (paiSucessor.getEsquerda() == sucessor)
				paiSucessor.setEsquerda(null);
			else
				paiSucessor.setDireita(null);
		} else {
			//Nó possui UMA das sub-árvores vazias
			NoArvore noFilho = no.getEsquerda() != null ? no.getEsquerda() : no.getDireita(); 
			NoArvore noPai = no.getNoPai();
			if (noPai.getEsquerda() == no)
				noPai.setEsquerda(noFilho);
			else
				noPai.setDireita(noFilho);
		}
	}
	
	protected NoArvore getMaisProfundoEsquerdo(NoArvore no) {
		if (no.getEsquerda() == null)
			return no;
		return getMaisProfundoEsquerdo(no.getEsquerda());
	}

	public int somaTodos() {
		soma = 0;
		somaTodos(raiz);
		return soma;
	}
	
	private void somaTodos(NoArvore no) {
		if (no != null) {
			soma += no.getInfo();
			somaTodos(no.getEsquerda());
			somaTodos(no.getDireita());
		}
			
	}

	public NoArvore buscar(int info) {
		return buscar(raiz, info);
	}
	
	private NoArvore buscar(NoArvore no, int info) {
		if (no != null) {
			if (info == no.getInfo()) {
				return no;
			} else if (info  > no.getInfo()) {
				return buscar(no.getDireita(), info);
			} else {
				return buscar(no.getEsquerda(), info);
			}
		}
		return null;
	}
	
}

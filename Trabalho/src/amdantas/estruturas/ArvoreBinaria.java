package amdantas.estruturas;

public class ArvoreBinaria implements EstruturaDeDados {

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
	
	private void exibirEmOrdem(NoArvore no, StringBuilder sb) {
		if (no != null) {
			exibirEmOrdem(no.getEsquerda(), sb);
			sb.append(no);
			exibirEmOrdem(no.getDireita(), sb);
		}
	}
	
	public void exibirEmOrdem() {
		StringBuilder sb = new StringBuilder( );
		exibirEmOrdem(raiz, sb);
		System.out.println();
		System.out.println(sb);
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
		if (no.isSemFilho()) {
			//N� possui duas sub-�rvores vazias
			removerNoSemFilho(no);
		} else if (no.getEsquerda() != null && no.getDireita() != null) {
			//N� possui duas sub-�rvores cheias
			NoArvore sucessor = no.getSucessor();
			no.setInfo(sucessor.getInfo());
			if (sucessor.isSemFilho()) {
				removerNoSemFilho(sucessor);
			} else {
				removerNoComUmFilho(sucessor);
			}
		} else {
			//N� possui UMA das sub-�rvores vazias
			removerNoComUmFilho(no);
		}
	}
	
	private void removerNoComUmFilho(NoArvore no) {
		NoArvore noFilho = no.getEsquerda() != null ? no.getEsquerda() : no.getDireita(); 
		NoArvore noPai = no.getNoPai();
		if (noPai.getEsquerda() == no)
			noPai.setEsquerda(noFilho);
		else
			noPai.setDireita(noFilho);		
	}

	private void removerNoSemFilho(NoArvore no) {
		NoArvore noPai = no.getNoPai();
		if (noPai.getEsquerda() == no)
			noPai.setEsquerda(null);
		else
			noPai.setDireita(null);		
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

	@Override
	public void adicionar(int i) {
		inserirNo(i);
	}

	@Override
	public void exibir() {
		exibirEmOrdem();
	}

	@Override
	public String getConteudo() {
		StringBuilder sb = new StringBuilder();
		exibirEmOrdem(raiz, sb);
		return sb.toString();
	}
	
}

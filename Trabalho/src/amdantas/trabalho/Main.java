package amdantas.trabalho;

import amdantas.estruturas.ArvoreBinaria;
import amdantas.estruturas.EstruturaDeDados;
import amdantas.estruturas.ListaDupla;

public class Main {

	public static void main(String[] args) {
		EstruturaDeDados eddArvore = new ArvoreBinaria();
		eddArvore.adicionar(3);
		eddArvore.adicionar(5);
		eddArvore.adicionar(6);
		eddArvore.exibir();
		
		EstruturaDeDados eddLista = new ListaDupla();
		eddLista.adicionar(3);
		eddLista.adicionar(5);
		eddLista.adicionar(6);
		eddLista.exibir();
		eddLista.remover(5);
		eddLista.exibir();
		
		gravarEstruturaEmArquivo(eddArvore, "arquivo_arvore.txt");
		gravarEstruturaEmArquivo(eddLista, "arquivo_lista.txt");
	}

	private static void gravarEstruturaEmArquivo(EstruturaDeDados estrutura, String nomeArquivo) {
		String conteudoTexto = estrutura.getConteudo();
		try {
			gravarArquivo(conteudoTexto, nomeArquivo);
		}catch (Exception e) {
			System.err.println("Ocorreu um erro na gravação de arquivo");
			e.printStackTrace();
		}
	}

	private static void gravarArquivo(String conteudoTexto, String nomeArquivo) throws Exception {
		// implementar
		
	}
	
}

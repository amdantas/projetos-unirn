package amdantas.aula09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class MainCidades {

	public static void main(String[] args) throws Exception {

		Cidade[] cidades = { new Cidade("natal", "rn"), new Cidade("recife", "pe"), new Cidade("poa", "rs"), new Cidade("rio", "rj"), new Cidade("fortaleza", "ce") };

		gravarEmArquivoBinario(cidades, "cidades.dat");
		gravarEmCsv(cidades, "cidades.csv");

		gravarEmCsvDoBinario("cidades.dat");
		
		int linha = buscarTexto("cidades.csv", "fortaleza2");
		if (linha > 0) {
			System.out.println("Achou na linha: " + linha);
		} else {
			System.out.println("Não achou");
		}

		int numCidades = getNumeroObjetos("cidades.dat");
		System.out.println("Numero de cidades: " + numCidades);
	}

	private static int getNumeroObjetos(String nomeArquivo) throws Exception {
		File diretorio = new File("C:\\AulaArquivos\\");
		File arq = new File(diretorio, nomeArquivo);
		FileInputStream fis = new FileInputStream(arq);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Cidade[] cidades = (Cidade[]) ois.readObject();
		ois.close();
		fis.close();
		return cidades.length;
	}

	private static int buscarTexto(String nomeArquivo, String texto) throws Exception {
		
		FileReader fr = new FileReader("C:\\AulaArquivos\\"  +nomeArquivo);
		BufferedReader br = new BufferedReader(fr);
		
		int numLinha = 1;
		
		try {
			
			while (br.ready()) {
				String linha = br.readLine();
				if (linha.contains(texto)) {
					return numLinha;
				}
				numLinha++;
			}
			
		} finally {
			br.close();
			fr.close();
		}
		return 0;
	}

	private static void gravarEmCsvDoBinario(String nomeArquivo) throws Exception {
		File diretorio = new File("C:\\AulaArquivos\\");
		File arq = new File(diretorio, nomeArquivo);
		FileInputStream fis = new FileInputStream(arq);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Cidade[] cidades = (Cidade[]) ois.readObject();
		ois.close();
		fis.close();
		gravarEmCsv(cidades, "cidades_do_bin.csv");
	}

	private static void gravarEmCsv(Cidade[] cidades, String nomeArquivo) throws Exception {
		File diretorio = new File("C:\\AulaArquivos\\");

		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		File arquivo = new File(diretorio, nomeArquivo);

		FileWriter fw = new FileWriter(arquivo);

		PrintWriter pw = new PrintWriter(fw);
		for (Cidade cidade : cidades) {
			String linha = cidade.getNome() + "," + cidade.getEstado();
			pw.println(linha);
		}
		pw.close();
		System.out.println("CSV criado com sucesso");
	}

	private static void gravarEmArquivoBinario(Object obj, String nomeArquivo) throws Exception {
		File diretorio = new File("C:\\AulaArquivos\\");

		if (!diretorio.exists()) {
			diretorio.mkdir();
		}

		File arq = new File(diretorio, nomeArquivo);
		FileOutputStream fout = new FileOutputStream(arq);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(obj);

		oos.close();
		fout.close();

		System.out.println("arquivo criado com sucesso");

	}

}

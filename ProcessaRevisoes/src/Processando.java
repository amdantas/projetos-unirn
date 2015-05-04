import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Processando {
	
	private static final String PREFIXO  = "C:\\Users\\Andre\\Desenvolvimento\\workspace\\ProcessaRevisoes\\src\\";
	private static final String ARQUIVO = "avulso";
	private static final String ARQUIVO__LEITURA = PREFIXO + ARQUIVO + ".txt";
	private static final String NOVO_ARQUIVO = PREFIXO + ARQUIVO + "-compiladas.txt";
	private static Map<String, ArrayList<String>> mapaRevisoes;
	
	public static void main(String[] args) {
		
		mapaRevisoes = new TreeMap<String, ArrayList<String>>();
		
		lerArquivo();
		
		gerarArquivo();
		
		
	}

	private static void gerarArquivo() {
		try {
			StringBuilder saida = new StringBuilder();
			ArrayList<String> caminhos = new ArrayList<String>();
			for (String a : mapaRevisoes.keySet()) {
				caminhos.add(a);
			}
			Collections.sort(caminhos);
			for (String a : caminhos) {
				ArrayList<String> revisoes = mapaRevisoes.get(a);
				Collections.sort(revisoes);
				saida.append(a + " - " + revisoes + "\r\n\r\n");
			}
			 
 
			File file = new File(NOVO_ARQUIVO);
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(saida.toString());
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	private static Map<String, ArrayList<String>> processarRevisoes(String arquivo) {
		
		return null;
	}

	private static StringBuilder lerArquivo() {
		BufferedReader br = null;
		StringBuilder arquivo = new StringBuilder();
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(ARQUIVO__LEITURA));
			String revisao = "";
			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("Revisão") && !sCurrentLine.equals(revisao)) {
					revisao = sCurrentLine;
				}
				if (sCurrentLine.contains("trunk/")) {
					String caminho = sCurrentLine.substring(sCurrentLine.indexOf("trunk/")).trim();
					if (mapaRevisoes.get(caminho) == null) {
						mapaRevisoes.put(caminho, new ArrayList<String>());
					}
					String numRevisao = "";
					if (revisao.contains("Revisão:"))
						numRevisao = revisao.substring(8).trim();
					else if (revisao.contains("Revisão "))
						numRevisao = revisao.substring(8, revisao.indexOf(" por ")).trim();
						
					mapaRevisoes.get(caminho).add(numRevisao);
				}
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arquivo;
	}
	
}

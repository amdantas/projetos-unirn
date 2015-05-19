import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Processando {

	private static final String PREFIXO = "C:\\Users\\Andre\\Desenvolvimento\\workspace\\ProcessaRevisoes\\src\\";
	private static final String BUILD = "16.0";
	private static final String ARQUIVO__LEITURA = PREFIXO + BUILD + ".txt";
	private static final String NOVO_ARQUIVO = PREFIXO + BUILD + "-compiladas.txt";
	private static Map<String, ArrayList<String>> mapaRevisoes;

	public static void main(String[] args) throws Exception {

		mapaRevisoes = new TreeMap<String, ArrayList<String>>();

		lerBancoGerarArquivo();

		lerArquivo();

		gerarArquivo();

	}

	private static void lerBancoGerarArquivo() throws SQLException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:postgresql://bdproducao2.info.ufrn.br/sistemas_comum", "desenvolvedor_andredantas", "1a9m8d2");
		Statement st = con.createStatement();
		String sql = "";
		sql += " select l.log, t.numtarefa, st.denominacao, l.data_realizacao ";
		sql += " from iproject.log_tarefa l ";
		sql += " join iproject.tarefa t on t.id_tarefa=l.id_tarefa ";
		sql += " join iproject.build b on b.id_build=t.id_build_associada ";
		sql += " join iproject.status_tarefa st on st.id=t.id_status ";
		sql += " where l.ativo and b.numero='"+BUILD+"' and l.id_tipo_log=13 and b.id_sistema=2 ";
		ResultSet rs = st.executeQuery(sql);
		StringBuilder sb = new StringBuilder();
		while (rs.next()) {
			sb.append(rs.getString("log") + "\r\n");
		}
		rs.close();
		con.close();

		File file = new File(ARQUIVO__LEITURA);

		// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(sb.toString());
		bw.close();
		
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
					else if (revisao.contains("Revisão ")) {
						if (revisao.indexOf(" por ") > 0)
							numRevisao = revisao.substring(8, revisao.indexOf(" por ")).trim();
						else
							numRevisao = revisao.substring(8, revisao.length()).trim();
					}

					mapaRevisoes.get(caminho).add(numRevisao);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arquivo;
	}

}

package amdantas.movies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class List {

	private static MovieEntry getIMDBEntry(String code) throws IOException {
		String urltext = "http://www.imdb.com/title/tt" + code + "/";
		URL url = new URL(urltext);
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
		BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
		String inputLine;

		MovieEntry entry = new MovieEntry();
		int valid = 2;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.trim().startsWith("<title>")) {
				String titleAndYear = URLDecoder.decode(StringUtils.substringBetween(inputLine, "<title>", "</title>"), "UTF-8");
				String title = (StringUtils.substringBefore(titleAndYear, "("));
				String temp = StringUtils.substringAfterLast(titleAndYear, "(");
				String year = (StringUtils.substringBefore(temp, ")"));
				entry.setTitle(title);
				entry.setYear(year);
				valid--;
			} else if (inputLine.trim().startsWith("<meta name=\"description\" content=\"")) {
				valid--;
				entry.setDescription(URLDecoder.decode(StringUtils.substringBetween(inputLine, 
						"<meta name=\"description\" content=\"", "\" />"), "UTF-8"));
			}
			if (valid == 0 || inputLine.contains("<body>")) {
				break;
			}
		}
		in.close();
		return entry;

	}

	public static void main(String[] args) {
		parseFile("C:\\Users\\andre_dantas\\Downloads\\listal\\movies.xml"
				, "C:\\Users\\andre_dantas\\Downloads\\listal\\movies.csv"
				, "C:\\Users\\andre_dantas\\Downloads\\listal\\movies.sql");
	}

	private static void parseFile(String path, String target, String inserts) {

		try {
			File file = new File(path);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("item");

			BufferedWriter w = new BufferedWriter(new FileWriter(target));
			BufferedWriter wSql = new BufferedWriter(new FileWriter(inserts));
			
			int i  = 0;
			for (int s = 0; s < nodeLst.getLength(); s++) {
				Node fstNode = nodeLst.item(s);

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					i++;
					boolean watched = getElement(fstNode, "listal:listtype").equals("owned"); 
					if (watched) {
						String imdb = getElement(fstNode, "listal:imdb");
						MovieEntry entry = getIMDBEntry(imdb);
						String title = getElement(fstNode, "title");
						String year = entry.getYear();
						String rating = getElement(fstNode, "listal:rating");
						String description = entry.getDescription();
						String output = title + "|" + year + "|"+ rating + "|" + description ;
						w.append(output );
						w.newLine();
						String insertSql = "INSERT INTO ENTRY (TITLE, YEAR, RATING, DESCRIPTION, ID) VALUES (" 
							+ "'"+title+"', "+ "'"+year+"', "+rating+", "+ "'"+description+"', SEQ.nextval);";
						wSql.append(insertSql);
						wSql.newLine();
						System.out.println(i);
//						if (i ==5) break;
						/**
						 * todo: escape
						 * 's / 't / O' / 've / 're /
						 * 's
't
O'
've
're
'Em
&#xE9;  / e
n' 
&#xE1; / a
n''
o' 

&#x27; / ''

						 */
					}
					
				}
			}
			wSql.append("commit;");
			w.close();
			wSql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getElement(Node fstNode, String tagName) {
		Element fstElmnt = (Element) fstNode;
		NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(tagName);
		Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		NodeList fstNm = fstNmElmnt.getChildNodes();
		return  ((Node) fstNm.item(0)).getNodeValue();
	}

}

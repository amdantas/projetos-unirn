package amdantas.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class GenActors {

	public static void main(String[] args) {
//		genPeople(args);
		genLink(args);
	}
	
	public static void genLink(String[] args) {
		Connection conn;
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:LOCALDB";
			conn = DriverManager.getConnection(url, "AMDANTAS", "amdantas");

			ResultSet rs = conn.createStatement().executeQuery("select * from entry");
			ArrayList<String> batchStatements = new ArrayList<String>();
			while (rs.next()) {
				String description = rs.getString("DESCRIPTION");
				String id = rs.getString("ID");
				String director = StringUtils.substringBetween(description, "Directed by ", ". With ");
				batchStatements.add("INSERT INTO PERSON_ENTRY (type, PERSON_ID, ENTRY_ID) VALUES ('DIRECTOR', (SELECT ID FROM PERSON WHERE NAME='"+director+"'), " + id + ")");
				String actors = description.substring(description.indexOf(". With ")+7, description.lastIndexOf('.')); 
				String[] actorsList = StringUtils.split(actors, ",");
				for (int i = 0; i < actorsList.length; i++) {
					batchStatements.add("INSERT INTO PERSON_ENTRY (type, PERSON_ID, ENTRY_ID) VALUES ('ACTOR', (SELECT ID FROM PERSON WHERE NAME='"+actorsList[i].trim()+"'), " + id + ")");
				}
			}
			rs.close();
			
			Statement stm = conn.createStatement();
			for (String s : batchStatements) {
				stm.addBatch(s);
			}
			stm.executeBatch();
			stm.close();
			conn.close();
		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}
	
	public static void genPeople(String[] args) {
		Connection conn;
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:LOCALDB";
			conn = DriverManager.getConnection(url, "AMDANTAS", "amdantas");

			ResultSet rs = conn.createStatement().executeQuery("select * from entry");
			Set<String> people = new HashSet<String>();
			
			while (rs.next()) {
				String description = rs.getString("DESCRIPTION");
				String director = StringUtils.substringBetween(description, "Directed by ", ". With ");
				people.add(director);
				String actors = description.substring(description.indexOf(". With ")+7, description.lastIndexOf('.')); 
				String[] actorsList = StringUtils.split(actors, ',');
				for (int i = 0; i < actorsList.length; i++) {
					people.add(actorsList[i].trim());
				}
			}
			rs.close();
			
			Statement stm = conn.createStatement();
			System.out.println(people.size()  + " people");
			for (String person : people) {
//				System.out.println("INSERT INTO PERSON (ID, NAME) VALUES (SEQ.nextval, '"+person+"')");
				stm.addBatch("INSERT INTO PERSON (ID, NAME) VALUES (amdantas.SEQ.nextval, '"+person+"')");
			}
			stm.executeBatch();
			stm.close();
			conn.close();
		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

}

package amdantas.testes;

public class Matematica {

	public static int soma(int p1, int p2) {
		return p1 + p2;
	}
	
	
	public static String soma(String s1, String s2) {
		return s1 + s2;
	}
	
	public static void main(String[] args) {
		
		int p1 = 2;
		int p2 = 10;
		
		int resInteiro = soma(p1, p2);
		
		String resString = soma("UNI", "RN");

//		resString = soma(p1, p2);

		
	}
	
	
}

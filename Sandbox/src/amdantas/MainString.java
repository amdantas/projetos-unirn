package amdantas;

public class MainString {

	public static void main(String[] args) {
		int i = 22 , j = 22;
		
		System.out.println(3 == 3);
		System.out.println(3 == 4);
		System.out.println(i == j);

		String s1 = new String("A");
		String s2 = new String("A");
		
		s2 = s1;
		
		System.out.println("A" == "A");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
	}
	
}

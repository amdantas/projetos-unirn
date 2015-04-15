package amdantas;

@SuppressWarnings("unused")

public class MainReferencias {

	public static void main(String[] args) {
		Aluno joao = new Aluno("João");
		Aluno maria = new Aluno("Maria");
		System.out.println(joao == maria);
		
		String s = "1";
		Integer i = 1;
		System.out.println( s.equals(i));
		
		Aluno mariaClara = new Aluno("Maria");
		System.out.println( mariaClara == maria);
	}
	
}

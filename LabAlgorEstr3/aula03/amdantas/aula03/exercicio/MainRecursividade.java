package amdantas.aula03.exercicio;

public class MainRecursividade {

	public static void main(String[] args) {
		System.out.println("Fatorial:");
		System.out.println("-----------");
		System.out.println(fatorial(4));
		System.out.println(fatorial(5));
		
		System.out.println("Somatório:");
		System.out.println("-----------");
		System.out.println(somatorio(4));
		System.out.println(somatorio(5));
		System.out.println(somatorio(15));
		
	}

	private static int somatorio(int n) {
		if (n == 0)
			return 0;
		return n + somatorio(n - 1);
	}

	private static int fatorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * (fatorial(n - 1));
	}
	
}

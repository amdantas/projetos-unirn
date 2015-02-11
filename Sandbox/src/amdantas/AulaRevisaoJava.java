package amdantas;


public class AulaRevisaoJava {

	public static void main(String[] args) {
		
		// todas são formas iguais de se criar um inteiro
		Integer inteiro = new Integer(10);
		Integer inteiroString = new Integer("10");
		int i = 10;

		
		// o tipo primitivo pode receber o tipo wrapper
		int a = inteiro;
		
		// usando o método xxxValue()
		int b = inteiro.intValue();
		
		// wrappers de outros tipos de xxxValue()		
		Double d = new Double(23.3);
		int c = d.intValue();
		short s = d.shortValue();
		Boolean flag = new Boolean(true);
		flag.booleanValue();
		
		// formas de usar parse a partir de uma String
		Double real = new Double("98.4");
		// ou usando o parseXXX()
		double r = Double.parseDouble("23.4");
		
		laco();
		
		
		String[] vetor = {"JAN", "FEV", "MAR", "ABR"};
		
		exibirVetor(vetor);
		
		for (int j = 0; j  < 4; j++) {
			vetor[j] += " - " + (j+1);
		}
		
		exibirVetor(vetor);
		
		
		for (String e : vetor) {
			System.out.println(e);
		}
		
		for (String e : vetor) {
			
		}
		

		boolean jogar = true;
		try {
			System.out.println("executando linha 1");
			System.out.println("executando linha 2");
			System.out.println("executando linha 3");
			System.out.println("executando linha 4");
			
			if (jogar)
				throw new NumberFormatException("exceção de número");
			
			System.out.println("executando linha 5");
			System.out.println("executando linha 6");
		} catch(NumberFormatException nfe) {
			System.out.println("executando dentro do catch do NumberFormatException ");
		} catch(Exception e) {
			System.out.println("executando dentro do catch do Exception ");
		} finally {
			System.out.println("executando dentro do finally");
		}
		System.out.println("executando fora do try");
		
		
	}
	
	
	
	private static void exibirVetor(String[] v) {
		for (int j = 0; j  < 4; j++) {
			System.out.println(v[j]);
		}
		
	}



	public static void laco() {
		
		for (int i = 0; i < 10; i++) {
			
			if ( i  == 8 )
				break;

			System.out.print(i + ", ");
			
		}
		
		
	}
	
}

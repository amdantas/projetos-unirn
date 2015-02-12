package amdantas.aula02.exercicio2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	private static int NUM_MAXIMO = 3;
	
	private static DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws ParseException {
		
		DadosPessoais[] pessoas = new DadosPessoais[NUM_MAXIMO];

		Municipio natal = new Municipio("Natal");
		Municipio recife = new Municipio("Recife");
		
		for (int i = 0; i < pessoas.length; i++) {
			DadosPessoais pessoa = new DadosPessoais();
			pessoa.setNome("NOME PESSOA " + i);
			pessoa.setDataNascimento(formatador.parse("01/04/199" + i));
			pessoa.setEmail("email@host.com."+i);
			pessoa.setCidadeNascimento(natal);
			
			Endereco endereco = new Endereco();
			endereco.setRua("RUA " + i);
			endereco.setNumero((i + 10) * 80);
			endereco.setCep("593434"+((i + 10) * 45));
			endereco.setMunicipio(recife);
			
			pessoa.setEnderecoContato(endereco);
			
			pessoas[i] = pessoa;
		}
		
		for (DadosPessoais p : pessoas) {
			System.out.println(p);
		}
		
		
		
	}
	
}

package amdantas.apresentacoes;

public class TestePessoa {
	
	public static void main(String[] args) {
		
		Pessoa marcos = new Pessoa();
		marcos.setNome("Marcos");
		
		Pessoa jose = new Pessoa();
		jose.setNome("Jos�");
		jose.setPai(marcos);

		Pessoa joao = new Pessoa();
		joao.setNome("Jo�o");
		joao.setPai(jose);
		
		System.out.println(joao.getDescricao());
		
	}
}

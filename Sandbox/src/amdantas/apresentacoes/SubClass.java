package amdantas.apresentacoes;

public class SubClass extends SuperClass {

	@Override
	public void metodo() {
		System.out.println("Podemos executar algo antes");
		super.metodo();
		System.out.println("Podemos executar algo depois");
	}
	
	public void metodo(String s) {
		System.out.println(s);
	}
	
}

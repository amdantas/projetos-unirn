package amdantas.apresentacoes;

public class MainSobrecarga {

	public static void main(String[] args) {
		SuperClass superC = new SuperClass();
		superC.metodo();
		System.out.println("-------");
		
		SubClass subC = new SubClass();
		subC.metodo();
		subC.metodo("String para sub");
		System.out.println("-------");
		
		SuperClass obj = new SubClass();
		obj.metodo();
	}
	
}

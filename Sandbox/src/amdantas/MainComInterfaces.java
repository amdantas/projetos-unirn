package amdantas;

public class MainComInterfaces {

	public static void main(String[] args) {
		MinhaClasse mc = new MinhaClasse();
		mc.operacao1();
		mc.operacao2("nome", "param2");
		mc.operacao3(3);
		mc.novaOperacao();
		System.out.println("------");
		OutraClasse oc = new OutraClasse();
		oc.operacao1();
		oc.operacao2("joao", "maria");
		oc.operacao3(4343);
		
		ComportamentoPadraoInt cp = mc;
		cp.operacao1();
		
	}
	
}

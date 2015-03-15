package amdantas;

public class Cachorro extends Animal {

	@Override
	public void emitirSom() {
		System.out.println("Au");
	}

	@Override
	public void caminhar() {
		System.out.println("Cachorro andando");
	}

	@Override
	public void comer() {
		System.out.println("Cachorro comendo");
	}
	
}

package amdantas;

public class Gato extends Animal {
	@Override
	public void emitirSom() {
		System.out.println("Miau");
	}

	@Override
	public void caminhar() {
		System.out.println("Gato andando");
	}

	@Override
	public void comer() {
		System.out.println("Gato comendo");
	}

}

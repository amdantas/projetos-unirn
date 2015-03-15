package amdantas;

public class Pessoa implements ComportamentoAnimalInt {

	@Override
	public void emitirSom() {
		System.out.println("Pessoa falando");
	}

	@Override
	public void caminhar() {
		System.out.println("Pessoa andando");
	}

	@Override
	public void comer() {
		System.out.println("Pessoa comendo");
	}

}

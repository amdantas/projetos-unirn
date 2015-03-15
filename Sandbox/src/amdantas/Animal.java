package amdantas;

public abstract class Animal implements ComportamentoAnimalInt {

	private String nomeDono;
	
	private String nomeAnimal;

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	
	
}

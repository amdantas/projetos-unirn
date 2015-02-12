package amdantas.aula02.exercicio2;

public class Endereco {

	private String rua;
	
	private Integer numero;
	
	private String cep;

	private Municipio municipio;
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		StringBuilder descricao = new StringBuilder();
		
		descricao.append("Rua " + rua + ", ");
		descricao.append(numero + "\r\n");
		descricao.append("Cidade: " + municipio.getNome() + "\r\n");
		descricao.append("CEP: " + cep + "\r\n");
		
		return descricao.toString();
	}
}

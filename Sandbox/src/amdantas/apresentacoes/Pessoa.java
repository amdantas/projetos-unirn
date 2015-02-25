package amdantas.apresentacoes;

import java.util.Date;

public class Pessoa {

	private String nome;
	
	private Date dataNascimento;
	
	private Character sexo;
	
	private String endere�o;
	
	private Pessoa pai;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getEndere�o() {
		return endere�o;
	}

	public void setEndere�o(String endere�o) {
		this.endere�o = endere�o;
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public String getDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append(nome + "");
		if (pai != null)
			descricao.append(" que � filho(a) de -> " + pai.getDescricao()+ " \r\n");
		
		return descricao.toString();
	}
	
}

package amdantas.aula09;

import java.io.Serializable;

public class Aluno implements Serializable{

	private String nome;
	
	private Integer matricula;

	public Aluno() {
		
	}
	public Aluno(String nome, Integer matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	
}

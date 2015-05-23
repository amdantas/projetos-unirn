package amdantas.aula09;

import java.io.Serializable;

public class Cidade implements Serializable {

	private String nome;
	
	private String estado;

	public Cidade(String n, String e) {
		nome = n;
		
		estado = e;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}

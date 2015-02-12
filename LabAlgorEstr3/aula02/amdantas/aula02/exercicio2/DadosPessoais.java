package amdantas.aula02.exercicio2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosPessoais {

	private String nome;
	
	private Date dataNascimento;
	
	private String email;
	
	private Municipio cidadeNascimento;
	
	private Endereco enderecoContato;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Municipio getCidadeNascimento() {
		return cidadeNascimento;
	}

	public void setCidadeNascimento(Municipio cidadeNascimento) {
		this.cidadeNascimento = cidadeNascimento;
	}

	public Endereco getEnderecoContato() {
		return enderecoContato;
	}

	public void setEnderecoContato(Endereco enderecoContato) {
		this.enderecoContato = enderecoContato;
	}
	
	@Override
	public String toString() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Nome: " + nome + "\r\n");
		descricao.append("Data de Nascimento: " + new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento) + "\r\n");
		descricao.append("Email: " + email + "\r\n");
		descricao.append("Cidade de nascimento: " + cidadeNascimento.getNome() + "\r\n");
		descricao.append("Endereço de contato: " + enderecoContato);
		descricao.append("=====================================");
		return descricao.toString();
	}
	
}

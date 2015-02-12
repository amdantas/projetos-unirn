package amdantas.aula02.exercicio3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MeuDate extends Date {

	public void alterarDia(int d) {
		setDate(d);
	}
	
	public void alterarMes(int m) {
		setMonth(m);
	}
	
	
	public void alterarAno(int a) {
		setYear(a - 1900);
	}
	
	public void exibirData() {
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("A data de hoje é: " + df.format(this));
	}
	
}

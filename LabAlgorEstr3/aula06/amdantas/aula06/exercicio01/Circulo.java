package amdantas.aula06.exercicio01;

public class Circulo implements FiguraOperacoesInt {

	private double raio;

	public Circulo(double r) {
		raio = r;
	}
	
	public void novo() {
		
	}
	
	@Override
	public double calcularArea() {
		return Math.PI * Math.pow(raio, 2.0);
	}

	@Override
	public double calcularPerimetro() {
		return 2 * Math.PI * raio;
	}
	
	
}

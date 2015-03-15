package amdantas.aula06.exercicio01;

public class Retangulo implements FiguraOperacoesInt{

	private double base;
	private double altura;
	
	public Retangulo(double b, double a) {
		base = b;
		altura = a;
	}
	
	@Override
	public double calcularArea() {
		return base * altura;
	}

	@Override
	public double calcularPerimetro() {
		return base + altura;
	}


}

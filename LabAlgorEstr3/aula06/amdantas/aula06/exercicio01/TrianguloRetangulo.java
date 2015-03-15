package amdantas.aula06.exercicio01;

public class TrianguloRetangulo implements FiguraOperacoesInt{

	private double base;
	private double altura;
	private double diagonal;
	
	public TrianguloRetangulo(double b, double a, double d) {
		base = b;
		altura = a;
		diagonal = d;
	}
	
	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return (base * altura) / 2;
	}

	@Override
	public double calcularPerimetro() {
		return base + altura + diagonal;
	}

}

package amdantas.aula06.exercicio01;

public class Main {

	public static void main(String[] args) {
		
		Circulo c = new Circulo(2.3);
		c.novo();
		Retangulo r = new Retangulo(34.2, 12.4);
		TrianguloRetangulo t = new TrianguloRetangulo(4.0, 3.0, 5.0);
		
		FiguraOperacoesInt[] vetor = {c, r, t};
		
		for (FiguraOperacoesInt fig : vetor) {
			System.out.println(fig.getClass().getSimpleName());
			System.out.println("Área: " + fig.calcularArea());
			System.out.println("Perímetro: " + fig.calcularPerimetro());
		}
		
	}
	
}

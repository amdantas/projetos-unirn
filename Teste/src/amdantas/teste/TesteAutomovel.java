package amdantas.teste;

public class TesteAutomovel {

	public static void main(String[] args) {
		
		MeiosDeTransporte aviao = new Aviao();
		
		aviao.acelerar();
		
//		aviao.setPlaca("CDD4343");
		
		Automovel fusca = new Automovel();
		
		fusca.setPlaca("CDD4343");
		
		System.out.println(fusca.getPlaca());
		
		
		int[] vetor = new int[3];
		vetor[0] = 45;
		vetor[2] = 23;
		vetor[1] = 10;
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Posição " + i + ": " + vetor[i]);
		}
		
		MeuVetor v = new MeuVetor(3);
		v.adicionaElemento(0, 45);
		v.adicionaElemento(1, 10);
		v.adicionaElemento(2, 23);
		v.exibirElementos();
		
	}
	
}

class MeuVetor {
	
	public MeuVetor(int i) {
		
	}
	public void exibirElementos() {
		// TODO Auto-generated method stub
		
	}
	public void adicionaElemento(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	private int tamanhoMaximo;

	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}

	public void setTamanhoMaximo(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
	}
	
	
}


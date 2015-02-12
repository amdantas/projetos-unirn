package amdantas.apresentacoes;

public class Automovel {
	
	public static String formatoPlaca = "XXX-0000";

	private String placa;

	private String cor;

	private String combustivel;

	private Integer potenciaMotor;
	
	protected String nomeDono;

	@Override
	public boolean equals(Object obj) {
		Automovel auto = (Automovel) obj;
		return auto.getPlaca().equals(this.getPlaca());
	}
	
	@Override
	public String toString() {
		return "objeto de automóvel da placa: " + placa;
	}
	
	public Automovel() {
		
	}
	
	public Automovel(String p, String c, String co, Integer po) {
		placa = p;
		cor = c;
		combustivel = co;
		potenciaMotor = po;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getPotenciaMotor() {
		return potenciaMotor;
	}

	public void setPotenciaMotor(Integer potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}

	public void ligar() {
		if (potenciaMotor > 1000) {
			// ligar de um jeito
		} else {
			// ligar de outro jeito
		}
	}

	public void acelerar() {

	}

	public void brecar() {

	}

}

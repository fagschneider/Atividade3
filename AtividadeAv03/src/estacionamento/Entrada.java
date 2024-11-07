package estacionamento;

public class Entrada {

	private String placa;
	private int vaga;
	private int entrada;
	private int entradaMin;
	private int saida;
	private int saidaMin;
	
	
	
	
	public Entrada(String placa, int vaga, int entrada, int entradaMin, int saida, int saidaMin) {
		super();
		this.placa = placa;
		this.vaga = vaga;
		this.entrada = entrada;
		this.entradaMin = entradaMin;
		this.saida = saida;
		this.saidaMin = saidaMin;
	}



	public Entrada(String placa, int vaga, int entrada) {
		super();
		this.placa = placa;
		this.vaga = vaga;
		this.entrada = entrada;
	}

	

	public Entrada(String placa, int vaga, int entrada, int saida) {
		super();
		this.placa = placa;
		this.vaga = vaga;
		this.entrada = entrada;
		this.saida = saida;
	}



	
	
	public int getSaidaMin() {
		return saidaMin;
	}



	public void setSaidaMin(int saidaMin) {
		this.saidaMin = saidaMin;
	}



	public int getEntradaMin() {
		return entradaMin;
	}



	public void setEntradaMin(int entradaMin) {
		this.entradaMin = entradaMin;
	}



	public int getSaida() {
		return saida;
	}



	public void setSaida(int saida) {
		this.saida = saida;
	}



	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public int getVaga() {
		return vaga;
	}


	public void setVaga(int vaga) {
		this.vaga = vaga;
	}


	public double getEntrada() {
		return entrada;
	}


	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}



	@Override
	public String toString() {
		return "Placa:" + placa + " Vaga:" + vaga + " Entrada:" + entrada + ":" + entradaMin + " Saida:" + saida + ":" + saidaMin;
	}


	
	
	
	

}

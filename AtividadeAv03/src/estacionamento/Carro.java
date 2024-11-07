package estacionamento;

public class Carro {
	
	private String placa;
	private String modelo;
	private String tamanho;
	private int entradaHrs;
	private int entradaMin;
	private int saidaHrs;
	private int saidaMin;
	
	
	
	



	public Carro(String placa, String modelo, String tamanho) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
	}




	public Carro(String placa, String modelo, String tamanho, int entradaHrs, int entradaMin, int saidaHrs,
			int saidaMin) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.entradaHrs = entradaHrs;
		this.entradaMin = entradaMin;
		this.saidaHrs = saidaHrs;
		this.saidaMin = saidaMin;
	}




	public int getEntradaHrs() {
		return entradaHrs;
	}




	public void setEntradaHrs(int entradaHrs) {
		this.entradaHrs = entradaHrs;
	}




	public int getEntradaMin() {
		return entradaMin;
	}




	public void setEntradaMin(int entradaMin) {
		this.entradaMin = entradaMin;
	}




	public int getSaidaHrs() {
		return saidaHrs;
	}




	public void setSaidaHrs(int saidaHrs) {
		this.saidaHrs = saidaHrs;
	}




	public int getSaidaMin() {
		return saidaMin;
	}




	public void setSaidaMin(int saidaMin) {
		this.saidaMin = saidaMin;
	}




	public String getPlaca() {
		return placa;
	}




	public void setPlaca(String placa) {
		this.placa = placa;
	}




	public String getModelo() {
		return modelo;
	}




	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getTamanho() {
		return tamanho;
	}




	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}




	




	

	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", tamanho=" + tamanho + "]";
	}
		
}

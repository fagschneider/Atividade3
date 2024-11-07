package estacionamento;

public class Vaga {
	private int numero;
	private String tamanho;
	private boolean disp;
	
	
	public Vaga(int numero, String tamanho, boolean disp) {
		super();
		this.numero = numero;
		this.tamanho = tamanho;
		this.disp = disp;
	}
	
	


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTamanho() {
		return tamanho;
	}


	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}


	public boolean isDisp() {
		return disp;
	}


	public void setDisp(boolean disp) {
		this.disp = disp;
	}




	@Override
	public String toString() {
		return "Vaga [numero=" + numero + ", tamanho=" + tamanho + ", disp=" + disp + "]";
	}
	
	
}

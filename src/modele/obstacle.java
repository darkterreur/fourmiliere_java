package modele;

public class obstacle {

	//attribut
	private String forme;
	
	//methode
	public obstacle(String forme) {
		super();
		this.forme = forme;
	}

	@Override
	public String toString() {
		return "obstacle [forme=" + forme + "]";
	}
	
	//accesseur
	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}
	
	
	
}

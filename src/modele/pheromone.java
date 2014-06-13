package modele;

public class pheromone {
	//attribut
	private int qte_phero;
	private int phero_base;
	
	//methode
	public pheromone(int phero_base) {
		this.qte_phero = phero_base;
		this.phero_base = phero_base;
	}
	@Override
	public String toString() {
		return "pheromone [qte_phero=" + qte_phero + ", phero_base="
				+ phero_base + "]";
	}
	
	//fonction qui ajout une valeur de phéromone a l'éxistant
	public void ajoutPheromone(int add){
		int cumul = this.getQte_phero() + add;
		this.setQte_phero(cumul);
	}
	
	//fonction qui enleve 1 de pheromone a chaque tour
	public void decrementePheromone(){
		this.setQte_phero(this.getQte_phero()-1);
	}
	
	//accesseur
	public int getQte_phero() {
		return qte_phero;
	}
	public void setQte_phero(int qte_phero) {
		this.qte_phero = qte_phero;
	}
	public int getPhero_base() {
		return phero_base;
	}
	public void setPhero_base(int phero_base) {
		this.phero_base = phero_base;
	}
	
	
	
}

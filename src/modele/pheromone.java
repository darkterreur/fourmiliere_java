package modele;

public class pheromone {
	//attribut
	private int qte_phero;
	private int x;
	private int y;
	private pheromone nextPheromone = null;
	private monde m;
	
	//methode
	public pheromone(int X, int Y, pheromone nextPheromone, monde m) {
		this.x = X;
		this.y = Y;
		this.nextPheromone = nextPheromone;
		this.m = m;
		this.qte_phero = this.m.getVitesseEvaporationPhero();
	}
	
	public pheromone getPheromoneSuivante () {
		try {
			int indexNextPhero = this.m.getPheromones().indexOf(nextPheromone);
			pheromone phero = this.m.getPheromones().get(indexNextPhero);
			return phero;
		} catch (IndexOutOfBoundsException exception) {
			return null;
		}
	}
	
	public boolean isEmpty() {
		if (this.qte_phero <= 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean hasNextPheromone() {
		pheromone phero = this.getPheromoneSuivante();
		if (phero != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getIndexOfNextPheromone() {
		return this.m.getPheromones().indexOf(nextPheromone);
	}
	
	/*
	@Override
	public String toString() {
		return "pheromone [qte_phero=" + qte_phero + ", phero_base=" + phero_base + ", x=" + x + ", y=" + y + "]";
	}
	
	//fonction qui ajout une valeur de phŽromone a l'Žxistant
	public void ajoutPheromone(int add){
		int cumul = this.getQte_phero() + add;
		this.setQte_phero(cumul);
	}
	*/
	
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
	
	public int getX() {
		return x;
	}
	public void setX(int X) {
		this.x = X;
	}
	public int getY() {
		return y;
	}
	public void setY(int Y) {
		this.y = Y;
	}
	
	
}

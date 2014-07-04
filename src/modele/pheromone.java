package modele;

/**
 * Phéromone dans le monde
 */
public class pheromone {
	private int qte_phero;
	private int x;
	private int y;
	
	public pheromone(int X, int Y) {
		this.x = X;
		this.y = Y;
		this.qte_phero = monde.vitesseEvaporationPhero;
	}
	
	/**
	 * Vide
	 * @return
	 */
	public boolean isEmpty() {
		if (this.qte_phero <= 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode()
    {
		return this.x + this.y;
	}
	
	@Override
	public boolean equals(Object o) {
		pheromone other = (pheromone) o;
		return (this.x == other.x && this.y == other.y) ? true : false;
	}
	
	/**
	 * Enlève un de phéromone à chaque tour
	 */
	public void decrementePheromone(){
		this.setQte_phero(this.getQte_phero()-1);
	}
	
	public int getQte_phero() {
		return qte_phero;
	}
	public void setQte_phero(int qte_phero) {
		this.qte_phero = qte_phero;
	}
	
	public int getX() {
		return this.x;
	}
	public void setX(int X) {
		this.x = X;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int Y) {
		this.y = Y;
	}
}

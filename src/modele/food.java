package modele;

public class food {
	//attribut
	private int valeur_base_food;
	private int qte_rest_food;
	
	//methode
	public food(int valeur_base_food, int qte_rest_food) {
		super();
		this.valeur_base_food = valeur_base_food;
		this.qte_rest_food = qte_rest_food;
	}
	@Override
	public String toString() {
		return "food [valeur_base_food=" + valeur_base_food
				+ ", qte_rest_food=" + qte_rest_food + "]";
	}
	
	//accesseur
	public int getValeur_base_food() {
		return valeur_base_food;
	}
	public void setValeur_base_food(int valeur_base_food) {
		this.valeur_base_food = valeur_base_food;
	}
	public int getQte_rest_food() {
		return qte_rest_food;
	}
	public void setQte_rest_food(int qte_rest_food) {
		this.qte_rest_food = qte_rest_food;
	}
	
	
	
}

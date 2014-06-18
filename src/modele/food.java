package modele;

public class food {
	//attribut
	private int valeur_base_food;
	private int qte_rest_food;
	private int x;
	private int y;
	//prevoir d'une maniere ou d'une autre une liste de point
	
	//methode
	public food(int valeur_base_food, int X, int Y) {
		this.valeur_base_food = valeur_base_food;
		this.qte_rest_food = valeur_base_food;
		this.x = X;
		this.y = Y;
	}
	@Override
	public String toString() {
		return "food [valeur_base_food=" + valeur_base_food + ", qte_rest_food=" + qte_rest_food + "" +
				", x=" + x + ", y=" + y + "]";
	}
	
	public void decrementeFood(){
		this.setQte_rest_food(this.getQte_rest_food() - 1);
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

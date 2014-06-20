package modele;

public class food {
	//attribut
	public static String feuille = "feuille";
	
	protected int valeur_base_food;
	protected int qte_rest_food;
	protected int x;
	protected int y;
	protected int width = 0;
	protected int height = 0;
	protected String forme;
	//prevoir d'une maniere ou d'une autre une liste de point
	
	//methode
	public food(String forme, int X, int Y) {
		this.qte_rest_food = valeur_base_food;
		this.x = X;
		this.y = Y;
		this.forme = forme;
	}
	@Override
	public String toString() {
		return "food [valeur_base_food=" + valeur_base_food + ", qte_rest_food=" + qte_rest_food + "" +
				", x=" + x + ", y=" + y + "]";
	}
	
	public void decrementeFood(){
		this.qte_rest_food--;
	}
	
	/**
	 * Test la valeur de la nourriture pour savoir quelle apparence elle aura
	 * @return int Le pourcentage utilisé de la nourriture
	 */
	public int testValeurFood() {
		return ((this.qte_rest_food * 100) / this.valeur_base_food);
	}
	
	//accesseur
	public String getForme() {
		return this.forme;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
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

package modele;

/**
 * Nourriture de l'environnement
 */
public class food {
	public static String feuille = "feuille";
	public static int valeurBaseFood = 100;
	
	protected int qte_rest_food;
	protected int x;
	protected int y;
	protected int width = 0;
	protected int height = 0;
	protected String forme;
	
	public food(String forme, int X, int Y) {
		this.qte_rest_food = food.valeurBaseFood;
		this.x = X;
		this.y = Y;
		this.forme = forme;
	}
	
	/**
	 * Test le pourcentage de nourriture restante pour savoir quelle apparence elle aura
	 * @return int Le pourcentage utilisé de la nourriture
	 */
	public int testValeurFood() {
		return ((this.qte_rest_food * 100) / food.valeurBaseFood);
	}
	
	public void decrementeFood(){
		this.qte_rest_food--;
	}
	
	public String getForme() {
		return this.forme;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
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

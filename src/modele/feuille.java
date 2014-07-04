package modele;

/**
 * Nourriture de l'environnement
 */
public class feuille extends food {
	public feuille(String forme, int x, int y) {
		super(forme, x, y);
		this.width = 20;
		this.height = 80;
		
		this.qte_rest_food = food.valeurBaseFood;
	}
}

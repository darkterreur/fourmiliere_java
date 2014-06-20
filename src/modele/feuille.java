package modele;

public class feuille extends food {
	public feuille(String forme, int x, int y) {
		super(forme, x, y);
		this.width = 20;
		this.height = 80;
		
		this.valeur_base_food = 20;
		this.qte_rest_food = this.valeur_base_food;
	}
}

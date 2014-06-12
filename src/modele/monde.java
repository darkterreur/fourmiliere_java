package modele;

public class monde {

	//attribut
	private int qte_obj_obst;
	private int qte_fourm;
	private int qte_obj_food;
	private int largeur;
	private int hauteur;
	
	//methode
	public monde(int qte_obj_obst, int qte_fourm, int qte_obj_food,
			int largeur, int hauteur) {
		super();
		this.qte_obj_obst = qte_obj_obst;
		this.qte_fourm = qte_fourm;
		this.qte_obj_food = qte_obj_food;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	@Override
	public String toString() {
		return "monde [qte_obj_obst=" + qte_obj_obst + ", qte_fourm="
				+ qte_fourm + ", qte_obj_food=" + qte_obj_food + ", largeur="
				+ largeur + ", hauteur=" + hauteur + "]";
	}
	
	//accesseur
	public int getQte_obj_obst() {
		return qte_obj_obst;
	}
	public void setQte_obj_obst(int qte_obj_obst) {
		this.qte_obj_obst = qte_obj_obst;
	}
	public int getQte_fourm() {
		return qte_fourm;
	}
	public void setQte_fourm(int qte_fourm) {
		this.qte_fourm = qte_fourm;
	}
	public int getQte_obj_food() {
		return qte_obj_food;
	}
	public void setQte_obj_food(int qte_obj_food) {
		this.qte_obj_food = qte_obj_food;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	
	
}

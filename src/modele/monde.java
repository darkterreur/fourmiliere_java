package modele;

import java.util.ArrayList;

public class monde{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//attribut
	private int qte_obj_obst;
	private int qte_fourm;
	private int qte_obj_food;
	private int largeur;
	private int hauteur;
	private ArrayList<obstacle> obstacles = new ArrayList<obstacle>();
	
	//methode
	public monde(int qte_obj_obst, int qte_fourm, int qte_obj_food) {
		
		this.qte_obj_obst = qte_obj_obst;
		this.qte_fourm = qte_fourm;
		this.qte_obj_food = qte_obj_food;
	}
	
	
	@Override
	public String toString() {
		return "monde [qte_obj_obst=" + qte_obj_obst + ", qte_fourm="
				+ qte_fourm + ", qte_obj_food=" + qte_obj_food + ", largeur="
				+ largeur + ", hauteur=" + hauteur + "]";
	}
	
	//accesseur
	public ArrayList<obstacle> getObstacles() {
		return this.obstacles;
	}
	
	public void setObstacles(ArrayList<obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public void addCailloux(int x, int y) {
		this.obstacles.add(new cailloux(obstacle.cailloux, x, y));
	}
	
	public void addFlac(int x, int y) {
		this.obstacles.add(new flac(obstacle.flac, x, y));
	}
	
	public void addBranche(int x, int y) {
		this.obstacles.add(new branche(obstacle.branche, x, y));
	}
	
	public void addFeuille(int x, int y) {
		this.obstacles.add(new feuille(obstacle.feuille, x, y));
	}
	
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

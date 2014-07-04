package modele;

import java.util.ArrayList;
import java.util.HashMap;

public class fourmiliere {
	private int x;
	private int y;
	private monde monde;
	private int qte_food_recolter = 0;
	private int qte_fourmi = 0;
	private int max_fourmi;
	private int qte_food_creat_fourmi;
	private int width = 0;
	private int height = 0;
	private ArrayList<fourmi> fourmis = new ArrayList<fourmi>();					// La liste des fourmis de cette fourmilière
	private HashMap<Contournement, Contournement> memoireCollectiveContournement
			= new HashMap<Contournement, Contournement>();							// Mémoire de la fourmilière sur les chemins de contournement les plus courts
	
	/**
	 * Définie l'emplacement de la fourmilière et le monde auquel elle appartient
	 * @param X
	 * @param Y
	 * @param m
	 */
	public fourmiliere(int X, int Y, monde m) {
		this.monde = m;
		this.x = X;
		this.y = Y;
		this.width = 30;
		this.height = 30;
	}
	
	/**
	 * Parcours toutes les fourmis de la fourmilière et les fait avancer
	 */
	public void nextStep() {
		ArrayList<fourmi> fourmis = this.fourmis;
		
		for (int i=0; i<fourmis.size(); i++) {
	    	fourmi fourmiCourante = fourmis.get(i);
	    	fourmiCourante.avance();
	    }
	}
	
	/**
	 * Ajoute une quantité de nourriture à la fourmilière
	 * @param quantite
	 */
	public void addFood(int quantite) {
		this.qte_food_recolter += quantite;
		this.getMonde().getSimulation().getInfosModele().setQteNourritureFourmiliere(this.qte_food_recolter);
	}
	
	/**
	 * Ajoute une fourmi et la lie à cette fourmilière
	 */
	public void addFourmi() {
		this.fourmis.add(new fourmi(this));
	}
	
	/**
	 * Retourne toutes les fourmis
	 * @return
	 */
	public ArrayList<fourmi> getFourmis() {
		return this.fourmis;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public monde getMonde() {
		return this.monde;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getQte_food_recolter() {
		return qte_food_recolter;
	}
	public void setQte_food_recolter(int qte_food_recolter) {
		this.qte_food_recolter = qte_food_recolter;
	}
	public int getQte_fourmi() {
		return qte_fourmi;
	}
	public void setQte_fourmi(int qte_fourmi) {
		this.qte_fourmi = qte_fourmi;
	}
	public int getMax_fourmi() {
		return max_fourmi;
	}
	public void setMax_fourmi(int max_fourmi) {
		this.max_fourmi = max_fourmi;
	}
	public int getQte_food_creat_fourmi() {
		return qte_food_creat_fourmi;
	}
	public void setQte_food_creat_fourmi(int qte_food_creat_fourmi) {
		this.qte_food_creat_fourmi = qte_food_creat_fourmi;
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

	public HashMap<Contournement, Contournement> getMemoireCollectiveContournement() {
		return memoireCollectiveContournement;
	}

	public void setMemoireCollectiveContournement(
			HashMap<Contournement, Contournement> memoireCollectiveContournement) {
		this.memoireCollectiveContournement = memoireCollectiveContournement;
	}

	public void setMonde(monde monde) {
		this.monde = monde;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setFourmis(ArrayList<fourmi> fourmis) {
		this.fourmis = fourmis;
	}
}

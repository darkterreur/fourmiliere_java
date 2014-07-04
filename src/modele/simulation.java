package modele;

import java.util.ArrayList;

/**
 * La simulation
 */
public class simulation {
	public int x;
	public int y;
	public int hauteur;
	public int largeur ;
	private int nombrePas = 0;
	public ArrayList<monde> listeMondes = new ArrayList<monde>();
	private boolean isStart = true;									// Définie si c'est la première fois que la simulation est lancée
	private Parametrage params;										// Paramètres de la simulation
	private Informations infosModele = new Informations();			// Information sur la simulation
	
	public simulation(Parametrage params) {
		this.hauteur=params.getTaille();
		this.largeur=params.getTaille();
		this.x=0;
		this.y=0;
		this.params = params;
	}
	
	/**
	 * Parcoure les mondes et avance d'une étape chacun d'eux
	 */
	public void nextStep() {
		ArrayList<monde> mondes = this.listeMondes;
		this.infosModele.setNumeroPasSim(this.infosModele.getNumeroPasSim()+1);
		
		for (int i=0; i<mondes.size(); i++) {
	    	monde m = mondes.get(i);
	    	m.nextStep();
	    }
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public Parametrage getParams() {
		return this.params;
	}
	
	public void setParams(Parametrage  parametres) {
		this.params = parametres;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public boolean isStart() {
		return this.isStart;
	}
	
	public void setIsStart(boolean isStart) {
		this.isStart = isStart;
	}
	
	public void addMonde(monde m) {
		this.listeMondes.add(m);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNombrePas() {
		return nombrePas;
	}

	public void setNombrePas(int nombrePas) {
		this.nombrePas = nombrePas;
	}

	public ArrayList<monde> getListeMondes() {
		return listeMondes;
	}

	public void setListeMondes(ArrayList<monde> listeMondes) {
		this.listeMondes = listeMondes;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}

	public Informations getInfosModele() {
		return infosModele;
	}

	public void setInfosModele(Informations infosModele) {
		this.infosModele = infosModele;
	}
}

package modele;

import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class simulation {
	public int x;
	public int y;
	public int hauteur;
	public int largeur ;
	public ArrayList<monde> listeMondes = new ArrayList<monde>();
	// Définie si c'est la première fois que la simulation est lancée
	private boolean isStart = true;
	
	public simulation(int taille) {
		hauteur=taille;
		largeur=taille;
		x=0;
		y=0;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public boolean isStart() {
		return this.isStart;
	}
	
	public void nextStep() {
		// Parcoure les mondes et avance d'une étape chacun d'eux
		ArrayList<monde> mondes = this.listeMondes;
		
		for (int i=0; i<mondes.size(); i++) {
	    	monde m = mondes.get(i);
	    	m.nextStep();
	    }
	}
	
	public void setIsStart(boolean isStart) {
		this.isStart = isStart;
	}
	
	public void addMonde(monde m) {
		this.listeMondes.add(m);
	}
}

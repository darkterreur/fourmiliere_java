package modele;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class simulation {
	public int x;
	public int y;
	int hauteur;
	int largeur ;
	
	// D�finie si c'est la premi�re fois que la simulation est lanc�e
	public boolean isStart = true;
	public ArrayList<monde> listeMondes = new ArrayList<monde>();
	
	public simulation(int taille) {
		hauteur=taille;
		largeur=taille;
		x=0;
		y=0;
	}
	
	public void nextStep() {
		
		// Parcoure les mondes et avance d'une �tape chacun d'eux
		
	}
	
	public void addMonde(monde m) {
		this.listeMondes.add(m);
	}
}

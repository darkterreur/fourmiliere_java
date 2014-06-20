package modele;

import java.util.ArrayList;
import java.util.Hashtable;

public class fourmi {
	//attribut
	public static int EAST = 0;
	public static int SOUTH = 1;
	public static int WEST = 2;
	public static int NORTH = 3;
	public static int NORTH_EAST = 4;
	public static int SOUTH_EAST = 5;
	public static int SOUTH_WEST = 6;
	public static int NORTH_WEST = 7;
	// Fourmili�re va servir � conna�tre la fourmili�re m�re, et d'en d�duire les coordonn�es lors du retour � la fourmili�re 
	private fourmiliere fourmiliereMere;
	private int x;
	private int y;
	private int width = 10;
	private int height = 10;
	private int chargePortee = 0;
	public boolean isRetourFourmiliere = false;
	private boolean suitPheromone = false;
	private boolean isSurNourriture = false;
	public boolean deposePheromone = false;
	private int indexNourritureMangee;
	private int indexObstacleAContourner;
	private boolean isContournementBas = false;
	private boolean isContournementGauche = false;
	private boolean isContournementHaut = false;
	private boolean isContournementDroite = false;
	
	/*
	private food monFood;
	private int charge_max;
	private int charge_porter;
	// Plein est donc un booleen
	//private boolean plein;*/
	
	//methode
	public fourmi(fourmiliere f) {
		this.x = f.getX();
		this.y = f.getY();
		this.fourmiliereMere = f;
	}
	
	
	// Fait avancer la fourmie d'un pas
	public void avance() {
		int positionInitialeX = this.x;
		int positionInitialeY = this.y;
		
		/*
		if (this.isContournementBas || this.isContournementGauche || this.isContournementHaut || this.isContournementDroite) {
			this.contourneObstacle();
			this.isContournementBas = false;
			this.isContournementGauche = false;
			this.isContournementHaut = false;
			this.isContournementDroite = false;
			this.indexObstacleAContourner = -1;
		} else
		*/
		
		if (this.isRetourFourmiliere) {
			// Avancer vers la fourmili�re en ligne droite
			this.deposePheromone();
			
			if (this.x > this.fourmiliereMere.getX()) {
				this.x-=5;
			} else if (this.x < this.fourmiliereMere.getX()) {
				this.x+=5;
			}
			
			if (this.y > this.fourmiliereMere.getY()) {
				this.y-=5;
			} else if (this.y < this.fourmiliereMere.getY()) {
				this.y+=5;
			}
		} else if (this.isSurNourriture()) {
			this.getNourriture();
		} else if (false) {
		// Sinon si la fourmi suit des ph�romones
			// Chercher une autre ph�romone
			// Se d�placer � l'emplacement de la ph�romone trouv�e
		} else {
		// Sinon
			if (false) {
			// Chercher une ph�romone � proximit�
			// Si une ph�romone est � proximit�
				// Se d�placer vers celle-ci
			} else {
			// Sinon
				// Se d�placer d'un pas dans une direction al�atoire
				Hashtable<String, Integer> positions = this.calculDeplacementAleatoire();
				this.x = positions.get("x");
				this.y = positions.get("y");
			}
		}
		
		// Si la direction d�finie est un obstacle, lancer le contournement de l'obstacle
		while (this.directionIsObstacle()) {
			//this.contourneObstacle();
			this.x = positionInitialeX;
			this.y = positionInitialeY;
			
			Hashtable<String, Integer> positions = this.calculDeplacementAleatoire();
			this.x = positions.get("x");
			this.y = positions.get("y");
		}
	}
	
	public Hashtable calculDeplacementAleatoire() {
		int abscisse=this.x, ordonnee=this.y;
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		
		double randomTemp = Math.random()*10;
		int random = (int) randomTemp;
		
		if (random == this.EAST && this.x < this.fourmiliereMere.getMonde().getSimulation().getLargeur()) {
			abscisse+=5;
		} else if (random == this.SOUTH && this.y < this.fourmiliereMere.getMonde().getSimulation().getHauteur()) {
			ordonnee+=5;
		} else if (random == this.WEST && this.x > 0) {
			abscisse-=5;
		} else if (random == this.NORTH && this.y > 0) {
			ordonnee-=5;
		} else if (random == this.NORTH_EAST && this.x < this.fourmiliereMere.getMonde().getSimulation().getLargeur() && this.y > 0) {
			abscisse+=5;
			ordonnee-=5;
		} else if (random == this.SOUTH_EAST && this.x < this.fourmiliereMere.getMonde().getSimulation().getLargeur() && this.y < this.fourmiliereMere.getMonde().getSimulation().getHauteur()) {
			abscisse+=5;
			ordonnee+=5;
		} else if (random == this.SOUTH_WEST && this.y < this.fourmiliereMere.getMonde().getSimulation().getHauteur() && this.x > 0) {
			abscisse-=5;
			ordonnee+=5;
		} else if (random == this.NORTH_WEST && this.x > 0 && this.y > 0) {
			abscisse-=5;
			ordonnee-=5;
		}
		
		ht.put("x", abscisse);
		ht.put("y", ordonnee);
		
		return ht;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	// D�pose une quantit� de ph�romone � l'emplacement courant
	public void deposePheromone(){
		this.fourmiliereMere.getMonde().getPheromones().add(new pheromone(this.x, this.y));
	}
	
	// V�rifie si des ph�romones sont proches de la position de la fourmi
	public void pheromoneAProximite(){

	}
	
	// Cherche le prochain ph�romone � suivre
	public void searchNextPheromone(){

	}

	// V�rifie si de la nourriture est proche de la position de la fourmi
	public boolean isSurNourriture(){
		ArrayList<food> foods = this.fourmiliereMere.getMonde().getFoods();
		
		for (int k=0; k<foods.size(); k++) {
			food foodCourante = foods.get(k);
			
			if (foodCourante.getForme() == food.feuille && ((this.x >= foodCourante.x && this.x <= foodCourante.x+20) && (this.y >= foodCourante.y+10 && this.y <= foodCourante.y+60))) {
				this.isSurNourriture = true;
				this.indexNourritureMangee = k;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean directionIsObstacle() {
		ArrayList<obstacle> obstacles = this.fourmiliereMere.getMonde().getObstacles();
		
		for (int k=0; k<obstacles.size(); k++) {
			obstacle obstacleCourant = obstacles.get(k);
			
			if (obstacleCourant.getForme() == obstacle.cailloux) {
				if ((this.x >= obstacleCourant.x && this.x <= obstacleCourant.x+10) && (this.y >= obstacleCourant.y && this.y <= obstacleCourant.y+10)) {
					this.indexObstacleAContourner = k;
					return true;
				}
			}
		}
		
		return false;	
	}
	
	// R�cup�re la nourriture
	public void getNourriture(){
		// R�cup�re une quantit� de nourriture
		this.chargePortee++;
		
		// Met � jour la quantit� dans l'objet nourriture
		this.fourmiliereMere.getMonde().getFoods().get(this.indexNourritureMangee).decrementeFood();
		
		if (this.fourmiliereMere.getMonde().getFoods().get(this.indexNourritureMangee).getQte_rest_food() <= 0) {
			this.fourmiliereMere.getMonde().getFoods().remove(this.indexNourritureMangee);
		}
		
		this.indexNourritureMangee = -1;
		
		// Retourne � la fourmili�re
		this.isRetourFourmiliere = true;
		
		// Et d�pose des ph�romones en chemin
		this.deposePheromone = true;
	}

	// D�pose la nourriture � la fourmili�re
	public void deposeNourriture(){
		// Met � jour la quantit� dans l'objet fourmili�re
		this.fourmiliereMere.addFood(this.chargePortee);

		// Enl�ve une quantit� de nourriture
		this.chargePortee--;

		// D�sactive le retour � la fourmili�re
		this.isRetourFourmiliere = false;

		// Et ne d�pose plus de ph�romones en chemin
		this.deposePheromone = false;
	}

	// V�rifie si un obstacle est proche de la position de la fourmi
	public void hasObstacleProximite(){

	}

	// Contourne un obstacle selon la strat�gie d'�vitement d�finie par l'utilisateur
	public void contourneObstacle(){
		obstacle obstacleAContourner = this.fourmiliereMere.getMonde().getObstacles().get(this.indexObstacleAContourner);
		
		/*if (this.isContournementHaut) {
			this.x += 5;
		} else if (this.isContournementBas) {
			this.x -=5;
		} else if (this.isContournementDroite) {
			this.y -= 5;
		} else if (this.isContournementGauche) {
			this.y += 5;
		} else {*
			if (this.x < obstacleAContourner.x && this.y == obstacleAContourner.y) {
				// Arrive de la gauche : contourne par le haut
				this.isContournementHaut = true;
				this.y += 5;
			} else if (this.x > obstacleAContourner.x && this.y == obstacleAContourner.y) {
				// Arrive de la droite : contourne par le bas
				this.isContournementBas = true;
				this.y -= 5;
			} else if (this.x == obstacleAContourner.x && this.y > obstacleAContourner.y) {
				// Arrive par le haut : contourne par la droite
				this.isContournementDroite = true;
				this.x += 5;
			} else if (this.x == obstacleAContourner.x && this.y < obstacleAContourner.y) {
				// Arrive par le bas : contourne par la gauche
				this.isContournementGauche = true;
				this.x -= 5;
			} else if (this.x < obstacleAContourner.x && this.y > obstacleAContourner.y) {
				// Arrive par en haut � gauche : contourne par la droite
				this.x += 5;
			} else if (this.x > obstacleAContourner.x && this.y > obstacleAContourner.y) {
				// Arrive par en haut � droite : contourne par le bas
				this.y -= 5;
			} else if (this.x > obstacleAContourner.x && this.y < obstacleAContourner.y) {
				// Arrive par en bas � droite : contourne par la gauche
				this.x -= 5;
			}  else if (this.x < obstacleAContourner.x && this.y < obstacleAContourner.y) {
				// Arrive par en bas � gauche : contourne par le haut
				this.y += 5;
			}
		//}*/
	}	
	
	//fonction existe deja et on met a jour l'objet nourriture plus haut dans un controleur
	// C'est une fourmi qui prend de la nourritre
	// R�cup�re la nourriture
	/*public void getNourriture(){
		// R�cup�re une quantit� de nourriture
		this.charge_porter++;
		
		// Met � jour la quantit� dans l'objet nourriture
		
		
		// Retourne � la fourmili�re
		this.isRetourFourmiliere = true;
		
		// Et d�pose des ph�romones en chemin
		this.deposePheromone = true;
	}*/
	
	//pareil existe deja et c'est pas le bon endrois
	// Si c'est le bon endroit : "une Fourmi depose de la nourriture", c'est donc la fourmi qui a cette fonction
	// D�pose la nourriture � la fourmili�re
	/*public void deposeNourriture(){
		// Met � jour la quantit� dans l'objet fourmili�re
		this.fourmiliere.qte_food_recolter += this.charge_porter;
		
		// Enl�ve une quantit� de nourriture
		this.charge_porter--;
		
		// D�sactive le retour � la fourmili�re
		this.isRetourFourmiliere = false;
		
		// Et ne d�pose plus de ph�romones en chemin
		this.deposePheromone = false;
	}*/
	
	
	/*
	@Override
	public String toString() {
		return "fourmi [charge_max=" + charge_max + ", charge_porter=" + charge_porter + ", plein=" + plein + ", x=" + x + ", y=" + y + "" +
				", maFourmiliere=" + maFourmiliere + ", monFood=" + monFood + "]";
	}
	
	public void incrementCharge(){
		this.setCharge_porter(this.getCharge_porter()+1);
	}
	
	public void decrementCharge(){
		this.setCharge_porter(this.getCharge_porter()-1);
	}
	
	//on fait avancer la fourmit d'un pas oui mais tout les controle doivent se faire dans le controler
	// Fait avancer la fourmie d'un pas
	public void avance() {//int X, int Y) {
		this.setX(X);
		this.setY(Y);
	}
	
	public ArrayList calculPositionDirectPossible(){
		/*Quand nous avons deux point x et y en position inconnu tel que i soit xi et yi
		 * 		
		 * 		xi+1, yi
		 * 		xi, yi+1
		 * 		xi-1, yi
		 * 		xi, yi-1
		 * 		xi+1, yi+1
		 * 		xi-1, yi-1
		 * 		xi-1, yi+1
		 * 		xi+1, yi-1
		 * 
		*
		ArrayList listDeplacement = new ArrayList();
		int value = 1;
		
		switch (value){
			case 1:
				Hashtable ht1 = new Hashtable();
				ht1.put("x", this.getX()+1);
				ht1.put("y", this.getY());
				listDeplacement.add(ht1);
				;
				
			case 2:
				Hashtable ht2 = new Hashtable();
				ht2.put("x", this.getX());
				ht2.put("y", this.getY()+1);
				listDeplacement.add(ht2);
				;
				
			case 3:
				Hashtable ht3 = new Hashtable();
				ht3.put("x", this.getX()-1);
				ht3.put("y", this.getY());
				listDeplacement.add(ht3);
				;
				
			case 4:
				Hashtable ht4 = new Hashtable();
				ht4.put("x", this.getX());
				ht4.put("y", this.getY()-1);
				listDeplacement.add(ht4);
				;
				
			case 5:
				Hashtable ht5 = new Hashtable();
				ht5.put("x", this.getX()+1);
				ht5.put("y", this.getY()+1);
				listDeplacement.add(ht5);
				;
				
			case 6:
				Hashtable ht6 = new Hashtable();
				ht6.put("x", this.getX()-1);
				ht6.put("y", this.getY()-1);
				listDeplacement.add(ht6);
				;
				
			case 7:
				Hashtable ht7 = new Hashtable();
				ht7.put("x", this.getX()-1);
				ht7.put("y", this.getY()+1);
				listDeplacement.add(ht7);
				;
				
			case 8:
				Hashtable ht8 = new Hashtable();
				ht8.put("x", this.getX()+1);
				ht8.put("y", this.getY()-1);
				listDeplacement.add(ht8);
				;
		}
		
		return listDeplacement;
		
	}
	
	//accesseur
	public int getCharge_max() {
		return charge_max;
	}
	public void setCharge_max(int charge_max) {
		this.charge_max = charge_max;
	}
	public int getCharge_porter() {
		return charge_porter;
	}
	public void setCharge_porter(int charge_porter) {
		this.charge_porter = charge_porter;
	}
	
	public boolean getPlein() {
		return plein;
	}
	public void setPlein(boolean plein) {
		this.plein = plein;
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
	public fourmiliere getMaFourmiliere() {
		return maFourmiliere;
	}
	public void setMaFourmiliere(fourmiliere theFourmiliere) {
		this.maFourmiliere = theFourmiliere;
	}
	public food getMonFood() {
		return monFood;
	}
	public void setMonFood(food theFood) {
		this.monFood = theFood;
	}
	*/
}

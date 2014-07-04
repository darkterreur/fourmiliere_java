package modele;

import java.util.Random;

public class Deplacement {
	public static int EAST = 0;
	public static int SOUTH = 1;
	public static int WEST = 2;
	public static int NORTH = 3;
	public static int NORTH_EAST = 4;
	public static int SOUTH_EAST = 5;
	public static int SOUTH_WEST = 6;
	public static int NORTH_WEST = 7;
	
	private int abscisse = 0;
	private int ordonnee = 0;
	private int direction = 0;
	private int nombrePixelDeplacement = 0;
	
	/**
	 * Deux manières :
	 * 	1. Déplacement aléatoire
	 * 	2. Déplacement dans une direction donnée
	 * @param abscisse
	 * @param ordonnee
	 * @param nombrePixelDeplacement
	 */
	public Deplacement (int abscisse, int ordonnee, int nombrePixelDeplacement) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.nombrePixelDeplacement = nombrePixelDeplacement;
	}
	public Deplacement (int abscisse, int ordonnee, int nombrePixelDeplacement, int direction) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.direction = direction;
		this.nombrePixelDeplacement = nombrePixelDeplacement;
	}
	
	/**
	 * Calcule un déplacement aléatoire
	 * @return
	 */
	public void calculDeplacementAleatoire() {
		Random rand = new Random();

		int random = rand.nextInt(8);
		
		if (random == Deplacement.EAST) {
			this.abscisse+=nombrePixelDeplacement;
		} else if (random == Deplacement.SOUTH) {
			this.ordonnee+=nombrePixelDeplacement;
		} else if (random == Deplacement.WEST) {
			this.abscisse-=nombrePixelDeplacement;
		} else if (random == Deplacement.NORTH) {
			this.ordonnee-=nombrePixelDeplacement;
		} else if (random == Deplacement.NORTH_EAST) {
			this.abscisse+=nombrePixelDeplacement;
			this.ordonnee-=nombrePixelDeplacement;
		} else if (random == Deplacement.SOUTH_EAST) {
			this.abscisse+=nombrePixelDeplacement;
			this.ordonnee+=nombrePixelDeplacement;
		} else if (random == Deplacement.SOUTH_WEST) {
			this.abscisse-=nombrePixelDeplacement;
			this.ordonnee+=nombrePixelDeplacement;
		} else if (random == Deplacement.NORTH_WEST) {
			this.abscisse-=nombrePixelDeplacement;
			this.ordonnee-=nombrePixelDeplacement;
		}
		
		this.direction = random;
	}
	
	/**
	 * Déplacement dans la même direction
	 * @return
	 */
	public void calculDeplacementMemeDirection() {
		if (this.direction == Deplacement.EAST) {
			this.abscisse+=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.SOUTH) {
			this.ordonnee+=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.WEST) {
			this.abscisse-=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.NORTH) {
			this.ordonnee-=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.NORTH_EAST) {
			this.abscisse+=nombrePixelDeplacement;
			this.ordonnee-=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.SOUTH_EAST) {
			this.abscisse+=nombrePixelDeplacement;
			this.ordonnee+=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.SOUTH_WEST) {
			this.abscisse-=nombrePixelDeplacement;
			this.ordonnee+=nombrePixelDeplacement;
		} else if (this.direction == Deplacement.NORTH_WEST) {
			this.abscisse-=nombrePixelDeplacement;
			this.ordonnee-=nombrePixelDeplacement;
		}
	}
	
	/**
	 * Vérifie la conformité de la nouvelle direction par rapport au champs de vision de l'ancienne direction
	 * @param ancienneDirection
	 * @param nouvelleDirection
	 * @return
	 */
	public boolean dansChampsDeVision (int ancienneDirection) {
		if (this.direction == Deplacement.EAST && (ancienneDirection == Deplacement.NORTH || ancienneDirection == Deplacement.EAST || ancienneDirection == Deplacement.SOUTH
		|| ancienneDirection == Deplacement.NORTH_EAST || ancienneDirection == Deplacement.NORTH_WEST || ancienneDirection == Deplacement.SOUTH_EAST)) {
			return true;
		} else if (this.direction == Deplacement.SOUTH && (ancienneDirection == Deplacement.SOUTH || ancienneDirection == Deplacement.EAST || ancienneDirection == Deplacement.WEST
				|| ancienneDirection == Deplacement.SOUTH_WEST || ancienneDirection == Deplacement.SOUTH_EAST)) {
			return true;
		} else if (this.direction == Deplacement.WEST && (ancienneDirection == Deplacement.NORTH || ancienneDirection == Deplacement.SOUTH || ancienneDirection == Deplacement.WEST
				|| ancienneDirection == Deplacement.SOUTH_WEST)) {
			return true;
		} else if (this.direction == Deplacement.NORTH && (ancienneDirection == Deplacement.NORTH || ancienneDirection == Deplacement.EAST || ancienneDirection == Deplacement.WEST
				|| ancienneDirection == Deplacement.NORTH_EAST || ancienneDirection == Deplacement.NORTH_WEST)) {
			return true;
		} else if (this.direction == Deplacement.NORTH_EAST && (ancienneDirection == Deplacement.NORTH || ancienneDirection == Deplacement.EAST
				|| ancienneDirection == Deplacement.NORTH_EAST || ancienneDirection == Deplacement.NORTH_WEST || ancienneDirection == Deplacement.SOUTH_EAST)) {
			return true;
		} else if (this.direction == Deplacement.SOUTH_EAST && (ancienneDirection == Deplacement.EAST || ancienneDirection == Deplacement.SOUTH || ancienneDirection == Deplacement.NORTH_EAST
				|| ancienneDirection == Deplacement.SOUTH_WEST || ancienneDirection == Deplacement.SOUTH_EAST)) {
			return true;
		} else if (this.direction == Deplacement.SOUTH_WEST && (ancienneDirection == Deplacement.SOUTH || ancienneDirection == Deplacement.WEST || ancienneDirection == Deplacement.NORTH_WEST
				|| ancienneDirection == Deplacement.SOUTH_WEST || ancienneDirection == Deplacement.SOUTH_EAST)) {
			return true;
		} else if (this.direction == Deplacement.NORTH_WEST && (ancienneDirection == Deplacement.NORTH || ancienneDirection == Deplacement.WEST
				|| ancienneDirection == Deplacement.NORTH_EAST || ancienneDirection == Deplacement.NORTH_WEST || ancienneDirection == Deplacement.SOUTH_WEST)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Vérifie que le point est dans le cadre
	 * @param ancienneDirection
	 * @param nouvelleDirection
	 * @return
	 */
	public boolean dansCadre (int largeurCadre, int hauteurCadre) {
		if (this.abscisse < largeurCadre && this.ordonnee < hauteurCadre && this.abscisse > 0 && this.ordonnee > 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Calcule l'orientation du déplacement selon le point de départ et le point d'arrivée
	 */
	public int calculeOrientation(int abscisseOrigine,int ordonneeOrigine,int abscisseDestination,int ordonneeDestination) {
		if (ordonneeOrigine == ordonneeDestination && abscisseOrigine < abscisseDestination) {
			return Deplacement.EAST;
		} else if (ordonneeOrigine == ordonneeDestination && abscisseOrigine > abscisseDestination) {
			return Deplacement.WEST;
		} else if (abscisseOrigine == abscisseDestination && ordonneeOrigine > ordonneeDestination) {
			return Deplacement.NORTH;
		} else if (abscisseOrigine == abscisseDestination && ordonneeOrigine < ordonneeDestination) {
			return Deplacement.SOUTH;
		} else if (abscisseOrigine > abscisseDestination && ordonneeOrigine > ordonneeDestination) {
			return Deplacement.NORTH_WEST;
		} else if (abscisseOrigine < abscisseDestination && ordonneeOrigine > ordonneeDestination) {
			return Deplacement.NORTH_EAST;
		} else if (abscisseOrigine > abscisseDestination && ordonneeOrigine < ordonneeDestination) {
			return Deplacement.SOUTH_WEST;
		} else if (abscisseOrigine < abscisseDestination && ordonneeOrigine < ordonneeDestination) {
			return Deplacement.SOUTH_EAST;
		} else {
			return -1;
		}
	}
	
	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}

package modele;

import java.awt.Point;

/**
 * Effectue le contournement d'un obstacle depuis un point donné
 *
 */
public class Contournement {
	public static int contournementGauche = 0;
	public static int contournementDroit = 1;
	
	private Point position;												// Position par rapport à l'obstacle
	private boolean gaucheIsTested = false;
	private boolean droiteIsTested = false;
	private int nombreDeplacementContournementGauche = 0;				// Longueur duchemin en contournant par la gauche
	private int nombreDeplacementContournementDroit = 0;				// Longueur duchemin en contournant par la droite
	private boolean[] troisDerniersPointsIsObstacle = new boolean[3];	// Trois derniers points de déplacement
	
	public Contournement(Point p) {
		this.position = new Point(p);
	}
	
	/**
	 * Renvoie le contournement le plus court
	 * @return
	 */
	public int getContournementPlusCourt() {
		if (this.nombreDeplacementContournementGauche > this.nombreDeplacementContournementDroit) {
			return Contournement.contournementDroit;
		} else {
			return Contournement.contournementGauche;
		}
	}
	
	/**
	 * Fusionne deux valeurs
	 */
	public void fusionne(Contournement c) {
		if (c.nombreDeplacementContournementDroit > 0 && this.nombreDeplacementContournementDroit <= 0) {
			this.nombreDeplacementContournementDroit = c.nombreDeplacementContournementDroit;
		}
		
		if (c.nombreDeplacementContournementGauche > 0 && this.nombreDeplacementContournementGauche <= 0) {
			this.nombreDeplacementContournementGauche = c.nombreDeplacementContournementGauche;
		}
	}
	
	/**
	 * Défini le nombre de déplacement pour un côté donné
	 * @param cote
	 * @param nombre
	 */
	public void addNombreDeplacement(int cote, int nombre) {
		if (cote == Contournement.contournementGauche && !this.gaucheIsTested) {
			this.nombreDeplacementContournementGauche = nombre;
		} else if (cote == Contournement.contournementDroit && !this.droiteIsTested) {
			this.nombreDeplacementContournementDroit = nombre;
		}
	}
	
	/**
	 * Arrête le contournement si les tris derniers déplacements sont hors obstacles
	 * @return
	 */
	public boolean stopContournement() {
		for (int i=0; i<this.troisDerniersPointsIsObstacle.length; i++) {
			if (this.troisDerniersPointsIsObstacle[i] == true) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Vérifie quel côté a été testé
	 */
	public void setIsTested() {
		if (this.nombreDeplacementContournementGauche > 0) {
			this.droiteIsTested = true;
		}
		
		if (this.nombreDeplacementContournementGauche > 0) {
			this.gaucheIsTested = true;
		}
	}
	
	/**
	 * Vrai si les deux longueurs ont été testées
	 * @return
	 */
	public boolean isTested() {
		if (this.gaucheIsTested && this.droiteIsTested) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Met à jour le suivit des trois dernières position
	 * @param hereIsObstacle
	 */
	public void hereIsObstacle(boolean hereIsObstacle) {
		if (this.troisDerniersPointsIsObstacle.length == 0) {
			this.troisDerniersPointsIsObstacle[0] = hereIsObstacle;
		} else if (this.troisDerniersPointsIsObstacle.length >= 3) {
			boolean temp1 = this.troisDerniersPointsIsObstacle[1];
			boolean temp2 = this.troisDerniersPointsIsObstacle[2];
			
			this.troisDerniersPointsIsObstacle[0] = temp1;
			this.troisDerniersPointsIsObstacle[1] = temp2;
			this.troisDerniersPointsIsObstacle[2] = hereIsObstacle;
		} else {
			this.troisDerniersPointsIsObstacle[this.troisDerniersPointsIsObstacle.length] = hereIsObstacle;
		}
	}
	
	@Override
	public int hashCode() {	// Sert pour la vérification dans la méthode containsKey()
		int x = (int) this.position.getX();
		int y = (int) this.position.getY();
		
		return x+y;
	}
	
	@Override
	public boolean equals(Object o) {	// Sert pour la vérification dans la méthode containsKey()
		Contournement other = (Contournement) o;
		return (this.position.getX() == other.getPosition().getX() && this.position.getY() == other.getPosition().getY()) ? true : false;
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getNombreDeplacementContournementGauche() {
		return nombreDeplacementContournementGauche;
	}

	public void setNombreDeplacementContournementGauche(
			int nombreDeplacementContournementGauche) {
		this.nombreDeplacementContournementGauche = nombreDeplacementContournementGauche;
	}

	public int getNombreDeplacementContournementDroit() {
		return nombreDeplacementContournementDroit;
	}

	public void setNombreDeplacementContournementDroit(
			int nombreDeplacementContournementDroit) {
		this.nombreDeplacementContournementDroit = nombreDeplacementContournementDroit;
	}
	
	public boolean[] getTroisDerniersPointsIsObstacle() {
		return troisDerniersPointsIsObstacle;
	}

	public void setTroisDerniersPointsIsObstacle(
			boolean[] troisDerniersPointsIsObstacle) {
		this.troisDerniersPointsIsObstacle = troisDerniersPointsIsObstacle;
	}
}

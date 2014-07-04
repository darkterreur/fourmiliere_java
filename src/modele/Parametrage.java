package modele;

/**
 * Regroupe les paramétages possibles de la simulation
 * Charge maximum :
 * 	- taille : 500
 * 	- nombre de fourmis : 1500
 * 	- quantité d'obstacles : 100
 * 	- quantité de nourriture : 25
 */
public class Parametrage {
	public static int TAILLE_DEFAUT = 500;
	public static int NOMBRE_FOURMIS = 100;
	public static int QTE_OBSTACLES = 50;
	public static int QTE_NOURRITURE = 3;
	public static int VITESSE_EVAPO_PHERO = 100;
	public static String EMPLACEMENT_SAUVEGARDE = "params_user.txt";
	
	private int taille, nombreFourmis, qteObstacles, qteFood, vitesseEvapoPhero;
	private boolean isScenario, isScenario2, isScenario3;

	/**
	 * Affecte l'ensemble des paramètres nécessaires
	 * @param taille
	 * @param nbreFourmis
	 * @param qteObstacles
	 * @param qteFood
	 * @param vitesseEvapoPhero
	 * @param obstacleEntreFourmiliereEtNourriture
	 */
	public Parametrage(int taille, int nbreFourmis, int qteObstacles, int qteFood, int vitesseEvapoPhero, boolean isScenario,
			boolean isScenario2, boolean isScenario3){
		this.taille = taille;
		this.nombreFourmis = nbreFourmis;
		this.qteObstacles = qteObstacles;
		this.qteFood = qteFood;
		this.vitesseEvapoPhero = vitesseEvapoPhero;
		this.isScenario = isScenario;
		this.isScenario2 = isScenario2;
		this.isScenario3 = isScenario3;
	}
	
	public int getTaille() {
		return this.taille;
	}
	public int getNombreFourmis() {
		  return this.nombreFourmis;
	}
	public int getQteObstacles() {
		return qteObstacles;
	}
	public void setQteObstacles(int qteObstacles) {
		this.qteObstacles = qteObstacles;
	}
	public int getQteFood() {
		return qteFood;
	}
	public void setQteFood(int qteFood) {
		this.qteFood = qteFood;
	}
	
	public int getVitesseEvapoPhero() {
		return vitesseEvapoPhero;
	}
	public void setVitesseEvapoPhero(int vitesseEvapoPhero) {
		this.vitesseEvapoPhero = vitesseEvapoPhero;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public void setNombreFourmis(int nombreFourmis) {
		this.nombreFourmis = nombreFourmis;
	}

	public boolean isScenario() {
		return isScenario;
	}

	public void setScenario(boolean isScenario) {
		this.isScenario = isScenario;
	}

	public boolean isScenario2() {
		return isScenario2;
	}

	public void setScenario2(boolean isScenario2) {
		this.isScenario2 = isScenario2;
	}

	public boolean isScenario3() {
		return isScenario3;
	}

	public void setScenario3(boolean isScenario3) {
		this.isScenario3 = isScenario3;
	}
}
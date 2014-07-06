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
	public static String TAILLE_PETITE_TEXTE = "Petite";
	public static int TAILLE_PETITE = 250;
	public static String TAILLE_MOYENNE_TEXTE = "Moyenne";
	public static int TAILLE_MOYENNE = 500;
	public static String TAILLE_GRANDE_TEXTE = "Grande";
	public static int TAILLE_GRANDE = 800;
	
	public static int NOMBRE_FOURMIS = 100;
	public static int QTE_OBSTACLES = 50;
	public static int QTE_NOURRITURE = 3;
	public static int VITESSE_EVAPO_PHERO = 100;
	
	public static int VITESSE_JEU_LENTE = 150;
	public static String VITESSE_JEU_LENTE_TEXTE = "Lente";
	public static int VITESSE_JEU_MOYENNE = 75;
	public static String VITESSE_JEU_MOYENNE_TEXTE = "Moyenne";
	public static int VITESSE_JEU_RAPIDE = 25;
	public static String VITESSE_JEU_RAPIDE_TEXTE = "Rapide";
	
	public static String EMPLACEMENT_SAUVEGARDE = "params_user.txt";
	
	private int taille, nombreFourmis, qteObstacles, qteFood, vitesseEvapoPhero, vitesseJeu;
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
	public Parametrage(String taille, int nbreFourmis, int qteObstacles, int qteFood, int vitesseEvapoPhero, String vitesseJeuText, boolean isScenario){
		if (taille == Parametrage.TAILLE_PETITE_TEXTE) {
			this.taille = Parametrage.TAILLE_PETITE;
		} else if (taille == Parametrage.TAILLE_MOYENNE_TEXTE) {
			this.taille = Parametrage.TAILLE_MOYENNE;
		} else if (taille == Parametrage.TAILLE_GRANDE_TEXTE) {
			this.taille = Parametrage.TAILLE_GRANDE;
		}
		
		this.nombreFourmis = nbreFourmis;
		this.qteObstacles = qteObstacles;
		this.qteFood = qteFood;
		this.vitesseEvapoPhero = vitesseEvapoPhero;
		this.isScenario = isScenario;
		
		if (vitesseJeuText == Parametrage.VITESSE_JEU_LENTE_TEXTE)  {
			this.vitesseJeu = Parametrage.VITESSE_JEU_LENTE;
		} else if (vitesseJeuText == Parametrage.VITESSE_JEU_MOYENNE_TEXTE) {
			this.vitesseJeu = Parametrage.VITESSE_JEU_MOYENNE;
		} else if (vitesseJeuText == Parametrage.VITESSE_JEU_RAPIDE_TEXTE) {
			this.vitesseJeu = Parametrage.VITESSE_JEU_RAPIDE;
		}
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

	public int getVitesseJeu() {
		return vitesseJeu;
	}

	public void setVitesseJeu(int vitesseJeu) {
		this.vitesseJeu = vitesseJeu;
	}
}
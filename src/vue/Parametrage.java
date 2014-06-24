package vue;
public class Parametrage {
	public static int TAILLE_DEFAUT = 500;
	public static int NOMBRE_FOURMIS = 25;
	public static int QTE_OBSTACLES = 13;
	public static int QTE_NOURRITURE = 3;
	public static int VITESSE_EVAPO_PHERO = 25;
	public static boolean OBSTACLES_ENTRE_FOURMILIERE_ET_NOURRITURE = false;
	
	private int taille, nombreFourmis, qteObstacles, qteFood, vitesseEvapoPhero;
	private boolean obstacleEntreFourmiliereEtNourriture;

	public Parametrage(){}
	public Parametrage(int taille, int nbreFourmis, int qteObstacles, int qteFood, int vitesseEvapoPhero, boolean obstacleEntreFourmiliereEtNourriture){
		this.taille = taille;
		this.nombreFourmis = nbreFourmis;
		this.qteObstacles = qteObstacles;
		this.qteFood = qteFood;
		this.vitesseEvapoPhero = vitesseEvapoPhero;
		this.obstacleEntreFourmiliereEtNourriture = obstacleEntreFourmiliereEtNourriture;
	}
	
	public boolean isObstacleEntreFourmiliereEtNourriture() {
		return obstacleEntreFourmiliereEtNourriture;
	}
	
	public void setObstacleEntreFourmiliereEtNourriture(boolean obstacleEntreFourmiliereEtNourriture) {
		this.obstacleEntreFourmiliereEtNourriture = obstacleEntreFourmiliereEtNourriture;
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
  
}
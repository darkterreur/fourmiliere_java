package modele;

import java.util.ArrayList;
import java.util.Random;


public class monde{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//attribut
	private int qte_obj_obst;
	private int qte_fourm;
	private int qte_obj_food;
	private int vitesseEvaporationPhero;
	private boolean obstacleEntreFourmiliereEtNourriture;
	private simulation sim;
	private ArrayList<obstacle> obstacles = new ArrayList<obstacle>();
	private ArrayList<food> foods = new ArrayList<food>();
	private ArrayList<fourmiliere> fourmilieres = new ArrayList<fourmiliere>();
	private ArrayList<pheromone> pheromones = new ArrayList<pheromone>();
	
	//methode
	public monde(Parametrage params, simulation simul) {
		this.qte_obj_obst = params.getQteObstacles();
		this.qte_fourm = params.getNombreFourmis();
		this.qte_obj_food = params.getQteFood();
		this.vitesseEvaporationPhero = params.getVitesseEvapoPhero();
		this.obstacleEntreFourmiliereEtNourriture = obstacleEntreFourmiliereEtNourriture;
		this.sim = simul;
		Random rand = new Random();
		int k=0,x=0,y=0;
		
		/*
		this.addCailloux(100, 10);
		this.addCailloux(200, 100);
		this.addCailloux(200, 110);
		this.addCailloux(200, 120);
		this.addCailloux(200, 130);
		
		this.addCailloux(210, 90);
		this.addCailloux(210, 100);
		this.addCailloux(210, 110);
		this.addCailloux(210, 120);
		
		this.addCailloux(190, 120);
		this.addCailloux(230, 120);
		
		this.addCailloux(210, 130);
		this.addCailloux(210, 140);
		this.addCailloux(210, 150);
		
		this.addCailloux(210, 150);
		this.addCailloux(200, 150);
		this.addCailloux(220, 150);
		
		this.addCailloux(210, 160);
		this.addCailloux(210, 170);
		
		this.addCailloux(220, 100);
		this.addCailloux(220, 110);
		this.addCailloux(220, 120);
		this.addCailloux(220, 130);
		*/
		
		for (k=0; k<this.qte_obj_food; k++) {
			x = rand.nextInt(this.sim.largeur);
			y = rand.nextInt(this.sim.hauteur);
			this.addFeuille(x, y);
		}
		
		for (k=0; k<this.qte_obj_obst; k++) {
			x = rand.nextInt(this.sim.largeur);
			y = rand.nextInt(this.sim.hauteur);
			this.addCailloux(x, y);
		}
		
		/*
		this.addFlac(450, 300);
		*/
		
		// Fourmilière
		fourmiliere f = new fourmiliere(200, 220, this);
		
		for (k=0; k<this.qte_fourm; k++) {
			f.addFourmi();
		}
		
		this.addFourmilere(f);
	}
	
	public simulation getSimulation() {
		return this.sim;
	}
	
	@Override
	public String toString() {
		return "monde [qte_obj_obst=" + qte_obj_obst + ", qte_fourm="
				+ qte_fourm + ", qte_obj_food=" + qte_obj_food + ", largeur=";
	}
	
	public void nextStep() {
		// Parcours toutes les fourmilières et avance d'une étape chacunes d'elles
		ArrayList<fourmiliere> fourmilieres = this.fourmilieres;
		
		for (int i=0; i<fourmilieres.size(); i++) {
	    	fourmiliere f = fourmilieres.get(i);
	    	f.nextStep();
	    }
		
		// Parcours toutes les phéromones
		ArrayList<pheromone> pheromones = this.pheromones;
		
		for (int i=0; i<pheromones.size(); i++) {
			pheromones.get(i).decrementePheromone();
			
			if (pheromones.get(i).isEmpty()) {
				pheromones.remove(i);
			}
	    }
	}
	
	//accesseur
	public ArrayList<obstacle> getObstacles() {
		return this.obstacles;
	}
	
	public ArrayList<food> getFoods() {
		return this.foods;
	}
	
	public int getVitesseEvaporationPhero() {
		return this.vitesseEvaporationPhero;
	}
	
	public ArrayList<fourmiliere> getFourmilieres() {
		return this.fourmilieres;
	}
	
	public ArrayList<pheromone> getPheromones() {
		return this.pheromones;
	}
	
	public void setObstacles(ArrayList<obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public void addCailloux(int x, int y) {
		this.obstacles.add(new cailloux(obstacle.cailloux, x, y));
	}
	
	public void addFlac(int x, int y) {
		this.obstacles.add(new flac(obstacle.flac, x, y));
	}
	
	public void addBranche(int x, int y) {
		this.obstacles.add(new branche(obstacle.branche, x, y));
	}
	
	public void addFeuille(int x, int y) {
		this.foods.add(new feuille(food.feuille, x, y));
	}
	
	public void addFourmilere(fourmiliere f) {
		this.fourmilieres.add(f);
	}
	
	public int getQte_obj_obst() {
		return qte_obj_obst;
	}
	public void setQte_obj_obst(int qte_obj_obst) {
		this.qte_obj_obst = qte_obj_obst;
	}
	public int getQte_fourm() {
		return qte_fourm;
	}
	public void setQte_fourm(int qte_fourm) {
		this.qte_fourm = qte_fourm;
	}
	public int getQte_obj_food() {
		return qte_obj_food;
	}
	public void setQte_obj_food(int qte_obj_food) {
		this.qte_obj_food = qte_obj_food;
	}
	/*
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}*/
	
	
	
}

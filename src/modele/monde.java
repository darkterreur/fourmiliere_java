package modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Le monde où se déroule la simulation
 *
 */
public class monde{
	private static final long serialVersionUID = 1L;
	public static int vitesseEvaporationPhero = 0;
	
	private int qte_obj_obst;
	private int qte_fourm;
	private int qte_obj_food;
	private simulation sim;
	private HashSet<obstacle> obstacles = new HashSet<obstacle>();
	private ArrayList<food> foods = new ArrayList<food>();
	private ArrayList<fourmiliere> fourmilieres = new ArrayList<fourmiliere>();
	private HashSet<pheromone> pheromones = new HashSet<pheromone>();
	
	/**
	 * Placement des objets et initialisation du monde
	 * @param params
	 * @param simul
	 */
	public monde(Parametrage params, simulation simul) {
		this.qte_obj_obst = params.getQteObstacles();
		this.qte_fourm = params.getNombreFourmis();
		this.qte_obj_food = params.getQteFood();
		monde.vitesseEvaporationPhero = params.getVitesseEvapoPhero();
		this.sim = simul;
		
		Random rand = new Random();
		int k=0,x=0,y=0;
		
		this.getSimulation().getInfosModele().setQteNourritureEnvironement(food.valeurBaseFood * this.getQte_obj_food());
		this.getSimulation().getInfosModele().setQteTotalPheroDansEnv(this.pheromones.size());
		fourmiliere f = null;
		
		// Si un des scénarios à été lancé, construction de celui-ci
		if (params.isScenario()) {
/*************** SCENARIO 1 *********************/
			f = new fourmiliere(250, 0, this);
			
			// Gauche
			for (int i=0;i<150; i+=10) {
				this.addCailloux(230, i);
			}
			// Gauche 2
			for (int i=150;i<390; i+=10) {
				this.addCailloux(220, i);
			}
			// Milieux
			for (int i=150;i<250; i+=10) {
				this.addCailloux(260, i);
			}
			
			// Droite
			for (int i=0;i<30; i+=10) {
				this.addCailloux(290, i);
			}
			for (int i=60;i<200; i+=10) {
				this.addCailloux(290, i);
			}
			
			// Debordement droit haut
			for (int i=290;i<340; i+=10) {
				this.addCailloux(i, 200);
			}
			// Debordement droit bas
			for (int i=260;i<320; i+=10) {
				this.addCailloux(i, 220);
			}
			
			// Debordement coté fourmilière
			for (int i=300;i<350; i+=10) {
				this.addCailloux(i, 20);
			}
			
			// Redescend gauche
			for (int i=220;i<250; i+=10) {
				this.addCailloux(320, i);
			}
			// Redescend droite
			for (int i=20;i<290; i+=10) {
				this.addCailloux(350, i);
			}
			// Débordement droit retour haut
			for (int i=240;i<330; i+=10) {
				this.addCailloux(i, 250);
			}
			// Débordement droit retour bas
			for (int i=250;i<350; i+=10) {
				this.addCailloux(i, 290);
			}
			this.addFeuille(230, 280);
		}/*************** FIN (SCENARIO 1) *****************/
		else if (params.isScenario2()) {
/*************** SCENARIO 2 *********************/
			f = new fourmiliere(200, 220, this);
			
			this.addFeuille(300, 120);
			
			for (int i=150;i<300; i+=10) {
				this.addCailloux(250, i);
			}
		} /*************** FIN (SCENARIO 2) *****************/
		else if (params.isScenario3()) {
/*************** SCENARIO 3 *********************/
			f = new fourmiliere(200, 220, this);
			
			// Haut
			for (int i=100;i<320; i+=10) {
				this.addCailloux(i, 180);
			}
			
			// Gauche
			for (int i=180;i<220; i+=10) {
				this.addCailloux(100, i);
			}
			for (int i=250;i<310; i+=10) {
				this.addCailloux(100, i);
			}
			
			// Droite
			for (int i=180;i<230; i+=10) {
				this.addCailloux(310, i);
			}
			for (int i=260;i<310; i+=10) {
				this.addCailloux(310, i);
			}
			
			// Bas
			for (int i=100;i<320; i+=10) {
				this.addCailloux(i, 300);
			}
			
			this.addFeuille(340, 150);
			this.addFeuille(340, 300);
/*************** FIN (SCENARIO 3) *****************/
		} else {
			// Fourmilière
			f = new fourmiliere(200, 220, this);
			
			for (k=0; k<this.qte_obj_obst; k++) {
				x = rand.nextInt(this.sim.largeur);
				y = rand.nextInt(this.sim.hauteur);
				
				while ((x >= f.getX() && x <= (f.getX()+f.getWidth())) && (y >= f.getY() && y <= (f.getY()+f.getHeight()))
					|| (x+10 >= f.getX() && x+10 <= (f.getX()+f.getWidth())) || (y+10 >= f.getY() && y+10 <= (f.getY()+f.getHeight()))
				) {
					x = rand.nextInt(this.sim.largeur);
					y = rand.nextInt(this.sim.hauteur);
				}
				
				this.addCailloux(x, y);
			}
			
			for (k=0; k<this.qte_obj_food; k++) {
				x = rand.nextInt(this.sim.largeur);
				y = rand.nextInt(this.sim.hauteur);
				
				while (((x >= f.getX() && x <= (f.getX()+f.getWidth())) && (y >= f.getY() && y <= (f.getY()+f.getHeight()))
					|| (x+20 >= f.getX() && x+20 <= (f.getX()+f.getWidth())) || (y+80 >= f.getY() && y+80 <= (f.getY()+f.getHeight())))
				) {
					x = rand.nextInt(this.sim.largeur);
					y = rand.nextInt(this.sim.hauteur);
				}
				
				this.addFeuille(x, y);
			}
		}
		
		for (k=0; k<this.qte_fourm; k++) {
			f.addFourmi();
		}
		
		this.addFourmilere(f);
	}
	
	/**
	 * Parcours toutes les fourmilières et les phéromones avance d'une étape chacunes d'elles et met à jours les informations de la simulation
	 */
	public void nextStep() {
		// Fourmilières
		ArrayList<fourmiliere> fourmilieres = this.fourmilieres;
		
		for (int i=0; i<fourmilieres.size(); i++) {
	    	fourmiliere f = fourmilieres.get(i);
	    	f.nextStep();
	    }
		
		// Phéromones
		java.util.Iterator<pheromone> pheroIterator = this.pheromones.iterator();
		pheromone pheroCourante = null;
		
		while (pheroIterator.hasNext()) {
			try {
				pheroCourante = pheroIterator.next();
				pheroCourante.decrementePheromone();
			
				if (pheroCourante.isEmpty()) {
					pheroIterator.remove();
				} else {
					this.pheromones.add(pheroCourante);
				}
			} catch (Exception e) {
				break;
			}
		}
		
		this.getSimulation().getInfosModele().setQteTotalPheroDansEnv(this.pheromones.size());
	}
	
	/**
	 * Construit un cailloux dans le monde
	 * @param x
	 * @param y
	 */
	public void addCailloux(int x, int y) {
		for(int ordonnee=y; ordonnee<y+10; ordonnee++) {
			for (int abscisse=x; abscisse<x+10; abscisse++) {
				obstacle cailloux = new obstacle(abscisse, ordonnee);
				this.obstacles.add(cailloux);
			}
		}
	}
	
	public simulation getSimulation() {
		return this.sim;
	}
	
	public HashSet<obstacle> getObstacles() {
		return this.obstacles;
	}
	
	public ArrayList<food> getFoods() {
		return this.foods;
	}
	
	public int getVitesseEvaporationPhero() {
		return monde.vitesseEvaporationPhero;
	}
	
	public ArrayList<fourmiliere> getFourmilieres() {
		return this.fourmilieres;
	}
	
	public HashSet<pheromone> getPheromones() {
		return this.pheromones;
	}
	
	public void setObstacles(HashSet<obstacle> obstacles) {
		this.obstacles = obstacles;
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
}

package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Le comportement d'une fourmi
 */
public class fourmi {
	public static int nombrePixelDeplacement = 1;
	
	private int x;
	private int y;
	private int width = 7;
	private int height = 7;
	private int chargePortee = 0;
	private int ancienneDirection = 0;					// Sert pour le déplacement aléatoire afin d'aviter l'effet vibration
	private int indexNourritureMangee;					// Sert à mettre à jour la nourriture mangée dans le monde
	private fourmiliere fourmiliereMere;				// Sert à connaître les coordonnées pour le retour à la fourmilière
	private pheromone lastPheromone = null;				// Dernier phéromone trouvé
	private int ancienneDirectionPheromone = -1;		// Sert à éviter l'effet vibratoire lors du suivit des phéromones
	private boolean isRetourFourmiliere = false;		// Etat : la fourmi retourne instinctivement à la fourmilière
	private Deplacement deplacementCourant = null;		// Le déplacement effectué
	private boolean contournementGauche = false;		// La fourmi contourne les obstacles dans le sens des aiguilles d'une montre
	private boolean contournementDroit = false;			// La fourmi contourne les obstacles dans le sens inverse des aiguilles d'une montre
	private Contournement contournementCourant = null;	// Le contournement effectué
	
	/**
	 * Constructeur
	 * @param f
	 */
	public fourmi(fourmiliere f) {
		this.x = f.getxCentre();
		this.y = f.getyCentre();
		this.fourmiliereMere = f;
		this.deplacementCourant = new Deplacement(this.x, this.y, fourmi.nombrePixelDeplacement);	// Point de départ
		
		// Choisit aléatoirement que cette fourmi contournera par la gauche ou par la droite
		Random rand = new Random();
		int random = rand.nextInt(2);
		
		if (random == 0)  {
			this.contournementGauche = true;
		} else if (random == 1) {
			this.contournementDroit = true;
		}
	}
	
	
	/**
	 * Fait avancer la fourmi d'un pas
	 */
	public void avance() {
		int positionInitialeX = this.x;
		int positionInitialeY = this.y;
		boolean hereIsObstacle = false;

		// Si la fourmi retourne à la fourmilière
		if (this.isRetourFourmiliere) {
			boolean decrementeAbscisse = false;
			boolean incrementeAbscisse = false;
			boolean decrementeOrdonnee = false;
			boolean incrementeOrdonnee = false;
			boolean contournementGauche = this.contournementGauche;
			boolean contournementDroit = this.contournementDroit;
			
			// Avancer vers la fourmilière en ligne droite
			this.deposePheromone();
			
			if (this.x > this.fourmiliereMere.getxCentre()) {
				this.x-=fourmi.nombrePixelDeplacement;
				decrementeAbscisse = true;
			} else if (this.x < this.fourmiliereMere.getxCentre()) {
				this.x+=fourmi.nombrePixelDeplacement;
				incrementeAbscisse = true;
			}
			
			if (this.y > this.fourmiliereMere.getyCentre()) {
				this.y-=fourmi.nombrePixelDeplacement;
				decrementeOrdonnee = true;
			} else if (this.y < this.fourmiliereMere.getyCentre()) {
				this.y+=fourmi.nombrePixelDeplacement;
				incrementeOrdonnee = true;
			}
			
			// Contournement d'obstacle
			while (this.directionIsObstacle()) {
				// Au début d'un contournement
				if (this.contournementCourant == null) {
					// Enregistrement du point de départ du contournement
					Contournement contournementCourant = new Contournement(new Point(this.x, this.y));
					
					// Si celui-ci existe, mise à jour
					if (this.fourmiliereMere.getMemoireCollectiveContournement().containsKey(contournementCourant)) {
						this.contournementCourant = this.fourmiliereMere.getMemoireCollectiveContournement().get(contournementCourant);
					} else {
						this.contournementCourant = contournementCourant;
					}
				}
				
				// Le contournement est testé
				if (this.contournementCourant != null && this.contournementCourant.isTested()) {
					// Reconnaissance du chemin le plus court
					if (this.contournementCourant.getContournementPlusCourt() == Contournement.contournementDroit)  {
						contournementGauche = false;
						contournementDroit = true;
					} else if (this.contournementCourant.getContournementPlusCourt() == Contournement.contournementGauche) {
						contournementGauche = true;
						contournementDroit = false;
					}
				}
				
				// Sert à définir la fin d'un contournement
				hereIsObstacle = true;
				this.contournementCourant.hereIsObstacle(true);
				
				// Contournement selon le sens défini
				if (contournementGauche) {
					if (this.x == positionInitialeX && decrementeOrdonnee) {		// Si la fourmi vient du bas
						this.y = positionInitialeY;
						this.x--;
					} else if (this.y == positionInitialeY && decrementeAbscisse) {	// Si la fourmi vient de la droite
						this.x = positionInitialeX;
						this.y++;
					} else if (this.x == positionInitialeX && incrementeOrdonnee) {	// Si la fourmi vient du haut
						this.y = positionInitialeY;
						this.x++;
					} else if ((this.y == positionInitialeY && incrementeAbscisse)) {	// Vient de la gauche
						this.x = positionInitialeX;
						this.y--;
					} else if ((incrementeAbscisse && decrementeOrdonnee)) {	// Diagonales : bas-gauche
						this.x = positionInitialeX;
					} else if ((decrementeAbscisse && decrementeOrdonnee)) {	// Diagonales : bas-droite
						this.y = positionInitialeY;
					} else if (incrementeAbscisse && incrementeOrdonnee) { // Haut-gauche
						this.x = positionInitialeX;
						this.y-=2;
					} else if (decrementeAbscisse && incrementeOrdonnee) { // Haut-droite
						this.y = positionInitialeY;
						this.x += 2;
					}
					
					// Mise à jour du nombre de déplacement dans le sens des aiguilles d'une montre
					this.contournementCourant.addNombreDeplacement(Contournement.contournementGauche, this.contournementCourant.getNombreDeplacementContournementGauche()+1);
				} else if (contournementDroit) {
					if (this.x == positionInitialeX && decrementeOrdonnee) {		// Si la fourmi vient du bas
						this.y = positionInitialeY;
						this.x++;
					} else if (this.y == positionInitialeY && decrementeAbscisse) {	// Si la fourmi vient de la droite
						this.x = positionInitialeX;
						this.y--;
					} else if (this.x == positionInitialeX && incrementeOrdonnee) {	// Si la fourmi vient du haut
						this.y = positionInitialeY;
						this.x--;
					} else if ((this.y == positionInitialeY && incrementeAbscisse)) {	// Vient de la gauche
						this.x = positionInitialeX;
						this.y++;
					} else if ((incrementeAbscisse && decrementeOrdonnee)) {	// Diagonales : bas-gauche
						this.x = positionInitialeX;
						this.y+=2;
					} else if ((decrementeAbscisse && decrementeOrdonnee)) {	// Diagonales : bas-droite
						this.y = positionInitialeY;
						this.x += 2;
					} else if (incrementeAbscisse && incrementeOrdonnee) { // Haut-gauche
						this.y = positionInitialeY;
						this.x-=2;
					} else if (decrementeAbscisse && incrementeOrdonnee) { // Haut-droite
						this.x = positionInitialeX;
						this.y-=2;
					}
					
					// Mise à jour du nombre de déplacement dans le sens inverse des aiguilles d'une montre
					this.contournementCourant.addNombreDeplacement(Contournement.contournementDroit, this.contournementCourant.getNombreDeplacementContournementDroit()+1);
				}
			}
			
			// La fourmi est à la fourmilière
			if (this.x == this.fourmiliereMere.getxCentre() && this.y == this.fourmiliereMere.getyCentre()) {
				// Dépôt de nourriture
				this.deposeNourriture();
			}
		// Sinon si la fourmi se trouve sur de la nourriture, c'est à dire que les x et y correspondent à l'emplacement d'une nourriture du monde
		} else if (this.isSurNourriture()) {
			// Elle la récupère
			this.getNourriture();
		} else {
			// Cherche une phéromone à proximité et l'enregistre comme phéromone courante
			if (this.hasPheromoneAProximite()) {
				// Se déplace vers celle-ci et enregistre l'orientation du déplacement
				this.ancienneDirectionPheromone = deplacementCourant.calculeOrientation(this.x, this.y, this.lastPheromone.getX(), this.lastPheromone.getY());
				
				this.x = this.lastPheromone.getX();
				this.y = this.lastPheromone.getY();
			} else {
				// Déplacement aléatoire
				this.executeDeplacementAleatoire();
				this.ancienneDirectionPheromone = -1;	// Reset des directions du suivit des phéromones
			}
		}
		
		// Tant que la direction définie est un obstacle, contourne l'obstacle OU que le déplacement a déjà été effectué
		while (this.directionIsObstacle()) {
			this.x = positionInitialeX;
			this.y = positionInitialeY;
			
			this.executeDeplacementAleatoire();	// Déplacement aléatoire
		}
		
		// Fin du contournement
		if (this.contournementCourant != null && this.contournementCourant.stopContournement()) {
			// Si le calul n'est pas complet
			if (this.contournementCourant.getNombreDeplacementContournementDroit() <= 0 || this.contournementCourant.getNombreDeplacementContournementGauche() <= 0) {
				// Revérification si le contournement a été calculé entre temps par une autre fourmi
				Contournement contournementTest = new Contournement(this.contournementCourant.getPosition());
				
				if (this.fourmiliereMere.getMemoireCollectiveContournement().containsKey(contournementTest)) {
					Contournement contournementExistant = this.fourmiliereMere.getMemoireCollectiveContournement().get(contournementTest);
					
					// Fusion des deux informations
					this.contournementCourant.fusionne(contournementExistant);
				}
			}
			
			// Contournement non testé
			if (!this.contournementCourant.isTested()) {
				// Définie si le test est terminé
				this.contournementCourant.setIsTested();
				
				// Ajout à la mémoire collective de la fourmilière
				this.fourmiliereMere.getMemoireCollectiveContournement().put(this.contournementCourant, this.contournementCourant);
			}
			
			this.contournementCourant = null;
		} // Sinon si le contournement n'est pas finit et qu'on est plus sur un obstacle
		else if (this.contournementCourant != null && !this.contournementCourant.stopContournement() && !hereIsObstacle) {
			// Sert à définir la fin d'un contournement
			this.contournementCourant.hereIsObstacle(false);
		}
		
		// Puis se déplace à la position définie
	}
	
	/**
	 * Se déplace d'un pas dans une direction du champs de vision
	 * @return
	 */
	public void executeDeplacementAleatoire() {
		Random rand = new Random();
		boolean dansLeCadre = false, dansChampsVision = false;
		int pourcentageChanceAutreDirection = rand.nextInt(10);
		
		this.deplacementCourant.setAbscisse(this.x);
		this.deplacementCourant.setOrdonnee(this.y);
		
		// 10% de chance de changer de direction
		if (pourcentageChanceAutreDirection == 0) {
			this.deplacementCourant.calculDeplacementAleatoire();
		} else {
			this.deplacementCourant.setDirection(this.ancienneDirection);
			this.deplacementCourant.calculDeplacementMemeDirection();
		}
		
		while (!dansLeCadre || !dansChampsVision) {
			dansLeCadre = this.deplacementCourant.dansCadre(this.fourmiliereMere.getMonde().getSimulation().getLargeur(), this.fourmiliereMere.getMonde().getSimulation().getHauteur());
			dansChampsVision = this.deplacementCourant.dansChampsDeVision(this.ancienneDirection);
			
			if (!dansLeCadre || !dansChampsVision) {
				this.deplacementCourant.setAbscisse(this.x);
				this.deplacementCourant.setOrdonnee(this.y);
				this.deplacementCourant.calculDeplacementAleatoire();
			}
		}
		
		this.x = this.deplacementCourant.getAbscisse();
		this.y = this.deplacementCourant.getOrdonnee();
		this.ancienneDirection = this.deplacementCourant.getDirection();
	}
	
	/**
	 * Dépose une quantité de phéromone à l'emplacement courant
	 */
	public void deposePheromone() {
		pheromone phero = new pheromone(this.x, this.y);
		this.fourmiliereMere.getMonde().getPheromones().remove(phero);
		this.fourmiliereMere.getMonde().getPheromones().add(phero);
	}
	
	/**
	 * Vérifie si des phéromones sont proches de la position de la fourmi et enregistre le phéromone trouvé
	 * @return
	 */
	public boolean hasPheromoneAProximite() {
		Random rand = new Random();
		pheromone pheroTest = new pheromone(0, 0);
		ArrayList<pheromone> pheromones = new ArrayList<pheromone>();
		
		pheroTest = new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y+fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x,this.y+fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x+fourmi.nombrePixelDeplacement,this.y+fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x-fourmi.nombrePixelDeplacement,this.y);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x+fourmi.nombrePixelDeplacement,this.y);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x-fourmi.nombrePixelDeplacement,this.y-fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x,this.y-fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		pheroTest = new pheromone(this.x+fourmi.nombrePixelDeplacement,this.y-fourmi.nombrePixelDeplacement);
		if (this.fourmiliereMere.getMonde().getPheromones().contains(pheroTest)) {
			pheromones.add(pheroTest);
		}
		
		// Si un phéromone est trouvé
		if (pheromones.size() > 0) {
			int pourcentageChanceAutreDirection = rand.nextInt(10);

			// 10% de chance de changer de direction si il y a plus de deux chemins
			if (pheromones.size() > 2 && pourcentageChanceAutreDirection == 0) {
				int indexAleatoire = rand.nextInt(pheromones.size());
				this.lastPheromone = pheromones.get(indexAleatoire);
			} else {
				if (this.ancienneDirectionPheromone == Deplacement.NORTH
				&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x, this.y-fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x, this.y-fourmi.nombrePixelDeplacement);
				} else if (this.ancienneDirectionPheromone == Deplacement.SOUTH
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x, this.y+fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x, this.y+fourmi.nombrePixelDeplacement);
				} else if (this.ancienneDirectionPheromone == Deplacement.EAST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y))) {
					this.lastPheromone = new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y);
				} else if (this.ancienneDirectionPheromone == Deplacement.WEST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y))) {
					this.lastPheromone = new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y);
				} else if (this.ancienneDirectionPheromone == Deplacement.NORTH_EAST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y-fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y-fourmi.nombrePixelDeplacement);
				} else if (this.ancienneDirectionPheromone == Deplacement.NORTH_WEST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y-fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y-fourmi.nombrePixelDeplacement);
				} else if (this.ancienneDirectionPheromone == Deplacement.SOUTH_EAST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y+fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x+fourmi.nombrePixelDeplacement, this.y+fourmi.nombrePixelDeplacement);
				} else if (this.ancienneDirectionPheromone == Deplacement.SOUTH_WEST
						&& this.fourmiliereMere.getMonde().getPheromones().contains(new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y+fourmi.nombrePixelDeplacement))) {
					this.lastPheromone = new pheromone(this.x-fourmi.nombrePixelDeplacement, this.y+fourmi.nombrePixelDeplacement);
				} else {
					int indexAleatoire = rand.nextInt(pheromones.size());
					this.lastPheromone = pheromones.get(indexAleatoire);
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Vérifie si la fourmi est en train de retourner à la fourmilière
	 * @return
	 */
	public boolean isRetourFourmiliere() {
		return this.isRetourFourmiliere;
	}
	
	/**
	 * Vérifie si de la nourriture est proche de la position de la fourmi
	 * @return
	 */
	public boolean isSurNourriture(){
		ArrayList<food> foods = this.fourmiliereMere.getMonde().getFoods();
		
		for (int k=0; k<foods.size(); k++) {
			food foodCourante = foods.get(k);
			
			if (foodCourante.getForme() == food.feuille) {
				if (foodCourante.testValeurFood() >= 50
					&& ((this.x >= foodCourante.x && this.x <= foodCourante.x+20) && (this.y >= foodCourante.y && this.y <= foodCourante.y+80)))
				{
					this.indexNourritureMangee = k;
					return true;
				} else if ((foodCourante.testValeurFood() >= 25 && foodCourante.testValeurFood() <= 49)
					&& ((this.x >= foodCourante.x && this.x <= foodCourante.x+20) && (this.y >= foodCourante.y && this.y <= foodCourante.y+50)))
				{
					this.indexNourritureMangee = k;
					return true;
				} else if ((foodCourante.testValeurFood() >= 1 && foodCourante.testValeurFood() <= 24)
					&& ((this.x >= foodCourante.x && this.x <= foodCourante.x+10) && (this.y >= foodCourante.y && this.y <= foodCourante.y+25)))
				{
					this.indexNourritureMangee = k;
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Vérifie si la direction est un obstacle
	 * @return
	 */
	public boolean directionIsObstacle() {
		HashSet<obstacle> obstacles = this.fourmiliereMere.getMonde().getObstacles();
		
		obstacle obstacleCourant = new obstacle(this.x, this.y);
		obstacle obstacleCourant2 = new obstacle((this.x+this.width), this.y);					// Selon la taille de la fourmi pour que sa forme ne dépasse pas
		obstacle obstacleCourant3 = new obstacle(this.x, (this.y+this.height));					// Selon la taille de la fourmi pour que sa forme ne dépasse pas
		obstacle obstacleCourant4 = new obstacle((this.x+this.width), (this.y+this.height));	// Selon la taille de la fourmi pour que sa forme ne dépasse pas
		
		if (obstacles.contains(obstacleCourant) || obstacles.contains(obstacleCourant2) || obstacles.contains(obstacleCourant3) || obstacles.contains(obstacleCourant4)) {
			return true;
		}

		return false;
	}
	
	/**
	 * Récupère la nourriture
	 */
	public void getNourriture(){
		// Récupère une quantité de nourriture
		this.chargePortee++;
		
		// Met à jour la quantité dans l'objet nourriture
		this.fourmiliereMere.getMonde().getFoods().get(this.indexNourritureMangee).decrementeFood();
		
		// La nourriture est mangée entièrement
		if (this.fourmiliereMere.getMonde().getFoods().get(this.indexNourritureMangee).getQte_rest_food() <= 0) {
			// Suppression dans l'environnement
			this.fourmiliereMere.getMonde().getFoods().remove(this.indexNourritureMangee);
		}
		
		this.indexNourritureMangee = -1;
		
		// Retourne à la fourmilière
		this.isRetourFourmiliere = true;
		
		this.fourmiliereMere.getMonde().getSimulation().getInfosModele().setQteNourritureEnvironement(
				this.fourmiliereMere.getMonde().getSimulation().getInfosModele().getQteNourritureEnvironement()-1);
	}

	/**
	 * Dépose la nourriture à la fourmilière
	 */
	public void deposeNourriture(){
		// Met à jour la quantité dans l'objet fourmilière
		this.fourmiliereMere.addFood(this.chargePortee);

		// Enlève une quantité de nourriture
		this.chargePortee--;

		// Désactive le retour à la fourmilière
		this.isRetourFourmiliere = false;
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
}

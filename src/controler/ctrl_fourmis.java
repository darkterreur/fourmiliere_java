package controler;

import java.util.ArrayList;
import java.util.List;

import modele.food;
import modele.fourmi;
import modele.fourmiliere;
import modele.pheromone;

public class ctrl_fourmis {

	List<fourmi> listFourmi = new ArrayList<fourmi>();
	
	//ajout d'une fourmi a la liste
	public void ajoutFourmi(int charge_max, int X, int Y, fourmiliere fourmiliere, food theFood){
		fourmi maFourmi =  new fourmi(charge_max ,X, Y, fourmiliere, theFood);
		listFourmi.add(maFourmi);
	}
	
	//test si un objet fourmi existe deja dans la liste
	public boolean exist(fourmi myFourmi){
		if(listFourmi.contains(myFourmi)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean exist(int X, int Y){
		boolean trouve = false;
		for(int i=0;i<listFourmi.size();i++){
			if(listFourmi.get(i).getX() == X && listFourmi.get(i).getY() == Y){
				trouve = true;
			}
		}
		return trouve;
	}
	
	public int getIndice(fourmi myFourmi){
		int indice = 0;
		for(int i=0;i<listFourmi.size();i++){
			if(listFourmi.get(i).equals(myFourmi)){
				indice = i;
			}
		}
		return indice;
	}
	
	public int getIndice(int X, int Y){
		int indice = 0;
		for(int i=0;i<listFourmi.size();i++){
			if(listFourmi.get(i).getX() == X && listFourmi.get(i).getY() == Y){
				indice = i;
			}
		}
		return indice;
	}
	
	//enleve un fourmi de la liste
	public void deleteFourmi(fourmi myFourmi){
		if(this.exist(myFourmi)){
			listFourmi.remove(myFourmi);
		}
	}
	
	//tour par tour on charge la fourmit jusqu'au seuil et on met plein a 1
	public void chargementFourmi(fourmi myFourmi){
		int i = getIndice(myFourmi);
		
		if(listFourmi.get(i).getCharge_porter() < listFourmi.get(i).getCharge_max()){
    		listFourmi.get(i).incrementCharge();
    	}else{
    		listFourmi.get(i).setPlein(1);
    	}
	}
	
	//tour par tour on decharge la fourmit jusqu'a 0 et on met plein a 0
	public void dechargementFourmi(fourmi myFourmi){
		int i = getIndice(myFourmi);
		
		if(listFourmi.get(i).getCharge_porter() > 0){
    		listFourmi.get(i).decrementCharge();
    	}else{
    		listFourmi.get(i).setPlein(0);
    	}
	}
	
	//fonction qui parcour tout la liste des fourmis et test si elle sont bien a la bonne place cad la fourmiliere qui lui est associé
	//si oui on balance l'objet au fonction individuel
	public void dechargementAll(){
		for(int i=0;i<listFourmi.size();i++){
			//on test si la fourmit est sur la foumiliere et quelle n'est pas encore vide
				//on appel la fonction dechargementFourmi(obj)
				//on appel la fonction qui incrémente la fourmiliere
		}
	}
	
	//fonction qui parcour tout la liste des fourmis et test si elle sont bien a la bonne place un bloc de nourriture
	//si oui on balance l'objet au fonction individuel
	public void chargementAll(){
		for(int i=0;i<listFourmi.size();i++){
			//on test si la fourmit est sur la nourriturre et quelle n'est pas encore vide
				//on appel la fonction chargementFourmi(obj)
				//on appel la fonction qui décrémente la food
		}
	}
	
	
	
	// Contourne un obstacle selon la stratÈgie d'Èvitement dÈfinie par l'utilisateur
	public void contourneObstacle(){
	
	}
	
	// VÈrifie si un obstacle est proche de la position de la fourmi
	public void hasObstacleProximite(){
	
	}
	
	// VÈrifie si des phÈromones sont proches de la position de la fourmi
	public void pheromoneAProximite(){
	
	}
	
	// Cherche le prochain phÈromone ‡ suivre
	public void searchNextPheromone(){
		//vraiment utile ? si elle se déplace et qu'il y a un phéromone a coté pas beson de chercher le suivant non?
	}
	
	// VÈrifie si de la nourriture est proche de la position de la fourmi
	public void hasNourritureProximite(){
	
	}
	
	public void deplacement(){
	//pour chaque fourmi
	// Si la fourmi a l'Ètat retour ‡ la fourmiliËre
				// Avancer vers la fourmiliËre en ligne droite
			// Sinon si la fourmi se trouve sur de la nourriture, c'est ‡ dire que les x et y correspondent ‡ l'emplacement d'une nourriture du monde
				// La fourmi rÈcupËre de la nourriture
			// Sinon si la fourmi repËre de la nourriture, c'est ‡ dire que de la nourriture se situe dans l'entourage proche de la fourmi
				// Se dÈplacer vers la nourriture
			// Sinon si la fourmi suit des phÈromones
				// Chercher une autre phÈromone
				// Se dÈplacer ‡ l'emplacement de la phÈromone trouvÈe
			// Sinon
				// Chercher une phÈromone ‡ proximitÈ
				// Si une phÈromone est ‡ proximitÈ
					// Se dÈplacer vers celle-ci
				// Sinon
					// Se dÈplacer d'un pas dans une direction alÈatoire
			
			// Si la direction dÈfinie est un obstacle, lancer le contournement de l'obstacle
			// Sinon, se dÈplacer sur la case
	}
	
}

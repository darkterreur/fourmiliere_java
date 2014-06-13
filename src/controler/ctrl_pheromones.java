package controler;

import java.util.ArrayList;
import java.util.List;
import modele.pheromone;

public class ctrl_pheromones {

	List<pheromone> listPhero = new ArrayList<pheromone>();
	
	//ajoute un nouveau pheromone a la liste
	public void ajoutPhero(int qte_base_phero){
		pheromone monPhero = new pheromone(qte_base_phero);
		listPhero.add(monPhero);
	}
	
	//test si un objet phéromone existe deja dans la liste
	public boolean exist(pheromone myPhero){
		if(listPhero.contains(myPhero)){
			return true;
		}else{
			return false;
		}
	}
	
	//enleve un pheromone de la liste
	public void deletePhero(pheromone myPhero){
		if(this.exist(myPhero)){
			
			for(int i=0;i<listPhero.size();i++){  
	            if(listPhero.get(i).equals(myPhero)){  	               
	            	listPhero.remove(i);
	            }  
	         }
			
			//je suppose que l'on peut remplacer le code ci dessus par ceci mais je n'en suis pas sur
			listPhero.remove(myPhero);
			
		}
	}
	
	//on addition la valeur de base d'un phero si, un phero existe au coordonné ou passe une fourmit 
	public void cumulPhero(){
		
	}
	
	//on baisse la qte de phéro de tout les objet et on appel destroyPheros() pour le menage
	public void decrementePhero(){
		
	}
	
	//parcours tout les phero et regarde la quantité si egal 0 on delete
	public void destroyPheros(){
		
	}
	
}

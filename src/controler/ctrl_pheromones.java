package controler;

import java.util.ArrayList;
import java.util.List;
import modele.pheromone;

public class ctrl_pheromones {

	List<pheromone> listPhero = new ArrayList<pheromone>();
	
	//ajoute un nouveau pheromone a la liste
	public void ajoutPhero(int qte_base_phero, int X, int Y){
		pheromone monPhero = new pheromone(qte_base_phero, X, Y);
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
	
	public boolean exist(int X, int Y){
		boolean trouve = false;
		
		for(int i=0;i<listPhero.size();i++){
			if(listPhero.get(i).getX() == X && listPhero.get(i).getY() == Y){
				trouve = true;
			}
		}
		
		return trouve;
	}
	
	public int getIndice(pheromone myPhero){
		int indice = 0;
		
		for(int i=0;i<listPhero.size();i++){
			if(listPhero.get(i).equals(myPhero)){
				indice = i;
			}
		}
		
		return indice;
	}
	
	public int getIndice(int X, int Y){
		int indice = 0;
		
		for(int i=0;i<listPhero.size();i++){
			if(listPhero.get(i).getX() == X && listPhero.get(i).getY() == Y){
				indice = i;
			}
		}
		
		return indice;
	}
	
	//enleve un pheromone de la liste
	public void deletePhero(pheromone myPhero){
		if(this.exist(myPhero)){
			listPhero.remove(myPhero);
		}
	}
	
	//on addition la valeur de base d'un phero si, un phero existe au coordonné ou passe une fourmit 
	public void cumulPhero(){
		
	}
	
	//on baisse la qte de phéro de tout les objet et on appel destroyPheros() pour le menage
	public void decrementePhero(){
		for(int i=0;i<listPhero.size();i++){          
			listPhero.get(i).decrementePheromone();	
         }
		
		destroyPheros();
	}
	
	//parcours tout les phero et regarde la quantité si egal 0 on delete
	public void destroyPheros(){
		for(int i=0;i<listPhero.size();i++){  
            if(listPhero.get(i).getQte_phero() == 0){  	               
            	listPhero.remove(i);
            }  
         }
	}
	
}

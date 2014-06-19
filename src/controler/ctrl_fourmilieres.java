package controler;

import java.util.ArrayList;
import java.util.List;

import modele.food;
import modele.fourmi;
import modele.fourmiliere;
import modele.monde;
import modele.pheromone;

public class ctrl_fourmilieres {

	List<fourmiliere> listFourmiliere = new ArrayList<fourmiliere>();
	public modele.monde monde;
	
	
	public void ajoutFourmiliere(int qte_food_recolter,int X, int Y, int qte_fourmi, int max_fourmi,int qte_food_creat_fourmi,int qte_food_creat_fourmiliere, monde monde){
		fourmiliere myFourmiliere = new fourmiliere(qte_food_recolter, X, Y, qte_fourmi, max_fourmi, qte_food_creat_fourmi,qte_food_creat_fourmiliere, monde);
		listFourmiliere.add(myFourmiliere);
	}
	
	public boolean exist(fourmiliere myFourmiliere){
		if(listFourmiliere.contains(myFourmiliere)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean exist(int X, int Y){
		boolean trouve = false;
		
		for(int i=0;i<listFourmiliere.size();i++){
			if(listFourmiliere.get(i).getX() == X && listFourmiliere.get(i).getY() == Y){
				trouve = true;
			}
		}
		
		return trouve;
	}
	
	public int getIndice(fourmiliere myFourmiliere){
		int indice = 0;
		
		for(int i=0;i<listFourmiliere.size();i++){
			if(listFourmiliere.get(i).equals(myFourmiliere)){
				indice = i;
			}
		}
		
		return indice;
	}
	
	public int getIndice(int X, int Y){
		int indice = 0;
		
		for(int i=0;i<listFourmiliere.size();i++){
			if(listFourmiliere.get(i).getX() == X && listFourmiliere.get(i).getY() == Y){
				indice = i;
			}
		}
		
		return indice;
	}
	
	public void deleteFourmiliere(fourmiliere myFourmiliere){
		if(this.exist(myFourmiliere)){
			listFourmiliere.remove(myFourmiliere);
		}
	}
	
	public boolean testCreateFourmi(fourmiliere myFourmiliere){           
    	if(testQuantiteFoodFourmi(myFourmiliere) && testQuantiteFourmis(myFourmiliere)){
    		return true;
    	}else{
    		return false;
    	}
	}
	
	public boolean testQuantiteFourmis(fourmiliere myFourmiliere) {
		int i = getIndice(myFourmiliere);
		
		if(listFourmiliere.get(i).getQte_fourmi() < listFourmiliere.get(i).getMax_fourmi()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean testQuantiteFoodFourmi(fourmiliere myFourmiliere) {
		int i = getIndice(myFourmiliere);
		
		if(listFourmiliere.get(i).getQte_food_recolter() > listFourmiliere.get(i).getQte_food_creat_fourmi()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean testQuantiteFoodFourmiliere(fourmiliere myFourmiliere) {
		int i = getIndice(myFourmiliere);
		
		if(listFourmiliere.get(i).getQte_food_recolter() > listFourmiliere.get(i).getQte_food_creat_fourmiliere()){
			return true;
		}else{
			return false;
		}
	}
	
	//fonction utile pour la cration des fourmis au fur et a mesure du jeux mais on risque d'avoir un probleme 
	//pour le chargement/initialisation de base ou l'onne prend pas en compte la nourriture et les compteurs
	//faire une autre fonction peut etre?
	public void addFourmi(int charge_max,int X,int Y,fourmiliere myFourmiliere,food theFood){
		int i = getIndice(myFourmiliere);
		
		if(testCreateFourmi(myFourmiliere)){
			//je creer ma fourmi
			listFourmiliere.get(i).getCtrlFourmis().ajoutFourmi(charge_max,X,Y,myFourmiliere,theFood);
			//j'incremente le nb de fourmi dans ma fourmiliere
			listFourmiliere.get(i).setQte_fourmi(listFourmiliere.get(i).getQte_fourmi()+1);
			//je reduit la food global par la qte de food necessaire a la cration d'une fourmit
			listFourmiliere.get(i).setQte_food_recolter(listFourmiliere.get(i).getQte_food_recolter()-listFourmiliere.get(i).getQte_food_creat_fourmi());
		}
	}
	
	public boolean testDupliquerFourmiliere(fourmiliere myFourmiliere){
		int i = getIndice(myFourmiliere);
		
		if(testQuantiteFoodFourmiliere(myFourmiliere) && testQuantiteFourmis(myFourmiliere)==false){
			return true;
		}else{
			return false;
		}
	}
	
	public void dupliqFourmiliere(fourmiliere myFourmiliere,int qte_food_recolter,int X, int Y, int qte_fourmi, int max_fourmi,int qte_food_creat_fourmi,int qte_food_creat_fourmiliere, monde monde){
		
		int i = getIndice(myFourmiliere);
		
		if(testDupliquerFourmiliere(myFourmiliere)){
			
			//on dduit la qte de food necessaire a la cration de la foumiliere
			
			//on dplace la moiti des fourmits d'une fourmiliere a une autre mais je ne sais pas encore comment on fait
			
			//on creer une nouvelle fourmiliere en dernier les coordonne doivent etre alatoire ca va etre dur
			ajoutFourmiliere(qte_food_recolter,X,Y,qte_fourmi,max_fourmi,qte_food_creat_fourmi,qte_food_creat_fourmiliere,monde);
			
		}
		
		
		
		
		
	}
	
}

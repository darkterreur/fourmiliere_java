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
	
	
	public void ajoutFourmiliere(int qte_food_recolter,int X, int Y, int qte_fourmi, int max_fourmi,int qte_food_creat_fourmi, monde monde){
		fourmiliere myFourmiliere = new fourmiliere(qte_food_recolter, X, Y, qte_fourmi, max_fourmi, qte_food_creat_fourmi, monde);
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
    	if(testQuantiteFood(myFourmiliere) && testQuantiteFourmis(myFourmiliere)){
    		return true;
    	}else{
    		return false;
    	}
	}
	
	public boolean testQuantiteFourmis(fourmiliere myFourmiliere) {
		int i = getIndice(myFourmiliere);
		
		if(listFourmiliere.get(i).getQte_food_recolter() > listFourmiliere.get(i).getQte_food_creat_fourmi()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean testQuantiteFood(fourmiliere myFourmiliere) {
		int i = getIndice(myFourmiliere);
		
		if(listFourmiliere.get(i).getQte_fourmi() < listFourmiliere.get(i).getMax_fourmi()){
			return true;
		}else{
			return false;
		}
	}
	
	public void addFourmi(int charge_max,int X,int Y,fourmiliere myFourmiliere,food theFood){
		int i = getIndice(myFourmiliere);
		
		if(testCreateFourmi(myFourmiliere)){
			listFourmiliere.get(i).getCtrlFourmis().ajoutFourmi(charge_max,X,Y,myFourmiliere,theFood);
		}
	}
	
	
	
}

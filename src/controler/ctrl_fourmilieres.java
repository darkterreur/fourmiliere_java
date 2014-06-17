package controler;

import java.util.ArrayList;
import java.util.List;

import modele.fourmi;
import modele.fourmiliere;

public class ctrl_fourmilieres {

	List<fourmiliere> listFourmiliere = new ArrayList<fourmiliere>();
	public modele.monde monde;
	
	public boolean exist(fourmiliere maFourmiliere){
		if(listFourmiliere.contains(maFourmiliere)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean testCreateFourmi(fourmiliere maFourmiliere){
		
		boolean trouve = false;
		
		for(int i=0;i<listFourmiliere.size();i++){  
            if(listFourmiliere.get(i).equals(maFourmiliere)){  	               
            	if(listFourmiliere.get(i).getQte_food_recolter() >= listFourmiliere.get(i).getQte_food_creat_fourmi()){
            		trouve = true;
            	}
            }
        }
		
		return trouve;
	}
	
	public void deleteFourmiliere() {
		
	}
	
	public void addFourmiliere(fourmiliere fourmiliere) {
		
	}
	
	public void testQuantiteFourmis() {
		
	}
	
	public void testQuantiteFood() {
		
	}
	
}

package controler;

import java.util.ArrayList;
import java.util.List;

import modele.fourmi;
import modele.pheromone;

public class ctrl_fourmis {

	List<fourmi> listFourmi = new ArrayList<fourmi>();
	
	//ajout d'une fourmi a la liste
	public void ajoutFourmi(int charge_max, int charge_porter){
		fourmi maFourmi =  new fourmi(charge_max, charge_porter);
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
	
	//enleve un fourmi de la liste
	public void deleteFourmi(fourmi myFourmi){
		if(this.exist(myFourmi)){
			
			for(int i=0;i<listFourmi.size();i++){  
	            if(listFourmi.get(i).equals(myFourmi)){  	               
	            	listFourmi.remove(i);
	            }  
	         }
			
			//je suppose que l'on peut remplacer le code ci dessus par ceci mais je n'en suis pas sur
			listFourmi.remove(myFourmi);
			
		}
	}
	
	//tour par tour on charge la fourmit jusqu'au seuil et on met plein a 1
	public void chargementFourmi(fourmi myFourmi){
		if(this.exist(myFourmi)){
			for(int i=0;i<listFourmi.size();i++){  
	            if(listFourmi.get(i).equals(myFourmi)){  	               
	            	if(listFourmi.get(i).getCharge_porter() < listFourmi.get(i).getCharge_max()){
	            		listFourmi.get(i).incrementCharge();
	            	}else{
	            		listFourmi.get(i).setPlein(1);
	            	}
	            }  
	         }
		}
	}
	
	//tour par tour on decharge la fourmit jusqu'a 0 et on met plein a 0
	public void dechargementFourmi(fourmi myFourmi){
		if(this.exist(myFourmi)){
			for(int i=0;i<listFourmi.size();i++){  
	            if(listFourmi.get(i).equals(myFourmi)){
	            	if(listFourmi.get(i).getCharge_porter() > 0){
	            		listFourmi.get(i).decrementCharge();
	            	}else{
	            		listFourmi.get(i).setPlein(0);
	            	}
	            }  
	         }
		}
	}
	
}

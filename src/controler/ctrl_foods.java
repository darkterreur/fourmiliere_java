package controler;

import java.util.ArrayList;
import java.util.List;

import modele.food;
import modele.pheromone;

public class ctrl_foods {

	List<food> listFood = new ArrayList<food>();
	
	//ajoute un nouveau pheromone a la liste
	public void ajoutFood(int qte_base_food, int X, int Y){
		food maFood = new food(qte_base_food, X, Y);
		listFood.add(maFood);
	}
	
	//enleve un pheromone de la liste
	public void deleteFood(food myFood){
		if(this.exist(myFood)){
			listFood.remove(myFood);
		}
	}
	
	//test si un objet phéromone existe deja dans la liste
	public boolean exist(food myFood){
		if(listFood.contains(myFood)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean exist(int X, int Y){
		boolean trouve = false;
		
		for(int i=0;i<listFood.size();i++){
			if(listFood.get(i).getX() == X && listFood.get(i).getY() == Y){
				trouve = true;
			}
		}
		
		return trouve;
	}
	
	public int getIndice(pheromone myFood){
		int indice = 0;
		
		for(int i=0;i<listFood.size();i++){
			if(listFood.get(i).equals(myFood)){
				indice = i;
			}
		}
		
		return indice;
	}
	
	public int getIndice(int X, int Y){
		int indice = 0;
		
		for(int i=0;i<listFood.size();i++){
			if(listFood.get(i).getX() == X && listFood.get(i).getY() == Y){
				indice = i;
			}
		}
		
		return indice;
	}
}

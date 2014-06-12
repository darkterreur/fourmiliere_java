package modele;

public class fourmiliere {
	
	//attribut
	private int qte_food_recolter;
	private int qte_fourmi;
	private int max_fourmi;
	
	//methode
	public fourmiliere(int qte_food_recolter, int qte_fourmi, int max_fourmi) {
		super();
		this.qte_food_recolter = qte_food_recolter;
		this.qte_fourmi = qte_fourmi;
		this.max_fourmi = max_fourmi;
	}

	@Override
	public String toString() {
		return "fourmiliere [qte_food_recolter=" + qte_food_recolter
				+ ", qte_fourmi=" + qte_fourmi + ", max_fourmi=" + max_fourmi
				+ "]";
	}

	//accesseur
	public int getQte_food_recolter() {
		return qte_food_recolter;
	}

	public void setQte_food_recolter(int qte_food_recolter) {
		this.qte_food_recolter = qte_food_recolter;
	}

	public int getQte_fourmi() {
		return qte_fourmi;
	}

	public void setQte_fourmi(int qte_fourmi) {
		this.qte_fourmi = qte_fourmi;
	}

	public int getMax_fourmi() {
		return max_fourmi;
	}

	public void setMax_fourmi(int max_fourmi) {
		this.max_fourmi = max_fourmi;
	}
	
	
	
	
	
	
	
}

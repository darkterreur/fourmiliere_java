package modele;

public class fourmi {
	//attribut
	private int charge_max;
	private int charge_porter;
	private int plein;
	
	//methode
	public fourmi(int charge_max) {
		this.charge_max = charge_max;
		this.charge_porter = 0;
		this.plein = 0;
	}
	
	@Override
	public String toString() {
		return "fourmi [charge_max=" + charge_max + ", charge_porter=" + charge_porter + ", plein=" + plein + "]";
	}
	
	public void incrementCharge(){
		this.setCharge_porter(this.getCharge_porter()+1);
	}
	
	public void decrementCharge(){
		this.setCharge_porter(this.getCharge_porter()-1);
	}
	
	//accesseur
	public int getCharge_max() {
		return charge_max;
	}
	public void setCharge_max(int charge_max) {
		this.charge_max = charge_max;
	}
	public int getCharge_porter() {
		return charge_porter;
	}
	public void setCharge_porter(int charge_porter) {
		this.charge_porter = charge_porter;
	}
	
	public int getPlein() {
		return plein;
	}
	public void setPlein(int plein) {
		this.plein = plein;
	}
	
}

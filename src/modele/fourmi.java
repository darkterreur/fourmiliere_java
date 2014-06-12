package modele;

public class fourmi {
	//attribut
	private int charge_max;
	private int charge_porter;
	
	//methode
	public fourmi(int charge_max, int charge_porter) {
		super();
		this.charge_max = charge_max;
		this.charge_porter = charge_porter;
	}
	
	@Override
	public String toString() {
		return "fourmi [charge_max=" + charge_max + ", charge_porter="
				+ charge_porter + "]";
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
	
	
	
	
	
	
}

package modele;

public class obstacle {
	public static String cailloux = "cailloux";
	public static String feuille = "feuille";
	public static String flac = "flac";
	public static String branche = "branche";
	
	//attribut
	private String forme;
	protected int x = 0;
	protected int y = 0;
	protected int width = 0;
	protected int height = 0;
	
	//methode
	public obstacle(String forme, int x, int y) {
		this.x = x;
		this.y = y;
		this.forme = forme;
	}

	@Override
	public String toString() {
		return "obstacle [forme=" + forme + "]";
	}
	
	//accesseur
	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	
	
	
}

package modele;

/**
 * Un obstacle de l'environnement
 *
 */
public class obstacle {
	public static String cailloux = "cailloux";
	public static String flac = "flac";
	public static String branche = "branche";
	
	protected int x = 0;
	protected int y = 0;
	protected int width = 1;
	protected int height = 1;
	
	public obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {	// Pour la méthode contains()
		return this.x+this.y;
	}
	
	@Override
	public boolean equals(Object o) {	// Pour la méthode contains()
		obstacle other = (obstacle) o;
		
		return (this.x == other.x && this.y == other.y) ? true : false;
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
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

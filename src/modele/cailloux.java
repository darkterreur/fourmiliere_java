package modele;

import java.awt.Graphics;

public class cailloux extends obstacle{
	public cailloux(String forme, int x, int y) {
		super(forme, x, y);
		this.width = 10;
		this.height = 10;
	}
	
}

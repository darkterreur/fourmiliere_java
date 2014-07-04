package vue;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import modele.simulation;
 
/**
 * Repr�sente la fen�tre principale contenant le rendu
 */
public class MonJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private rendu rendu;								// Le rendu de la simulation
	
	/**
	 * D�finie la taille et passe la simulation au rendu
	 * @param largeur
	 * @param hauteur
	 * @param sim
	 */
    public MonJFrame(int largeur, int hauteur, simulation sim){
    	super();	
    	this.rendu = new rendu(sim);
    	
		rendu.setBackground(Color.GREEN);
 		
		this.setLayout(null);
		this.setContentPane(rendu);
    	
		this.setTitle("Simulation fourragement");
		this.setSize(sim.getHauteur(),sim.getLargeur());
		this.setSize(2000,2000);
		
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // D�fini la taille minimum de la fen�tre
        this.setMinimumSize(new Dimension(500, 500));
        this.pack();
        
        // Plein �cran
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.setVisible(true);
    }
    
    /**
     * Redessine le rendu en lui r�adressant la simulation avanc�e d'un pas
     * @param sim
     */
    public void paint(simulation sim){
    	rendu.setSimulation(sim);
    	rendu.repaint();
    }
}

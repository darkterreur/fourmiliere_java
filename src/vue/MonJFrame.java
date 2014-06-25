package vue;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import modele.simulation;
 
/**
 * Représente la fenêtre principale contenant le rendu
 */
public class MonJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private rendu rendu;	// Le rendu de la simulation
	
	/**
	 * Définie la taille et passe la simulation au rendu
	 * @param largeur
	 * @param hauteur
	 * @param sim
	 */
    public MonJFrame(int largeur, int hauteur, simulation sim){
    	super();	
    	this.rendu = new rendu(sim);
		
        this.setContentPane(rendu);
		this.setSize(sim.getHauteur(),sim.getLargeur());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    /**
     * Redessine le rendu en lui readressant la simulation avancée d'un pas
     * @param sim
     */
    public void paint(simulation sim){
    	rendu.setSimulation(sim);
    	rendu.repaint();
    }
}

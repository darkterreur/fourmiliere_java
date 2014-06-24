package vue;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modele.simulation;
 
 
public class MonJFrame extends JFrame{
 
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private rendu rendu;
	
    public MonJFrame(int largeur, int hauteur, simulation sim){
    	super();	
    	this.rendu = new rendu(sim);
		
        this.setContentPane(rendu);
		this.setSize(sim.getHauteur(),sim.getLargeur());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    public void paint(simulation sim){
    	rendu.setSimulation(sim);
    	rendu.repaint();
    }
}

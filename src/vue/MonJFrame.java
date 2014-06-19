package vue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.simulation;
 
 
public class MonJFrame extends JFrame{
 
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private rendu rendu  ;
      
    
        public MonJFrame(int largeur, int hauteur, simulation sim){
        		rendu = new rendu(sim, hauteur);
        	
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setContentPane(rendu);
                this.pack();
                this.setVisible(true);
                
                
        }
        
        public void paint(simulation sim){
        	rendu.setSimulation(sim);
        	rendu.repaint();
        }
        
        
}

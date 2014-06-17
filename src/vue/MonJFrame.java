package vue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.simulation;
 
 
public class MonJFrame extends JFrame{
 
        private MonJPanel p  ;
      
    
        public MonJFrame(int largeur, int hauteur, simulation sim){
        		p = new MonJPanel(sim, hauteur);
               
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                this.setContentPane(p);
                this.pack();
                this.setVisible(true);
                
                
        }
        
        public void paint(simulation sim){
        	p.setsimulation(sim);
        	p.repaint();
        }
        
        
}

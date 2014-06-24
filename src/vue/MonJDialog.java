package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import modele.monde;
import modele.simulation;
import controler.controleur;

public class MonJDialog extends JDialog {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Parametrage zInfo = new Parametrage();
  private boolean sendData;
  private JLabel tailleLabel, sexeLabel, cheveuxLabel, ageLabel, nbreFourmisLabel,taille2Label, icon;
  private JRadioButton tranche1, tranche2, tranche3, tranche4;
  private JComboBox sexe, cheveux;
  private JTextField taille, nbreFourmis;

  public MonJDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(550, 270);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    this.initComponent();
  }

  public Parametrage getParams(){
    this.sendData = false;      
    return this.zInfo;      
  }

  private void initComponent(){
    //Icône
    icon = new JLabel(new ImageIcon("images/icone.jpg"));
    JPanel panIcon = new JPanel();
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    panIcon.add(icon);

    //Le nom
    JPanel panTaille = new JPanel();
    panTaille.setBackground(Color.white);
    panTaille.setPreferredSize(new Dimension(220, 200));
    panTaille.setBorder(BorderFactory.createTitledBorder("Monde"));

    taille = new JTextField();
    taille.setPreferredSize(new Dimension(100, 25));
    tailleLabel = new JLabel("Taille :");
    
    panTaille.add(tailleLabel);
    panTaille.add(taille);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panTaille);
    
    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
    	  Parametrage params = null;
		  
			setVisible(false);
			
			String sTaille = taille.getText();
  	  
			if (sTaille.length() > 0) {
				params = new Parametrage(Integer.valueOf(sTaille));
			} else {
				params = new Parametrage(Parametrage.TAILLE_DEFAUT);
			}
			
			simulation sim = new simulation(params);
			monde monde1 = new monde(3, 12, 1, 15, true, sim);
			
			sim.addMonde(monde1);
			/*
			controleur c = new controleur(sim, params.getTaille());
			c.run(sim);*/
			MonJFrame fenetre = new MonJFrame(200, 200, sim);
			fenetre.paint(sim);
			sim.setIsStart(false);
			
			while (true)  {
				sim.nextStep();
				
				fenetre.repaint();
				
				try {Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
      }
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
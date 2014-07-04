import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modele.Fichier;
import modele.Parametrage;
import modele.monde;
import modele.simulation;
import controler.controleur;

/**
 * Lance l'application :
 * 	1. Demande le paramétrage
 * 	2. Lance la simulation selon ce dernier
 *
 */
public class run {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialisation
		String tailleText = "";
		String nombreFourmisText = "";
		String qteObstaclesText = "";
		String qteNourritureText = "";
		String vitesseEvapoText = "";
		String isScenarioText = "";
		String isScenario2Text = "";
		String isScenario3Text = "";
		boolean isScenario = false;
		boolean isScenario2 = false;
		boolean isScenario3 = false;
		Parametrage params = null;
		JFrame parametrageSimulationFrame = new JFrame();
		int option = 0;
		
		JTextField tailleField = new JTextField();
		JTextField nombreFourmisField = new JTextField();
		JTextField qteObstaclesField = new JTextField();
		JTextField qteNourritureField = new JTextField();
		JTextField vitesseEvapoField = new JTextField();
		JCheckBox isScenarioBox = new JCheckBox();
		JCheckBox isScenario2Box = new JCheckBox();
		JCheckBox isScenario3Box = new JCheckBox();
		
		// Valeurs par défaut du paramétrage
		tailleField.setText(String.valueOf(Parametrage.TAILLE_DEFAUT));
		nombreFourmisField.setText(String.valueOf(Parametrage.NOMBRE_FOURMIS));
		qteObstaclesField.setText(String.valueOf(Parametrage.QTE_OBSTACLES));
		qteNourritureField.setText(String.valueOf(Parametrage.QTE_NOURRITURE));
		vitesseEvapoField.setText(String.valueOf(Parametrage.VITESSE_EVAPO_PHERO));
		
		// Si une sauvegarde existe
		String sauvegarde = Fichier.lire(Parametrage.EMPLACEMENT_SAUVEGARDE);
		
		if (!sauvegarde.isEmpty()) {
			int response1 = JOptionPane.showConfirmDialog(null, "Voulez-vous charger vos derniers paramètres enregistrés ?");
			
			if (response1 == JOptionPane.YES_OPTION) {
				String[] split = sauvegarde.split(System.getProperty("line.separator"));
				
				if (split.length >= 8) {
					tailleField.setText(split[0]);
					nombreFourmisField.setText(split[1]);
					qteObstaclesField.setText(split[2]);
					qteNourritureField.setText(split[3]);
					vitesseEvapoField.setText(split[4]);
					
					if (split[5].equals("1")) {
						isScenarioBox.setSelected(true);
					}
					
					if (split[6].equals("1")) {
						isScenario2Box.setSelected(true);
					}
					
					if (split[7].equals("1")) {
						isScenario3Box.setSelected(true);
					}
				}
			}
		}
		
		// Paramétrage de la simulation
		parametrageSimulationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		while (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION &&
				(tailleText.isEmpty() || nombreFourmisText.isEmpty() || qteObstaclesText.isEmpty() || qteNourritureText.isEmpty() || vitesseEvapoText.isEmpty())) {
			Object[] message = {
			    "Taille :", tailleField,
			    "Nombre de fourmis :", nombreFourmisField,
			    "Quantité d'obstacles :", qteObstaclesField,
			    "Quantité de nourriture :", qteNourritureField,
			    "Vitesse d'évaporation des phéromones :", vitesseEvapoField,
			    "Activer le scénario de contournement d'obstacles numéro 1 :", isScenarioBox,
			    "Activer le scénario de contournement d'obstacles numéro 2 :", isScenario2Box,
			    "Activer le scénario de contournement d'obstacles numéro 3 :", isScenario3Box
			};
			
			option = JOptionPane.showConfirmDialog(parametrageSimulationFrame, message, "Entrez le paramétrage de la simulation :", JOptionPane.OK_CANCEL_OPTION);
			
			if (option == JOptionPane.OK_OPTION)
			{
			    tailleText = tailleField.getText();
			    nombreFourmisText = nombreFourmisField.getText();
			    qteObstaclesText = qteObstaclesField.getText();
			    qteNourritureText = qteNourritureField.getText();
			    vitesseEvapoText = vitesseEvapoField.getText();
			    
			    if (isScenarioBox.isSelected()) {
			    	isScenario = true;
			    	isScenarioText = "1";
			    } else {
			    	isScenarioText = "0";
			    }
			    
			    if (isScenario2Box.isSelected()) {
			    	isScenario2 = true;
			    	isScenario2Text = "1";
			    } else {
			    	isScenario2Text = "0";
			    }
			    
			    if (isScenario3Box.isSelected()) {
			    	isScenario3 = true;
			    	isScenario3Text = "1";
			    } else {
			    	isScenario3Text = "0";
			    }
			}
		}
		
		// Demande si l'utilisateur veut sauvegarder le paramétrage
		if (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {
			int response2 = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer vos paramètres ?");
			
			if (response2 == JOptionPane.YES_OPTION) {
				Fichier.ecrire(Parametrage.EMPLACEMENT_SAUVEGARDE,
								tailleText+System.getProperty("line.separator" )
								+nombreFourmisText+System.getProperty("line.separator")
								+qteObstaclesText+System.getProperty("line.separator" )
								+qteNourritureText+System.getProperty("line.separator" )
								+vitesseEvapoText+System.getProperty("line.separator" )
								+isScenarioText+System.getProperty("line.separator" )
								+isScenario2Text+System.getProperty("line.separator" )
								+isScenario3Text
							);
			}
			
			// Création de l'environnement en fonction du paramétrage
			params = new Parametrage(Integer.valueOf(tailleText), Integer.valueOf(nombreFourmisText), Integer.valueOf(qteObstaclesText),
					Integer.valueOf(qteNourritureText), Integer.valueOf(vitesseEvapoText), isScenario, isScenario2, isScenario3);
			
			simulation sim = new simulation(params);
			monde monde1 = new monde(params, sim);
			
			sim.addMonde(monde1);
			
			// Lancement de la simulation
			controleur c = new controleur(sim, params.getTaille());
			c.run(sim);
		}
	}
	
}

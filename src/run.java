import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
		String vitesseJeuText = "";
		boolean isScenario = false;
		Parametrage params = null;
		JFrame parametrageSimulationFrame = new JFrame();
		int option = 0;
		
		JComboBox<String> tailleCombo = new JComboBox<String>();
		JTextField nombreFourmisField = new JTextField();
		JTextField qteObstaclesField = new JTextField();
		JTextField qteNourritureField = new JTextField();
		JTextField vitesseEvapoField = new JTextField();
		JComboBox<String> vitesseJeuCombo = new JComboBox<String>();
		JCheckBox isScenarioBox = new JCheckBox();
		
		// Valeurs par défaut du paramétrage
		tailleCombo.addItem(Parametrage.TAILLE_PETITE_TEXTE);
		tailleCombo.addItem(Parametrage.TAILLE_MOYENNE_TEXTE);
		tailleCombo.addItem(Parametrage.TAILLE_GRANDE_TEXTE);
		
		nombreFourmisField.setText(String.valueOf(Parametrage.NOMBRE_FOURMIS));
		qteObstaclesField.setText(String.valueOf(Parametrage.QTE_OBSTACLES));
		qteNourritureField.setText(String.valueOf(Parametrage.QTE_NOURRITURE));
		vitesseEvapoField.setText(String.valueOf(Parametrage.VITESSE_EVAPO_PHERO));

		vitesseJeuCombo.addItem(Parametrage.VITESSE_JEU_LENTE_TEXTE);
		vitesseJeuCombo.addItem(Parametrage.VITESSE_JEU_MOYENNE_TEXTE);
		vitesseJeuCombo.addItem(Parametrage.VITESSE_JEU_RAPIDE_TEXTE);
		
		// Si une sauvegarde existe
		String sauvegarde = Fichier.lire(Parametrage.EMPLACEMENT_SAUVEGARDE);
		
		if (!sauvegarde.isEmpty()) {
			int response1 = JOptionPane.showConfirmDialog(null, "Voulez-vous charger vos derniers paramètres enregistrés ?");
			
			if (response1 == JOptionPane.YES_OPTION) {
				String[] split = sauvegarde.split(System.getProperty("line.separator"));
				
				if (split.length >= 6) {
					tailleCombo.setSelectedItem(split[0]);
					nombreFourmisField.setText(split[1]);
					qteObstaclesField.setText(split[2]);
					qteNourritureField.setText(split[3]);
					vitesseEvapoField.setText(split[4]);
					vitesseJeuCombo.setSelectedItem(split[5]);
					
					if (split[6].equals("1")) {
						isScenarioBox.setSelected(true);
					}
				}
			} else if (response1 == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		}
		
		// Paramétrage de la simulation
		parametrageSimulationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		while (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION &&
				(tailleText.isEmpty() || nombreFourmisText.isEmpty() || qteObstaclesText.isEmpty() || qteNourritureText.isEmpty() || vitesseEvapoText.isEmpty())) {
			Object[] message = {
			    "Taille :", tailleCombo,
			    "Nombre de fourmis :", nombreFourmisField,
			    "Quantité d'obstacles :", qteObstaclesField,
			    "Quantité de nourriture :", qteNourritureField,
			    "Vitesse d'évaporation des phéromones :", vitesseEvapoField,
			    "Vitesse de jeu :", vitesseJeuCombo,
			    "Activer le scénario de contournement d'obstacles :", isScenarioBox
			};
			
			option = JOptionPane.showConfirmDialog(parametrageSimulationFrame, message, "Entrez le paramétrage de la simulation :", JOptionPane.OK_CANCEL_OPTION);
			
			if (option == JOptionPane.OK_OPTION)
			{
			    tailleText = (String) tailleCombo.getSelectedItem();
			    nombreFourmisText = nombreFourmisField.getText();
			    qteObstaclesText = qteObstaclesField.getText();
			    qteNourritureText = qteNourritureField.getText();
			    vitesseEvapoText = vitesseEvapoField.getText();
			    vitesseJeuText = (String) vitesseJeuCombo.getSelectedItem();
			    
			    if (isScenarioBox.isSelected()) {
			    	isScenario = true;
			    	isScenarioText = "1";
			    } else {
			    	isScenarioText = "0";
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
								+vitesseJeuText+System.getProperty("line.separator" )
								+isScenarioText
							);
			}
			
			// Création de l'environnement en fonction du paramétrage
			params = new Parametrage(tailleText, Integer.valueOf(nombreFourmisText), Integer.valueOf(qteObstaclesText),
					Integer.valueOf(qteNourritureText), Integer.valueOf(vitesseEvapoText), vitesseJeuText, isScenario);
			
			simulation sim = new simulation(params);
			monde monde1 = new monde(params, sim);
			
			sim.addMonde(monde1);
			
			// Lancement de la simulation
			controleur c = new controleur(sim, params.getTaille());
			c.run(sim);
		} else {
			System.exit(0);
		}
	}
	
}

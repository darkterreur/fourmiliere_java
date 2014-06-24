import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import vue.MonJFrame;
import modele.Fichier;
import modele.Parametrage;
import modele.fourmiliere;
import modele.monde;
import modele.simulation;
import controler.controleur;


public class run {


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tailleText = "";
		String nombreFourmisText = "";
		String qteObstaclesText = "";
		String qteNourritureText = "";
		String vitesseEvapoText = "";
		String obstacleEntreFoumEtNourText = "";
		boolean obstacleEntreFoumEtNour = Parametrage.OBSTACLES_ENTRE_FOURMILIERE_ET_NOURRITURE;
		Parametrage params = null;
		JFrame parametrageSimulationFrame = new JFrame();
		int option = 0;
		
		JTextField tailleField = new JTextField();
		JTextField nombreFourmisField = new JTextField();
		JTextField qteObstaclesField = new JTextField();
		JTextField qteNourritureField = new JTextField();
		JTextField vitesseEvapoField = new JTextField();
		JCheckBox obstacleEntreFoumEtNourBox = new JCheckBox();
		
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
				
				tailleField.setText(String.valueOf(split[0]));
				nombreFourmisField.setText(String.valueOf(split[1]));
				qteObstaclesField.setText(String.valueOf(split[2]));
				qteNourritureField.setText(String.valueOf(split[3]));
				vitesseEvapoField.setText(String.valueOf(split[4]));
				
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
			    "Obstacle entre la fourmilière et la nourriture :", obstacleEntreFoumEtNourBox
			};
			
			option = JOptionPane.showConfirmDialog(parametrageSimulationFrame, message, "Entrez le paramétrage de la simulation :", JOptionPane.OK_CANCEL_OPTION);
			
			if (option == JOptionPane.OK_OPTION)
			{
			    tailleText = tailleField.getText();
			    nombreFourmisText = nombreFourmisField.getText();
			    qteObstaclesText = qteObstaclesField.getText();
			    qteNourritureText = qteNourritureField.getText();
			    vitesseEvapoText = vitesseEvapoField.getText();
			    if (obstacleEntreFoumEtNourBox.isSelected()) {
			    	obstacleEntreFoumEtNour = true;
			    	obstacleEntreFoumEtNourText = "1";
			    } else {
			    	obstacleEntreFoumEtNourText = "0";
			    }
			}
		}
		
		if (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {
			int response2 = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer vos paramètres ?");
			
			if (response2 == JOptionPane.YES_OPTION) {
				Fichier.ecrire(Parametrage.EMPLACEMENT_SAUVEGARDE,
								tailleText+System.getProperty("line.separator" )
								+nombreFourmisText+System.getProperty("line.separator")
								+qteObstaclesText+System.getProperty("line.separator" )
								+qteNourritureText+System.getProperty("line.separator" )
								+vitesseEvapoText+System.getProperty("line.separator" )
								+obstacleEntreFoumEtNourText
							);
			}
			
			params = new Parametrage(Integer.valueOf(tailleText), Integer.valueOf(nombreFourmisText), Integer.valueOf(qteObstaclesText), Integer.valueOf(qteNourritureText), Integer.valueOf(vitesseEvapoText), obstacleEntreFoumEtNour);
			
			simulation sim = new simulation(params);
			monde monde1 = new monde(params, sim);
			
			sim.addMonde(monde1);
			
			controleur c = new controleur(sim, params.getTaille());
			c.run(sim);
		}
	}
	
}

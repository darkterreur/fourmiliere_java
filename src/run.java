import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import vue.MonJDialog;
import vue.MonJFrame;
import vue.Parametrage;
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
		boolean obstacleEntreFoumEtNour = Parametrage.OBSTACLES_ENTRE_FOURMILIERE_ET_NOURRITURE;
		Parametrage params = null;
		JFrame parametrageSimulationFrame = new JFrame();
		int option = 0;
		
		JTextField tailleField = new JTextField();
		tailleField.setText(String.valueOf(Parametrage.TAILLE_DEFAUT));
		
		JTextField nombreFourmisField = new JTextField();
		nombreFourmisField.setText(String.valueOf(Parametrage.NOMBRE_FOURMIS));
		
		JTextField qteObstaclesField = new JTextField();
		qteObstaclesField.setText(String.valueOf(Parametrage.QTE_OBSTACLES));
		
		JTextField qteNourritureField = new JTextField();
		qteNourritureField.setText(String.valueOf(Parametrage.QTE_NOURRITURE));
		
		JTextField vitesseEvapoField = new JTextField();
		vitesseEvapoField.setText(String.valueOf(Parametrage.VITESSE_EVAPO_PHERO));
		
		JCheckBox obstacleEntreFoumEtNourBox = new JCheckBox();
		
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
			    if (obstacleEntreFoumEtNourBox.isSelected()) obstacleEntreFoumEtNour = true;
			}
		}
		
		if (option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {
			params = new Parametrage(Integer.valueOf(tailleText), Integer.valueOf(nombreFourmisText), Integer.valueOf(qteObstaclesText), Integer.valueOf(qteNourritureText), Integer.valueOf(vitesseEvapoText), obstacleEntreFoumEtNour);
			
			simulation sim = new simulation(params);
			monde monde1 = new monde(params, sim);
			
			sim.addMonde(monde1);
			
			controleur c = new controleur(sim, params.getTaille());
			c.run(sim);
		}
	}
	
}

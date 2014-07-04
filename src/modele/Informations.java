package modele;

/**
 * Information sur la simulation en cours
 *
 */
public class Informations {
	private int numeroPasSim = 0;
	private int qteNourritureFourmiliere = 0;
	private int qteNourritureEnvironement = 0;
	private int qteTotalPheroDansEnv = 0;

	public int getNumeroPasSim() {
		return this.numeroPasSim;
	}

	public void setNumeroPasSim(int numeroPasSim) {
		this.numeroPasSim = numeroPasSim;
	}

	public int getQteNourritureFourmiliere() {
		return this.qteNourritureFourmiliere;
	}

	public void setQteNourritureFourmiliere(int qteNourritureFourmiliere) {
		this.qteNourritureFourmiliere = qteNourritureFourmiliere;
	}

	public int getQteNourritureEnvironement() {
		return qteNourritureEnvironement;
	}

	public void setQteNourritureEnvironement(int qteNourritureEnvironement) {
		this.qteNourritureEnvironement = qteNourritureEnvironement;
	}

	public int getQteTotalPheroDansEnv() {
		return qteTotalPheroDansEnv;
	}

	public void setQteTotalPheroDansEnv(int qteTotalPheroDansEnv) {
		this.qteTotalPheroDansEnv = qteTotalPheroDansEnv;
	}
}

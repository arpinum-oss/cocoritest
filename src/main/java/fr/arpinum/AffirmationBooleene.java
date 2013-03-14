package fr.arpinum;

public class AffirmationBooleene {

	protected AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	protected Boolean estSatisfaite() {
		return booléen != null && booléen;
	}

	private Boolean booléen;
}

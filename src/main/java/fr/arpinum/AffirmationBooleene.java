package fr.arpinum;

import fr.arpinum.outil.Objets;

public class AffirmationBooleene {

	protected AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	protected Boolean estSatisfaite() {
		return Objets.egaux(booléen, true);
	}

	private Boolean booléen;
}

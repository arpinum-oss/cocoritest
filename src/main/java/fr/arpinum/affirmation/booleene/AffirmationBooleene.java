package fr.arpinum.affirmation.booleene;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Objets;

abstract class AffirmationBooleene extends Affirmation {

	AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	void estVraiInterne() {
		if (!estSatisfaite()) {
			échoue("La valeur n'est pas vraie.");
		}
	}

	void estFauxInterne() {
		if (estSatisfaite()) {
			échoue("La valeur n'est pas fausse.");
		}
	}

	private Boolean estSatisfaite() {
		return Objets.egaux(booléen, true);
	}

	private final Boolean booléen;
}

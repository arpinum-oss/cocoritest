package fr.arpinum.affirmation.booleene;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Objets;

abstract class AffirmationBooleene extends Affirmation {

	AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	void estVraiInterne() {
		satisfait(true);
	}

	void estFauxInterne() {
		satisfait(false);
	}

	private void satisfait(boolean attendue) {
		if (Objets.différents(booléen, attendue)) {
			échoue("La valeur n'est pas %s.", attendue ? "vraie" : "fausse");
		}
	}

	private final Boolean booléen;
}

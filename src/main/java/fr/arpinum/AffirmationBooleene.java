package fr.arpinum;

import fr.arpinum.outil.Objets;

public class AffirmationBooleene {

	protected AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	protected void estVraiInterne() {
		if (!estSatisfaite()) {
			throw new ExceptionAssertion("La valeur n'est pas vraie.");
		}
	}

	public void estFauxInterne() {
		if (estSatisfaite()) {
			throw new ExceptionAssertion("La valeur n'est pas fausse.");
		}
	}

	private Boolean estSatisfaite() {
		return Objets.egaux(booléen, true);
	}

	private Boolean booléen;
}

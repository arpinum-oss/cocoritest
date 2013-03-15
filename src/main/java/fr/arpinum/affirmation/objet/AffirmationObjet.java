package fr.arpinum.affirmation.objet;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Objets;

public abstract class AffirmationObjet<T> extends Affirmation {

	AffirmationObjet(T valeur) {
		this.valeur = valeur;
	}

	public void est(T valeurAttendue) {
		if (Objets.différents(valeur, valeurAttendue)) {
			échoue("La valeur est %s et non %s.", valeur, valeurAttendue);
		}
	}

	public void nEstPas(T valeurAttendue) {
		if (Objets.egaux(valeur, valeurAttendue)) {
			échoue("La valeur est %s alors que ce n'était pas voulu.", valeur);
		}
	}

	private final T valeur;
}

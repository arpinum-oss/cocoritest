package fr.arpinum.affirmations;

import fr.arpinum.outils.Objets;

public class AffirmationObjet<T> {

	public AffirmationObjet(T valeur) {
		this.valeur = valeur;
	}

	public void est(T valeurAttendue) {
		if (Objets.différents(valeur, valeurAttendue)) {
			throw new ExceptionAffirmation(String.format("La valeur est %s et non %s.", valeur, valeurAttendue));
		}
	}

	private final T valeur;
}

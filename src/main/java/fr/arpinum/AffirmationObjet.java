package fr.arpinum;

import fr.arpinum.outil.Objets;

public class AffirmationObjet<T> {

	public AffirmationObjet(T valeur) {
		this.valeur = valeur;
	}

	public <T2> void est(T2 valeurAttendue) {
		if (!estSatisfaite(valeurAttendue)) {
			throw new ExceptionAssertion(String.format("La valeur est %s et non %s.", valeur, valeurAttendue));
		}
	}

	private <T2> boolean estSatisfaite(T2 valeurAttendue) {
		return Objets.egaux(valeur, valeurAttendue);
	}

	private T valeur;
}

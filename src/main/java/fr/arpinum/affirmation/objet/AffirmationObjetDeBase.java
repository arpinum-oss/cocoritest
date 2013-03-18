package fr.arpinum.affirmation.objet;

import fr.arpinum.affirmation.Affirmation;
import fr.arpinum.outils.Objets;

public class AffirmationObjetDeBase<T> extends Affirmation implements AffirmationObjet<T>, AffirmationObjetAuFeminin<T> {

	public AffirmationObjetDeBase(T valeur) {
		this.valeur = valeur;
	}

	@Override
	public void est(T valeurAttendue) {
		if (Objets.différents(valeur, valeurAttendue)) {
			échoue("La valeur est %s et non %s.", valeur, valeurAttendue);
		}
	}

	@Override
	public void nEstPas(T valeurAttendue) {
		if (Objets.egaux(valeur, valeurAttendue)) {
			échoue("La valeur est %s alors que ce n'était pas voulu.", valeur);
		}
	}

	@Override
	public void estNul() {
		est(null);
	}

	@Override
	public void nEstPasNul() {
		nEstPas(null);
	}

	@Override
	public void estNulle() {
		est(null);
	}

	@Override
	public void nEstPasNulle() {
		nEstPasNul();
	}

	private final T valeur;
}

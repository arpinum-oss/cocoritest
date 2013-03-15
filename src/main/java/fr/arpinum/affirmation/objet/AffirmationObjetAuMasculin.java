package fr.arpinum.affirmation.objet;

public class AffirmationObjetAuMasculin<T> extends AffirmationObjet<T> {

	public AffirmationObjetAuMasculin(T valeur) {
		super(valeur);
	}

	public void estNul() {
		est(null);
	}

	public void nEstPasNul() {
		nEstPas(null);
	}
}

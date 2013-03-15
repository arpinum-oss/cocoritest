package fr.arpinum.affirmation.objet;

public class AffirmationObjetAuFeminin<T> extends AffirmationObjet<T> {

	public AffirmationObjetAuFeminin(T valeur) {
		super(valeur);
	}

	public void estNulle() {
		est(null);
	}
}

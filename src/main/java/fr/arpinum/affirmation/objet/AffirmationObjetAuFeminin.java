package fr.arpinum.affirmation.objet;

public interface AffirmationObjetAuFeminin<T> {

	void est(T valeurAttendue);

	void nEstPas(T valeurAttendue);

	void estNulle();

	void nEstPasNulle();
}

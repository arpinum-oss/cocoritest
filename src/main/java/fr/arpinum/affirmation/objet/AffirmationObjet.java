package fr.arpinum.affirmation.objet;

public interface AffirmationObjet<T> {

	void est(T valeurAttendue);

	void nEstPas(T valeurAttendue);

	void estNul();

	void nEstPasNul();
}

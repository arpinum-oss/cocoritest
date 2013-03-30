package fr.arpinum.affirmation.objet;

public interface AffirmationObjetAuFeminin<T> {

	/**
	 * Affirme que la valeur est la valeur attendue.
	 *
	 * @param valeurAttendue la valeur attendue.
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void est(T valeurAttendue);

	/**
	 * Affirme que la valeur n'est pas la valeur attendue.
	 *
	 * @param valeurNonAttendue la valeur non attendue.
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void nEstPas(T valeurNonAttendue);

	/**
	 * Affirme que la valeur est nulle.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estNulle();

	/**
	 * Affirme que la valeur n'est pas nulle.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void nEstPasNulle();
}

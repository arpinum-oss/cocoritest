package fr.arpinum.affirmation.booleene;

public interface AffirmationBooleene {

	/**
	 * Affirme que c'est vrai.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estVrai();

	/**
	 * Affirme que c'est faux.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estFaux();
}

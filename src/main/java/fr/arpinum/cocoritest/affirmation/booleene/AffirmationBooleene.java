package fr.arpinum.cocoritest.affirmation.booleene;

public interface AffirmationBooleene {

	/**
	 * Affirme que c'est vrai.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estVrai();

	/**
	 * Affirme que c'est faux.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estFaux();
}

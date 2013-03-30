package fr.arpinum.affirmation.booleene;

public interface AffirmationBooleeneAuFeminin {

	/**
	 * Affirme que c'est vrai.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estVraie();

	/**
	 * Affirme que c'est faux.
	 *
	 * @throws fr.arpinum.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estFausse();
}

package fr.arpinum.cocoritest.affirmation.booleene;

public interface AffirmationBooleeneAuFeminin {

	/**
	 * Affirme que c'est vrai.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estVraie();

	/**
	 * Affirme que c'est faux.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estFausse();
}

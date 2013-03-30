package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

public interface AffirmationCollection<T> {

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void sont(Collection<T> élémentsAttendus);

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void sont(T... élémentsAttendus);

	/**
	 * Affirme les éléments sont au nombre voulu.
	 *
	 * @param nombre le nombre voulu d'éléments.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void sontAuNombreDe(int nombre);

	/**
	 * Affirme qu'aucun élément n'existe.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void nExistentPas();

	/**
	 * Affirme que les éléments ont les éléments attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void ont(Collection<T> élémentsAttendus);


	/**
	 * Affirme que les éléments ont les éléments attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void ont(T... élémentsAttendus);
}

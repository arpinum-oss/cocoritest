package fr.arpinum.cocoritest.affirmation.objet;

import fr.arpinum.cocoritest.specification.Specification;

/**
 * Représente une affirmation concernant un objet typé.
 *
 * @param <T> le type de l'objet concerné par l'affirmation.
 */
public interface AffirmationObjet<T> {

	/**
	 * Affirme que l'objet est celui attendu.
	 *
	 * @param objetAttendu l'objet attendu.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void est(T objetAttendu);

	/**
	 * Affirme que l'objet n'est pas celui attendu.
	 *
	 * @param objetNonAttendu l'objet non attendu.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void nEstPas(T objetNonAttendu);

	/**
	 * Affirme que l'objet est nul.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void estNul();

	/**
	 * Affirme que l'objet n'est pas nul.
	 *
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void nEstPasNul();

	/**
	 * Affirme que l'objet respecte la spécification.
	 *
	 * @param spécification la spécification à respecter.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void respecte(Specification<T> spécification);
}

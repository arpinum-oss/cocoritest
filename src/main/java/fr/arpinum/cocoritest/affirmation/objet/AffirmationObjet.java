/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest.affirmation.objet;

import fr.arpinum.cocoritest.conjonction.Conjonction;
import fr.arpinum.cocoritest.specification.Specification;

/**
 * Représente une affirmation concernant un objet typé.
 *
 * @param <TObjet>       le type de l'objet concerné par l'affirmation.
 * @param <TConjonction> le type de conjonction utilisé pour chaîner les affirmations.
 */
public interface AffirmationObjet<TObjet, TConjonction extends Conjonction<? extends AffirmationObjet<TObjet,
		? extends TConjonction>>> {

	/**
	 * Affirme que l'objet est celui attendu.
	 *
	 * @param objetAttendu l'objet attendu.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	TConjonction est(TObjet objetAttendu);

	/**
	 * Affirme que l'objet n'est pas celui attendu.
	 *
	 * @param objetNonAttendu l'objet non attendu.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	TConjonction nEstPas(TObjet objetNonAttendu);

	/**
	 * Affirme que l'objet respecte la spécification.
	 *
	 * @param spécification la spécification à respecter.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	TConjonction respecte(Specification<TObjet> spécification);
}

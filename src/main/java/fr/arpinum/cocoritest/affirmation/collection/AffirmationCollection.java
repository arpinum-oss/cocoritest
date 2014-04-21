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

package fr.arpinum.cocoritest.affirmation.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.conjonction.Conjonction;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;

/**
 * Représente une affirmation concernant une collection typée.
 *
 * @param <TElement> le type des éléments de la collection concernée par l'affirmation.
 */
public interface AffirmationCollection<TElement> {

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> sont(Collection<TElement> élémentsAttendus);

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	@SuppressWarnings("unchecked")
	default Conjonction<AffirmationCollection<TElement>> sont(TElement... élémentsAttendus) {
		return sont(Listes.cree(élémentsAttendus));
	}

	/**
	 * Affirme les éléments sont au nombre voulu.
	 *
	 * @param nombre le nombre voulu d'éléments.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> sontAuNombreDe(int nombre);

	/**
	 * Affirme qu'au moins un élément existe.
	 *
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> existent();

	/**
	 * Affirme qu'aucun élément n'existe.
	 *
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> nExistentPas();

	/**
	 * Affirme que les éléments ont les éléments attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> ont(Collection<TElement> élémentsAttendus);

	/**
	 * Affirme que les éléments ont les éléments attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	@SuppressWarnings("unchecked")
	default Conjonction<AffirmationCollection<TElement>> ont(TElement... élémentsAttendus) {
		return ont(Listes.cree(élémentsAttendus));
	}

	/**
	 * Affirme que les éléments respectent la spécification.
	 *
	 * @param spécification la spécification à respecter.
	 * @return une conjonction pour chaîner d'autres affirmations
	 * @throws fr.arpinum.cocoritest.interne.affirmation.ExceptionAffirmation si l'affirmation est erronée.
	 */
	Conjonction<AffirmationCollection<TElement>> respectent(Specification<Collection<TElement>> spécification);
}

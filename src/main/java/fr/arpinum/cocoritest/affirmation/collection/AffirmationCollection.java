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

import fr.arpinum.cocoritest.specification.Specification;

/**
 * Représente une affirmation concernant une collection typée.
 *
 * @param <E> le type des éléments de la collection concernée par l'affirmation.
 */
public interface AffirmationCollection<E> {

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void sont(Collection<E> élémentsAttendus);

	/**
	 * Affirme que les éléments sont ceux attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void sont(E... élémentsAttendus);

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
	void ont(Collection<E> élémentsAttendus);


	/**
	 * Affirme que les éléments ont les éléments attendus.
	 *
	 * @param élémentsAttendus les éléments attendus.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void ont(E... élémentsAttendus);

	/**
	 * Affirme que les éléments respectent la spécification.
	 *
	 * @param spécification la spécification à respecter.
	 * @throws fr.arpinum.cocoritest.affirmation.ExceptionAffirmation
	 *          si l'affirmation est erronée.
	 */
	void respectent(Specification<Collection<E>> spécification);
}

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

package fr.arpinum.cocoritest.specification.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.extensionlangage.Collections;
import fr.arpinum.cocoritest.specification.Specification;

public class SpecificationCollection<E> implements Specification<Collection<E>> {

	public SpecificationCollection(Collection<E> élémentsSpécifiés) {
		this.collectionSpécifiée = élémentsSpécifiés;
	}

	@Override
	public boolean estInsatisfaitePar(Collection<E> éléments) {
		return !Collections.egales(collectionSpécifiée, éléments);
	}

	@Override
	public String messageInsatisfactionPour(Collection<E> éléments) {
		return String.format("Les éléments sont <%s> au lieu de <%s>.", éléments, collectionSpécifiée);
	}

	private final Collection<E> collectionSpécifiée;
}

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

package fr.arpinum.cocoritest.interne.affirmation.collection;

import java.util.Collection;

import fr.arpinum.cocoritest.interne.affirmation.Affirmation;
import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationCollection;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationCollectionNonVide;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationElementsDansLaCollection;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationTailleDeCollection;
import fr.arpinum.cocoritest.specification.Specification;

public class AffirmationCollectionDeBase<E> extends Affirmation implements AffirmationCollection<E> {

	public AffirmationCollectionDeBase(Collection<E> éléments) {
		this.éléments = éléments;
	}

	@Override
	public void sont(Collection<E> élémentsAttendus) {
		respectent(new SpecificationCollection<E>(élémentsAttendus));
	}

	@Override
	public void sont(E... élémentsAttendus) {
		sont(Listes.cree(élémentsAttendus));
	}

	@Override
	public void sontAuNombreDe(int nombre) {
		respectent(new SpecificationTailleDeCollection<E>(nombre));
	}

	@Override
	public void existent() {
		respectent(new SpecificationCollectionNonVide<E>());
	}

	@Override
	public void nExistentPas() {
		sontAuNombreDe(0);
	}

	@Override
	public void ont(Collection<E> élémentsAttendus) {
		respectent(new SpecificationElementsDansLaCollection<E>(élémentsAttendus));
	}

	@Override
	public void ont(E... élémentsAttendus) {
		ont(Listes.cree(élémentsAttendus));
	}

	@Override
	public void respectent(Specification<Collection<E>> spécification) {
		if (spécification.estInsatisfaitePar(éléments)) {
			échoue(spécification.messageInsatisfactionPour(éléments));
		}
	}

	private final Collection<E> éléments;
}

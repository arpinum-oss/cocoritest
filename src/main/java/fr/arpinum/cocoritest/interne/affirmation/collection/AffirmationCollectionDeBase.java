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

import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollection;
import fr.arpinum.cocoritest.conjonction.collection.ConjonctionCollection;
import fr.arpinum.cocoritest.interne.affirmation.Affirmation;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationCollection;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationCollectionNonVide;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationElementsDansLaCollection;
import fr.arpinum.cocoritest.interne.specification.collection.SpecificationTailleDeCollection;
import fr.arpinum.cocoritest.specification.Specification;

public class AffirmationCollectionDeBase<TElement> extends Affirmation implements AffirmationCollection<TElement> {

	public AffirmationCollectionDeBase(Collection<TElement> éléments) {
		this.éléments = éléments;
	}

	@Override
	public ConjonctionCollection<TElement> sont(Collection<TElement> élémentsAttendus) {
		return respectent(new SpecificationCollection<>(élémentsAttendus));
	}

	@Override
	public ConjonctionCollection<TElement> sontAuNombreDe(int nombre) {
		return respectent(new SpecificationTailleDeCollection<>(nombre));
	}

	@Override
	public ConjonctionCollection<TElement> existent() {
		return respectent(new SpecificationCollectionNonVide<>());
	}

	@Override
	public ConjonctionCollection<TElement> nExistentPas() {
		return sontAuNombreDe(0);
	}

	@Override
	public ConjonctionCollection<TElement> ont(Collection<TElement> élémentsAttendus) {
		return respectent(new SpecificationElementsDansLaCollection<>(élémentsAttendus));
	}

	@Override
	public ConjonctionCollection<TElement> respectent(Specification<Collection<TElement>> spécification) {
		échoueSiSpécificationInsatisfaite(spécification);
		return () -> this;
	}

	private void échoueSiSpécificationInsatisfaite(Specification<Collection<TElement>> spécification) {
		if (spécification.estInsatisfaitePar(éléments)) {
			échoue(spécification.messageInsatisfactionPour(éléments));
		}
	}

	private final Collection<TElement> éléments;
}

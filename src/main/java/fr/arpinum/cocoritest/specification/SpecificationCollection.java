package fr.arpinum.cocoritest.specification;

import java.util.Collection;

import fr.arpinum.cocoritest.outils.Collections;

public class SpecificationCollection<E> implements Specification<Collection<E>> {

	public SpecificationCollection(Collection<E> élémentsSpécifiés) {
		this.collectionSpécifiée = élémentsSpécifiés;
	}

	@Override
	public boolean estSatisfaitePar(Collection<E> éléments) {
		return Collections.egales(collectionSpécifiée, éléments);
	}

	@Override
	public String messageInsatisfactionPour(Collection<E> éléments) {
		return String.format("Les éléments sont %s et non %s.", éléments, collectionSpécifiée);
	}

	private final Collection<E> collectionSpécifiée;
}

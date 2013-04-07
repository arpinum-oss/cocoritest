package fr.arpinum.cocoritest.specification;

import java.util.Collection;

import fr.arpinum.cocoritest.outils.Collections;

public class SpecificationCollection<E, T extends Collection<E>> implements Specification<T> {

	public SpecificationCollection(T élémentsSpécifiés) {
		this.collectionSpécifiée = élémentsSpécifiés;
	}

	@Override
	public boolean estSatisfaitePar(T éléments) {
		return Collections.egales(collectionSpécifiée, éléments);
	}

	@Override
	public String messageInsatisfactionPour(T éléments) {
		return String.format("Les éléments sont %s et non %s.", éléments, collectionSpécifiée);
	}

	private final T collectionSpécifiée;
}

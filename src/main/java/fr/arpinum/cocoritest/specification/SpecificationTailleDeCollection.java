package fr.arpinum.cocoritest.specification;

import java.util.Collection;

public class SpecificationTailleDeCollection<E> implements Specification<Collection<E>> {

	public SpecificationTailleDeCollection(int tailleSpécifiée) {
		this.tailleSpécifiée = tailleSpécifiée;
	}

	@Override
	public boolean estSatisfaitePar(Collection<E> éléments) {
		return éléments.size() == tailleSpécifiée;
	}

	@Override
	public String messageInsatisfactionPour(Collection<E> éléments) {
		return String.format("Les éléments sont au nombre de %s et non %s.", éléments.size(), tailleSpécifiée);
	}

	private final int tailleSpécifiée;
}

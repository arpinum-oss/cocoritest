package fr.arpinum.cocoritest.specification;

import java.util.Collection;

public class SpecificationTailleDeCollection<E, T extends Collection<E>> implements Specification<T> {

	public SpecificationTailleDeCollection(int tailleSpécifiée) {
		this.tailleSpécifiée = tailleSpécifiée;
	}

	@Override
	public boolean estSatisfaitePar(T éléments) {
		return éléments.size() == tailleSpécifiée;
	}

	@Override
	public String messageInsatisfactionPour(T éléments) {
		return String.format("Les éléments sont au nombre de %s et non %s.", éléments.size(), tailleSpécifiée);
	}

	private int tailleSpécifiée;
}

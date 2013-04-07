package fr.arpinum.cocoritest.specification;

import java.util.Collection;

public class SpecificationElementsDansLaCollection<E> implements Specification<Collection<E>> {

	public SpecificationElementsDansLaCollection(Collection<E> élémentsSpécifiés) {
		this.élémentsSpécifiés = élémentsSpécifiés;
	}

	@Override
	public boolean estSatisfaitePar(Collection<E> éléments) {
		return éléments.containsAll(élémentsSpécifiés);
	}

	@Override
	public String messageInsatisfactionPour(Collection<E> éléments) {
		return String.format("%s ne sont pas présents dans %s.", élémentsSpécifiés, éléments);
	}

	private final Collection<E> élémentsSpécifiés;
}

package fr.arpinum.cocoritest.specification;

import java.util.Collection;

public class SpecificationElementsDansLaCollection<E, T extends Collection<E>> implements Specification<T> {

	public SpecificationElementsDansLaCollection(T élémentsSpécifiés) {
		this.élémentsSpécifiés = élémentsSpécifiés;
	}

	@Override
	public boolean estSatisfaitePar(T éléments) {
		return éléments.containsAll(élémentsSpécifiés);
	}

	@Override
	public String messageInsatisfactionPour(T éléments) {
		return String.format("%s ne sont pas présents dans %s.", élémentsSpécifiés, éléments);
	}

	private final T élémentsSpécifiés;
}

package fr.arpinum.cocoritest.specification;

import fr.arpinum.cocoritest.outils.Objets;

public class SpecificationObjetsDifferents<T> implements Specification<T> {

	public SpecificationObjetsDifferents(T objetSpécifié) {
		this.objetSpécifié = objetSpécifié;
	}

	@Override
	public boolean estSatisfaitPar(T objet) {
		return Objets.différents(objetSpécifié, objet);
	}

	@Override
	public String messageInsatisfactionPour(T objet) {
		return String.format("La valeur est %s alors que ce n'était pas voulu.", objet);
	}

	private T objetSpécifié;
}

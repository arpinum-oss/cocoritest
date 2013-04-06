package fr.arpinum.cocoritest.specification;

import fr.arpinum.cocoritest.outils.Objets;

public class SpecificationObjetsEgaux<T> implements Specification<T> {

	public SpecificationObjetsEgaux(T objetSpécifié) {
		this.objetSpécifié = objetSpécifié;
	}

	@Override
	public boolean estSatisfaitPar(T objet) {
		return Objets.egaux(objetSpécifié, objet);
	}

	@Override
	public String messageInsatisfactionPour(T objet) {
		return String.format("La valeur est %s et non %s.", objetSpécifié, objet);
	}

	private T objetSpécifié;
}

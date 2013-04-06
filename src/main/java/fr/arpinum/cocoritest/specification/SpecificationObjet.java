package fr.arpinum.cocoritest.specification;

import fr.arpinum.cocoritest.outils.Objets;

public class SpecificationObjet<T> implements Specification<T> {

	public SpecificationObjet(T objetSpécifié) {
		this.objetSpécifié = objetSpécifié;
	}

	@Override
	public boolean estSatisfaitePar(T objet) {
		return Objets.egaux(objetSpécifié, objet);
	}

	@Override
	public String messageInsatisfactionPour(T objet) {
		return String.format("L'objet est %s au lieu de %s.", Objets.enChaîne(objet), Objets.enChaîne(objetSpécifié));
	}

	private final T objetSpécifié;
}

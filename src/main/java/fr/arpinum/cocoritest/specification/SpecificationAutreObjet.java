package fr.arpinum.cocoritest.specification;

import fr.arpinum.cocoritest.outils.Objets;

public class SpecificationAutreObjet<T> implements Specification<T> {

	public SpecificationAutreObjet(T objetSpécifié) {
		this.objetSpécifié = objetSpécifié;
	}

	@Override
	public boolean estSatisfaitePar(T objet) {
		return Objets.différents(objetSpécifié, objet);
	}

	@Override
	public String messageInsatisfactionPour(T objet) {
		return String.format("L'objet est %s alors que ce n'était pas voulu.", Objets.enChaîne(objet));
	}

	private final T objetSpécifié;
}

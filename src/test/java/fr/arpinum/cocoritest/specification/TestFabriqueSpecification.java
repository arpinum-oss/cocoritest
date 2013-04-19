package fr.arpinum.cocoritest.specification;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import org.junit.Before;
import org.junit.Test;

public class TestFabriqueSpecification {

	@Before
	public void avantChaqueTest() {
		fabrique = new FabriqueSpecification();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void laFabriquePeutCombinerPlusieursSpécifications() {
		Specification<String> spécificationCréée = fabrique.combine(créeContient(""), créeContient(""));

		alors().la(spécificationCréée).nEstPasNulle();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void uneSpécificationCombinéeEstInsatisfaiteSiUneSpécificationDeSaCombinaisonEstInsatisfaite() {
		Specification<String> spécificationCréée = fabrique.combine(créeContient("a"), créeContient("b"));

		alors().ceci(spécificationCréée.estInsatisfaitePar("aaeeeeaa")).estVrai();
		alors().ceci(spécificationCréée.estInsatisfaitePar("bbeeeebb")).estVrai();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void uneSpécificatonCombinéeALeMessageDInsatisfactionDeLaPremiereInsatisfaiteDeSaCombinaison() {
		Specification<String> spécificationCréée = fabrique.combine(créeContient("a"), créeContient("b"));

		alors().le(spécificationCréée.messageInsatisfactionPour("b")).est("ne contient pas a");
		alors().le(spécificationCréée.messageInsatisfactionPour("a")).est("ne contient pas b");
		alors().le(spécificationCréée.messageInsatisfactionPour("e")).est("ne contient pas a");
	}

	private Specification<String> créeContient(final String chaîneContenue) {
		return new Specification<String>() {
			@Override
			public boolean estInsatisfaitePar(String chaîne) {
				return !chaîne.contains(chaîneContenue);
			}

			@Override
			public String messageInsatisfactionPour(String chaîne) {
				return "ne contient pas " + chaîneContenue;
			}
		};
	}

	private FabriqueSpecification fabrique;
}

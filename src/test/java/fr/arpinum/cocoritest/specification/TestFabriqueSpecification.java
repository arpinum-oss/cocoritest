package fr.arpinum.cocoritest.specification;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.outils.Listes;

public class TestFabriqueSpecification {

	@Before
	public void avantChaqueTest() {
		fabrique = new FabriqueSpecification();
	}

	@Test
	public void laFabriquePeutCombinerPlusieursSpécifications() {
		Specification<String> spécificationCréée = fabrique.combine(Listes.cree(créeContient(""), créeContient("")));

		alors().la(spécificationCréée).nEstPasNulle();
	}

	@Test
	public void uneSpécificationCombinéeEstInsatisfaiteSiUneSpécificationDeSaCombinaisonEstInsatisfaite() {
		Specification<String> spécificationCréée = fabrique.combine(Listes.cree(créeContient("a"), créeContient("b")));

		alors().ceci(spécificationCréée.estInsatisfaitePar("aaeeeeaa")).estVrai();
		alors().ceci(spécificationCréée.estInsatisfaitePar("bbeeeebb")).estVrai();
	}

	@Test
	public void uneSpécificatonCombinéeALeMessageDInsatisfactionDeLaPremiereInsatisfaiteDeSaCombinaison() {
		Specification<String> spécificationCréée = fabrique.combine(Listes.cree(créeContient("a"), créeContient("b")));

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

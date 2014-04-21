package fr.arpinum.cocoritest.specification;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Test;

import fr.arpinum.cocoritest.Outils;
import fr.arpinum.cocoritest.exception.CapteurException;

public class TestSpecification {

	@Test
	public void uneSpécificationPeutEtreCombinéeAvecUneAutre() {
		Specification<String> spécificationCréée = créeContient("").et(créeContient(""));

		alors().la(spécificationCréée).nEstPasNulle();
	}

	@Test
	public void impossibleDeCombinerUneSpécificationAvecUneNulle() {
		CapteurException capteur = Outils.créeCapteur();
		Specification<String> spécification = (chaîne) -> true;

		Exception exceptionCaptée = capteur.capte(() -> spécification.et(null));

		alors().cette(exceptionCaptée).respecte(avecMessage("L'autre spécification ne doit pas être nulle."));
	}

	private static Specification<Exception> avecMessage(String message) {
		return (exception) -> exception.getMessage().equals(message);
	}

	@Test
	public void uneSpécificationCombinéeEstInsatisfaiteSiUneSpécificationDeSaCombinaisonEstInsatisfaite() {
		Specification<String> spécificationCréée = créeContient("a").et(créeContient("b"));

		alors().ceci(!spécificationCréée.estSatisfaitePar("aaeeeeaa")).estVrai();
		alors().ceci(!spécificationCréée.estSatisfaitePar("bbeeeebb")).estVrai();
	}

	@Test
	public void uneSpécificatonCombinéeALeMessageDInsatisfactionDeLaPremiereInsatisfaiteDeSaCombinaison() {
		Specification<String> spécificationCréée = créeContient("a").et(créeContient("b"));

		alors().ceci(spécificationCréée.messageInsatisfactionPour("b")).est("ne contient pas a");
		alors().ceci(spécificationCréée.messageInsatisfactionPour("a")).est("ne contient pas b");
		alors().ceci(spécificationCréée.messageInsatisfactionPour("e")).est("ne contient pas a");
	}

	private Specification<String> créeContient(final String chaîneContenue) {
		return new Specification<String>() {
			@Override
			public boolean estSatisfaitePar(String chaîne) {
				return chaîne.contains(chaîneContenue);
			}

			@Override
			public String messageInsatisfactionPour(String chaîne) {
				return "ne contient pas " + chaîneContenue;
			}
		};
	}
}

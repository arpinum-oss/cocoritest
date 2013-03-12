package fr.arpinum;

import static fr.arpinum.Affirmations.*;

import org.junit.Test;

public class TestAffirmations {

	@Test
	public void peutConstruireLesDifférentesAffirmations() {
		alors(booléen).estVrai();
		alors(nombre).est(3);
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuMasculin() {
		alorsLe(booléen).estVrai();
		alorsLe(nombre).est(3);
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuFéminin() {
		alorsLa(valeurBooléene).estVraie();
		alorsLa(valeurDuNombre).est(3);
	}

	private final boolean booléen = true;
	private final boolean valeurBooléene = true;
	private final int nombre = 3;
	private final int valeurDuNombre = 3;
}

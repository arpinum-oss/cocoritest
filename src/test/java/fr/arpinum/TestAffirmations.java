package fr.arpinum;

import static fr.arpinum.Affirmations.*;

import java.util.List;

import org.junit.Test;

import fr.arpinum.outil.Listes;

public class TestAffirmations {

	@Test
	public void peutConstruireLesDifférentesAffirmations() {
		alors(booléen).estVrai();
		alors(nombre).est(3);
		alors(nombres).sont(Listes.cree(1, 5));
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

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alorsLes(nombres).sont(Listes.cree(1, 5));
	}

	private final boolean booléen = true;
	private final boolean valeurBooléene = true;
	private final int nombre = 3;
	private final int valeurDuNombre = 3;
	private List<Integer> nombres = Listes.cree(1, 5);
}

package fr.arpinum.affirmation;

import static fr.arpinum.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.outils.Listes;

public class TestAffirmations {

	@Before
	public void avantChaqueTest() {
		booléen = true;
		valeurVraie = true;
		valeurNulle = null;
		champNul = null;
		nombre = 3;
		valeurDuNombre = 3;
		nombres = Listes.cree(1, 5);
	}

	@Test
	public void peutConstruireLesDifférentesAffirmations() {
		alors(booléen).estVrai();
		alors(nombre).est(3);
		alors(nombre).nEstPas(4);
		alors(nombres).sont(Listes.cree(1, 5));
		alors(champNul).estNul();
		alors(nombre).nEstPasNul();
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuMasculin() {
		alorsLe(booléen).estVrai();
		alorsLe(nombre).est(3);
		alorsLe(nombre).nEstPas(4);
		alorsLe(nombre).nEstPasNul();
		alorsLe(champNul).estNul();
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuFéminin() {
		alorsLa(valeurVraie).estVraie();
		alorsLa(valeurDuNombre).est(3);
		alorsLa(valeurDuNombre).nEstPas(4);
		alorsLa(valeurNulle).estNulle();
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alorsLes(nombres).sont(Listes.cree(1, 5));
		alorsLes(nombres).sontAuNombreDe(2);
	}

	private boolean booléen = true;
	private boolean valeurVraie = true;
	private int nombre = 3;
	private int valeurDuNombre = 3;
	private List<Integer> nombres = Listes.cree(1, 5);
	private Object valeurNulle;
	private Object champNul;
}

package fr.arpinum.affirmation;

import static fr.arpinum.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.outils.Listes;

public class TestAffirmations {

	@Before
	public void avantChaqueTest() {
		résultat = true;
		mensonge = false;
		vérité = true;
		nombre = 3;
		valeur = 3;
		nombres = Listes.cree(1, 5);
		réponse = null;
		champ = null;
		trahison = false;
		remarque = false;
	}

	@Test
	public void peutConstruireLesDifférentesAffirmations() {
		alors(résultat).estVrai();
		alors(mensonge).estFaux();
		alors(nombre).est(3);
		alors(nombre).nEstPas(4);
		alors(nombres).sont(Listes.cree(1, 5));
		alors(champ).estNul();
		alors(nombre).nEstPasNul();
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuMasculin() {
		alorsLe(résultat).estVrai();
		alorsLe(mensonge).estFaux();
		alorsLe(nombre).est(3);
		alorsLe(nombre).nEstPas(4);
		alorsLe(champ).estNul();
		alorsLe(nombre).nEstPasNul();
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuFéminin() {
		alorsLa(vérité).estVraie();
		alorsLa(trahison).estFausse();
		alorsLa(valeur).est(3);
		alorsLa(valeur).nEstPas(4);
		alorsLa(réponse).estNulle();
		alorsLa(remarque).nEstPasNulle();
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alorsLes(nombres).sont(Listes.cree(1, 5));
		alorsLes(nombres).sont(1, 5);
		alorsLes(nombres).sontAuNombreDe(2);
	}

	private boolean résultat;
	private boolean mensonge;
	private boolean vérité;
	private boolean trahison;
	private int nombre;
	private int valeur;
	private List<Integer> nombres;
	private Object réponse;
	private Object remarque;
	private Object champ;
}

package fr.arpinum.cocoritest.affirmation;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.outils.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmations {

	@Before
	public void avantChaqueTest() {
		résultat = état = vérité = estimation = true;
		mensonge = trahison = false;
		nombre = valeur = 3;
		adverbe = annonce = "tellement";
		nombres = Listes.cree(1, 5, 12);
		valeurs = Listes.cree();
		réponse = champ = null;
		remarque = new Object();
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuMasculin() {
		alorsLe(résultat).estVrai();
		alorsLe(mensonge).estFaux();
		alorsLe(nombre).est(3);
		alorsLe(nombre).nEstPas(4);
		alorsLe(champ).estNul();
		alorsLe(nombre).nEstPasNul();
		alorsLe(nombre).respecte(laSpécification());
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuFéminin() {
		alorsLa(vérité).estVraie();
		alorsLa(trahison).estFausse();
		alorsLa(valeur).est(3);
		alorsLa(valeur).nEstPas(4);
		alorsLa(réponse).estNulle();
		alorsLa(remarque).nEstPasNulle();
		alorsLa(valeur).respecte(laSpécification());
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsPourLesMotsCommençantParUneVoyelle() {
		alorsCet(état).estVrai();
		alorsCette(estimation).estVraie();
		alorsCet(adverbe).est("tellement");
		alorsCette(annonce).est("tellement");
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alorsLes(nombres).sont(Listes.cree(1, 5, 12));
		alorsLes(nombres).sont(1, 5, 12);
		alorsLes(nombres).sontAuNombreDe(3);
		alorsLes(nombres).ont(1, 12);
		alorsLes(nombres).ont(Listes.cree(1, 12));
		alorsLes(valeurs).nExistentPas();
		alorsLes(nombres).respectent(laSpécificationDeCollection());
	}

	private static Specification<Integer> laSpécification() {
		return new Specification<Integer>() {
			@Override
			public boolean estSatisfaitePar(Integer objet) {
				return true;
			}

			@Override
			public String messageInsatisfactionPour(Integer objet) {
				return null;
			}
		};
	}

	private static Specification<Collection<Integer>> laSpécificationDeCollection() {
		return new Specification<Collection<Integer>>() {
			@Override
			public boolean estSatisfaitePar(Collection<Integer> objet) {
				return true;
			}

			@Override
			public String messageInsatisfactionPour(Collection<Integer> objet) {
				return null;
			}
		};
	}

	private boolean résultat;
	private boolean état;
	private boolean mensonge;
	private boolean vérité;
	private boolean estimation;
	private boolean trahison;
	private int nombre;
	private String adverbe;
	private int valeur;
	private String annonce;
	private List<Integer> nombres;
	private List<String> valeurs;
	private Object réponse;
	private Object remarque;
	private Object champ;
}

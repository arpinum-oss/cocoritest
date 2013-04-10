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
		alors().le(résultat).estVrai();
		alors().le(mensonge).estFaux();
		alors().le(nombre).est(3);
		alors().le(nombre).nEstPas(4);
		alors().le(champ).estNul();
		alors().le(nombre).nEstPasNul();
		alors().le(nombre).respecte(laSpécification());
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsAuFéminin() {
		alors().la(vérité).estVraie();
		alors().la(trahison).estFausse();
		alors().la(valeur).est(3);
		alors().la(valeur).nEstPas(4);
		alors().la(réponse).estNulle();
		alors().la(remarque).nEstPasNulle();
		alors().la(valeur).respecte(laSpécification());
	}

	@Test
	public void peutConstruireLesDifférentesAffirmationsPourLesMotsCommençantParUneVoyelle() {
		alors().cet(état).estVrai();
		alors().cette(estimation).estVraie();
		alors().cet(adverbe).est("tellement");
		alors().cette(annonce).est("tellement");
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alors().les(nombres).sont(Listes.cree(1, 5, 12));
		alors().les(nombres).sont(1, 5, 12);
		alors().les(nombres).sontAuNombreDe(3);
		alors().les(nombres).ont(1, 12);
		alors().les(nombres).ont(Listes.cree(1, 12));
		alors().les(valeurs).nExistentPas();
		alors().les(nombres).respectent(laSpécificationDeCollection());
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
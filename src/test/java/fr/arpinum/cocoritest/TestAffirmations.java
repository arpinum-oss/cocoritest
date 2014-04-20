/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest;

import static fr.arpinum.cocoritest.Affirmations.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
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
		données = new Object[]{};
		réponse = champ = null;
		remarque = new Object();
	}

	@Test
	public void peutCréerLesDifférentesAffirmationsAuMasculin() {
		alors().le(résultat).estVrai();
		alors().le(mensonge).estFaux();
		alors().le(nombre).est(3);
		alors().le(nombre).nEstPas(4);
		alors().le(champ).estNul();
		alors().le(nombre).nEstPasNul();
		alors().le(nombre).respecte(laSpécification());
	}

	@Test
	public void peutCréerLesDifférentesAffirmationsAuFéminin() {
		alors().la(vérité).estVraie();
		alors().la(trahison).estFausse();
		alors().la(valeur).est(3);
		alors().la(valeur).nEstPas(4);
		alors().la(réponse).estNulle();
		alors().la(remarque).nEstPasNulle();
		alors().la(valeur).respecte(laSpécification());
	}

	@Test
	public void peutCréerLesDifférentesAffirmationsPourLesMotsCommençantParUneVoyelle() {
		alors().cet(état).estVrai();
		alors().cette(estimation).estVraie();
		alors().cet(adverbe).est("tellement");
		alors().cette(annonce).est("tellement");
	}

	@Test
	public void peutCréerDesAffirmationsAuMasculinPourDesInstructionsEntieres() {
		alors().ceci(new ClasseInterne().getRésultat()).estVrai();
		alors().ceci(new ClasseInterne().getMessage()).est("message");
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alors().les(nombres).sont(Listes.cree(1, 5, 12));
		alors().les(nombres).sont(1, 5, 12);
		alors().les(nombres).sontAuNombreDe(3);
		alors().les(nombres).ont(1, 12);
		alors().les(nombres).ont(Listes.cree(1, 12));
		alors().les(nombres).existent();
		alors().les(valeurs).nExistentPas();
		alors().les(nombres).respectent(laSpécificationDeCollection());
	}

	@Test
	public void peutCréerLesAffirmationsAuPlurielPourUnTableau() {
		alors().les(données).nExistentPas();
	}

	private static Specification<Integer> laSpécification() {
		return new Specification<Integer>() {
			@Override
			public boolean estInsatisfaitePar(Integer objet) {
				return false;
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
			public boolean estInsatisfaitePar(Collection<Integer> objet) {
				return false;
			}

			@Override
			public String messageInsatisfactionPour(Collection<Integer> objet) {
				return null;
			}
		};
	}

	@SuppressWarnings("ALL")
	private class ClasseInterne {

		private boolean getRésultat() {
			return true;
		}

		private String getMessage() {
			return "message";
		}
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
	private Object[] données;
	private Object réponse;
	private Object remarque;
	private Object champ;
}

/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITE ni d'ADEQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest;

import static fr.arpinum.cocoritest.Affirmations.*;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import fr.arpinum.cocoritest.interne.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestAffirmations {

	@Test
	public void peutCréerLesDifférentesAffirmationsAuMasculin() {
		alors().le(RESULTAT).estVrai();
		alors().le(RESULTAT_BOOLEAN).estVrai();
		alors().le(MENSONGE).estFaux();
		alors().le(NOMBRE).est(3).et().nEstPasNul();
		alors().le(NOMBRE).nEstPas(4);
		alors().le(CHAMP).estNul();
		alors().le(NOMBRE).nEstPasNul();
		alors().le(NOMBRE).respecte(laSpécification());
	}

	@Test
	public void peutCréerLesDifférentesAffirmationsAuFéminin() {
		alors().la(VERITE).estVraie();
		alors().la(VERITE_BOOLEAN).estVraie();
		alors().la(TRAHISON).estFausse();
		alors().la(VALEUR).est(3).et().nEstPasNulle();
		alors().la(VALEUR).nEstPas(4);
		alors().la(REPONSE).estNulle();
		alors().la(REMARQUE).nEstPasNulle();
		alors().la(VALEUR).respecte(laSpécification());
	}

	@Test
	public void peutCréerLesDifférentesAffirmationsPourLesMotsCommençantParUneVoyelle() {
		alors().cet(ETAT).estVrai();
		alors().cet(ETAT_BOOLEAN).estVrai();
		alors().cette(ESTIMATION).estVraie();
		alors().cette(ESTIMATION_BOOLEAN).estVraie();
		alors().cet(ADVERBE).est("tellement");
		alors().cette(ANNONCE).est("tellement");
	}

	@Test
	public void peutCréerDesAffirmationsAuMasculinPourDesInstructionsEntieres() {
		alors().ceci(new ClasseInterne().getRésultat()).estVrai();
		alors().ceci(Boolean.TRUE).estVrai();
		alors().ceci(new ClasseInterne().getMessage()).est("message");
	}

	@Test
	public void peutConstrureLesDifférentesAffirmationsAuPluriel() {
		alors().les(NOMBRES).sont(Listes.cree(1, 5, 12));
		alors().les(NOMBRES).sont(1, 5, 12);
		alors().les(NOMBRES).sontAuNombreDe(3);
		alors().les(NOMBRES).ont(1, 12).et().ont(5);
		alors().les(NOMBRES).ont(Listes.cree(1, 12));
		alors().les(NOMBRES).existent();
		alors().les(VALEURS).nExistentPas();
		alors().les(NOMBRES).respectent(laSpécificationDeCollection());
	}

	@Test
	public void peutCréerLesAffirmationsAuPlurielPourUnTableau() {
		alors().les(DONNEES_ABSENTES).nExistentPas();
		alors().les(DONNEES_PRESENTES).existent();
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

	private static final boolean RESULTAT = true;
	private static final Boolean RESULTAT_BOOLEAN = true;
	private static final boolean ETAT = true;
	private static final Boolean ETAT_BOOLEAN = true;
	private static final boolean VERITE = true;
	private static final Boolean VERITE_BOOLEAN = true;
	private static final boolean ESTIMATION = true;
	private static final Boolean ESTIMATION_BOOLEAN = true;
	private static final boolean MENSONGE = false;
	private static final boolean TRAHISON = false;
	private static final int NOMBRE = 3;
	private static final int VALEUR = 3;
	private static final String ADVERBE = "tellement";
	private static final String ANNONCE = "tellement";
	private static final List<Integer> NOMBRES = Listes.cree(1, 5, 12);
	private static final List<String> VALEURS = Listes.cree();
	private static final Object[] DONNEES_ABSENTES = new Object[]{};
	private static final Object[] DONNEES_PRESENTES = new Object[]{1};
	private static final Object REPONSE = null;
	private static final Object REMARQUE = new Object();
	private static final Object CHAMP = null;
}

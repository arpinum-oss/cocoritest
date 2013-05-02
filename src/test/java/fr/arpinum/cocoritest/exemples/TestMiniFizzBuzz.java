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

package fr.arpinum.cocoritest.exemples;

import static fr.arpinum.cocoritest.Affirmations.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.extensionlangage.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestMiniFizzBuzz {

	@Before
	public void avantChaqueTest() {
		fizzBuzz = new MiniFizzBuzz();
	}

	@Test
	public void fizzBuzzRenvoie100Eléments() {
		List<String> valeurs = fizzBuzz.énonce();

		alors().les(valeurs).sontAuNombreDe(100);
		alors().la(valeur(valeurs, 0)).est("1");
		alors().les(valeurs).respectent(aucunElémentNEstNul());
	}

	@Test
	public void fizzBuzzDitFizzPourUnMultipleDe3() {
		List<String> valeurs = fizzBuzz.énonce();

		alors().la(valeur(valeurs, 2)).est("Fizz");
		alors().la(valeur(valeurs, 5)).est("Fizz");
	}

	private String valeur(List<String> valeurs, int indice) {
		return valeurs.get(indice);
	}

	private Specification<Collection<String>> aucunElémentNEstNul() {
		return new Specification<Collection<String>>() {
			@Override
			public boolean estInsatisfaitePar(Collection<String> objet) {
				for (String s : objet) {
					if (s == null) {
						return true;
					}
				}
				return false;
			}

			@Override
			public String messageInsatisfactionPour(Collection<String> objet) {
				return "Un élément est nul parmi " + objet;
			}
		};
	}

	private static class MiniFizzBuzz {

		public List<String> énonce() {
			List<String> résultat = Listes.cree();
			for (int i = 1; i <= 100; i++) {
				résultat.add(valeurPour(i));
			}
			return résultat;
		}

		private String valeurPour(int i) {
			return i % 3 == 0 ? "Fizz" : String.valueOf(i);
		}
	}

	private MiniFizzBuzz fizzBuzz;
}


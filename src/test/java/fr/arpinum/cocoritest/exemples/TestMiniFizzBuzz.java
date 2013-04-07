package fr.arpinum.cocoritest.exemples;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.cocoritest.outils.Listes;
import fr.arpinum.cocoritest.specification.Specification;

public class TestMiniFizzBuzz {

	@Before
	public void avantChaqueTest() {
		fizzBuzz = new MiniFizzBuzz();
	}

	@Test
	public void fizzBuzzRenvoie100Eléments() {
		List<String> valeurs = fizzBuzz.énonce();

		alorsLes(valeurs).sontAuNombreDe(100);
		alorsLa(valeur(valeurs, 0)).est("1");
		alorsLes(valeurs).respectent(aucunElémentNEstNul());
	}

	@Test
	public void fizzBuzzDitFizzPourUnMultipleDe3() {
		List<String> valeurs = fizzBuzz.énonce();

		alorsLa(valeur(valeurs, 2)).est("Fizz");
		alorsLa(valeur(valeurs, 5)).est("Fizz");
	}

	private String valeur(List<String> valeurs, int indice) {
		return valeurs.get(indice);
	}

	private Specification<Collection<String>> aucunElémentNEstNul() {
		return new Specification<Collection<String>>() {
			@Override
			public boolean estSatisfaitePar(Collection<String> objet) {
				for (String s : objet) {
					if (s == null) {
						return false;
					}
				}
				return true;
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


package fr.arpinum.exemples;

import static fr.arpinum.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.arpinum.outils.Listes;

public class TestMiniFizzBuzz {

	@Before
	public void avantChaqueTest() {
		fizzBuzz = new MiniFizzBuzz();
	}

	@Test
	public void fizzBuzzRenvoie100Eléments() {
		List<String> valeurs = fizzBuzz.énonce();

		alorsLes(valeurs).sontAuNombreDe(100);
		alors(valeurs.get(0)).est("1");
	}

	@Test
	public void fizzBuzzDitFizzPourUnMultipleDe3() {
		List<String> valeurs = fizzBuzz.énonce();

		alors(valeurs.get(2)).est("Fizz");
		alors(valeurs.get(5)).est("Fizz");
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


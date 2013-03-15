package fr.arpinum.affirmation.objet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;

public class TestAffirmationObjet {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		creeAffirmation(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifférent() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est 1 et non 2.");

		creeAffirmation(1).est(2);
	}

	@Test
	public void onPeutAffirmerQuUnNombreNEstPasUnNombreDifférent() {
		creeAffirmation(1).nEstPas(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreNEstPasLeMêmeNombre() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est 1 alors que ce n'était pas voulu.");

		creeAffirmation(1).nEstPas(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifférente() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non tutu.");

		creeAffirmation("toto").est("tutu");
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		creeAffirmation("toto").est(null);
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNulEstNonNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null et non tutu.");

		creeAffirmation((String) null).est("tutu");
	}

	private static <T> AffirmationObjet<T> creeAffirmation(T valeur) {
		return new AffirmationObjet<T>(valeur) {
		};
	}
}

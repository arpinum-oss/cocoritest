package fr.arpinum.affirmations;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationObjet {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		new AffirmationObjet<Integer>(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifférent() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est 1 et non 2.");

		new AffirmationObjet<Integer>(1).est(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifférente() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non tutu.");

		new AffirmationObjet<String>("toto").est("tutu");
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		new AffirmationObjet<String>("toto").est(null);
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNullEstNonNull() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null et non tutu.");

		new AffirmationObjet<String>(null).est("tutu");
	}
}

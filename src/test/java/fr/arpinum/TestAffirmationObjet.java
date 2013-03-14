package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationObjet {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		new AffirmationObjet(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifférent() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("La valeur est 1 et non 2.");

		new AffirmationObjet(1).est(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifférente() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("La valeur est toto et non tutu.");

		new AffirmationObjet("toto").est("tutu");
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		new AffirmationObjet("toto").est(null);
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNullEstNonNull() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("La valeur est null et non tutu.");

		new AffirmationObjet(null).est("tutu");
	}
}

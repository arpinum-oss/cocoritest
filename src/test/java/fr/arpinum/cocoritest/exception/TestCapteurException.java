package fr.arpinum.cocoritest.exception;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Test;

public class TestCapteurException {

	@Test
	public void peutCapturerUneException() {
		CapteurExceptionDeBase capteur = new CapteurExceptionDeBase();

		Exception exception = capteur.capte(actionLevantUneException());

		alors().cette(exception).nEstPasNulle();
		alors().ceci(exception.getMessage()).est("le message");
		alors().ceci(exception instanceof RuntimeException).estVrai();
	}

	private Action actionLevantUneException() {
		return new Action() {
			@Override
			public void démarre() {
				throw new RuntimeException("le message");
			}
		};
	}
}

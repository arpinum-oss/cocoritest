package fr.arpinum.cocoritest.exception;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import org.junit.Test;

public class TestCapteurException {

	@Test
	public void peutCapturerUneException() {
		CapteurException capteur = new CapteurException();

		Exception exception = capteur.capte(new Action() {
			@Override
			public void démarre() throws Exception {
				throw new RuntimeException("le message");
			}
		});

		alors().cette(exception).nEstPasNulle();
		alors().ceci(exception.getMessage()).est("le message");
		alors().ceci(exception instanceof RuntimeException).estVrai();
	}
}

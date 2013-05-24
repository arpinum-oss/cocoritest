package fr.arpinum.cocoritest.interne.exception;

import static fr.arpinum.cocoritest.Affirmations.*;
import static fr.arpinum.cocoritest.Outils.*;

import org.junit.Test;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.exception.CapteurException;

public class TestCapteurException {

	@Test
	public void peutCapturerUneException() {
		CapteurException capteur = créeCapteur();

		Exception exception = capteur.capte(actionLevantUneException());

		alors().cette(exception).nEstPasNulle();
		alors().ceci(exception.getMessage()).est("le message");
		alors().ceci(exception instanceof RuntimeException).estVrai();
	}

	private Action actionLevantUneException() {
		return new Action() {
			@Override
			public void exécute() {
				throw new RuntimeException("le message");
			}
		};
	}
}

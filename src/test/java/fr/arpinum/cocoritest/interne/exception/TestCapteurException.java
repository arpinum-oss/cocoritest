package fr.arpinum.cocoritest.interne.exception;

import fr.arpinum.cocoritest.exception.Action;
import fr.arpinum.cocoritest.exception.CapteurException;
import org.junit.Test;

import static fr.arpinum.cocoritest.Affirmations.alors;
import static fr.arpinum.cocoritest.Outils.créeCapteur;

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
        return () -> {
            throw new RuntimeException("le message");
        };
    }
}

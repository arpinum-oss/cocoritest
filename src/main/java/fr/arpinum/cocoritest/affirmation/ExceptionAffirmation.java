package fr.arpinum.cocoritest.affirmation;

/**
 * Exception levée pour indiquer qu'une affirmation est fausse.
 */
public class ExceptionAffirmation extends RuntimeException {

	public ExceptionAffirmation(String message) {
		super(message);
	}
}

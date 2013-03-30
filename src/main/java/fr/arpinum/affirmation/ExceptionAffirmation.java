package fr.arpinum.affirmation;

/**
 * Exception levée pour indiquer qu'une affirmation est fausse.
 */
public class ExceptionAffirmation extends AssertionError {

	public ExceptionAffirmation(String message) {
		super(message);
	}
}

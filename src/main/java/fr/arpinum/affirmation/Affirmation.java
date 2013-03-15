package fr.arpinum.affirmation;

public class Affirmation {

	protected void échoue(String raison, Object... supplément) {
		throw new ExceptionAffirmation(String.format(raison, supplément));
	}
}

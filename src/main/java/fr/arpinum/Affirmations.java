package fr.arpinum;

public class Affirmations {

	public static AffirmationBooleene alors(boolean valeur) {
		return new AffirmationBooleene(valeur);
	}

	public static AffirmationBooleene alorsLe(boolean booléen) {
		return alors(booléen);
	}

	public static AffirmationBooleene alorsLa(boolean booléen) {
		return alors(booléen);
	}

	public static <T> AffirmationObjet alors(T valeur) {
		return new AffirmationObjet(valeur);
	}

	public static <T> AffirmationObjet alorsLe(T valeur) {
		return alors(valeur);
	}

	public static <T> AffirmationObjet alorsLa(T valeur) {
		return alors(valeur);
	}
}

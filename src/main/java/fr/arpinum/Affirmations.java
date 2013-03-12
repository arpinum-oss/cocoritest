package fr.arpinum;

public class Affirmations {

	public static AffirmationBooléene alors(boolean valeur) {
		return new AffirmationBooléene(valeur);
	}

	public static AffirmationBooléene alorsLe(boolean booléen) {
		return alors(booléen);
	}

	public static AffirmationBooléene alorsLa(boolean booléen) {
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
